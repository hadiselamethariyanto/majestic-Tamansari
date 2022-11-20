package com.bwx.tamansari.ui.homestay.detail

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.domain.model.HomestayDomain
import com.bumptech.glide.Glide
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentDetailHomestayBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.Utils
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class DetailHomestayFragment :
    BaseFragment<FragmentDetailHomestayBinding>(FragmentDetailHomestayBinding::inflate),
    OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var homestay: HomestayDomain? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homestay = arguments?.getParcelable("homestay")

        val photos = homestay?.photos ?: arrayListOf()
        if (photos.isNotEmpty() && photos.size >= 3) {
            Glide.with(requireActivity()).load(photos[0]).placeholder(R.drawable.placeholder)
                .into(binding.imgFirstHomestay)
            Glide.with(requireActivity()).load(photos[1]).placeholder(R.drawable.placeholder)
                .into(binding.imgSecondaryHomestay)
            Glide.with(requireActivity()).load(photos[2]).placeholder(R.drawable.placeholder)
                .into(binding.imgThirdHomestay)
        }

        binding.tvHomestayName.text = homestay?.name
        binding.star.numStars = homestay?.rating?.toInt() ?: 1
        binding.star.rating = homestay?.rating ?: 1f
        binding.tvCheckIn.text = homestay?.checkIn
        binding.tvCheckOut.text = homestay?.checkOut
        binding.tvAddress.text = homestay?.address

//        val facilitiesAdapter = FacilitiesAdapter(homestay?.facilities ?: arrayListOf())
//        binding.rvFasilitas.adapter = facilitiesAdapter

        val rooms = homestay?.rooms?: arrayListOf()
        rooms.sortedBy { it.price }

        if (rooms.isNotEmpty()) {
            binding.rlChooseRoom.visibility = View.VISIBLE
            binding.tvPriceStartFrom.text = "IDR ${Utils.thousandSeparator(rooms[0].price)}"
        } else {
            binding.rlChooseRoom.visibility = View.GONE
        }

        binding.btnChooseRoom.setOnClickListener {
            val bundle = bundleOf("homestay" to homestay)
            findNavController().navigate(
                R.id.action_navigation_detail_homestay_to_navigation_choose_room,
                bundle
            )
        }

        binding.maps.onCreate(savedInstanceState)
        binding.maps.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isIndoorLevelPickerEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true

        val startLocation = LatLng(homestay?.latitude ?: 0.0, homestay?.longitude ?: 0.0)
        mMap.addMarker(
            MarkerOptions()
                .position(startLocation)
                .title(homestay?.name)
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startLocation, 17f))
    }

    override fun onStart() {
        super.onStart()
        binding.maps.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.maps.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.maps.onPause()
    }

    override fun onStop() {
        super.onStop()
        binding.maps.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.maps.onLowMemory()
    }
}