package com.bwx.tamansari.ui.homestay.detail

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentDetailHomestayBinding
import com.bwx.tamansari.model.HomestayDomain
import com.bwx.tamansari.ui.base.BaseFragment
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

        val photos = homestay?.foto ?: arrayListOf()
        if (photos.isNotEmpty() && photos.size >= 3) {
            Glide.with(requireActivity()).load(photos[0]).placeholder(R.drawable.placeholder)
                .into(binding.imgFirstHomestay)
            Glide.with(requireActivity()).load(photos[1]).placeholder(R.drawable.placeholder)
                .into(binding.imgSecondaryHomestay)
            Glide.with(requireActivity()).load(photos[2]).placeholder(R.drawable.placeholder)
                .into(binding.imgThirdHomestay)
        }

        binding.tvHomestayName.text = homestay?.nama
        binding.star.numStars = homestay?.star?.toInt() ?: 1
        binding.star.rating = homestay?.star ?: 1f
        binding.tvCheckIn.text = homestay?.checkIn
        binding.tvCheckOut.text = homestay?.checkOut
        binding.tvAddress.text = homestay?.address

        val facilitiesAdapter = FacilitiesAdapter(homestay?.facilities ?: arrayListOf())
        binding.rvFasilitas.adapter = facilitiesAdapter

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
                .title(homestay?.nama)
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