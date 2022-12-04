package com.bwx.tamansari.ui.homestay.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.FacilityDomain
import banyuwangi.digital.core.domain.model.HomestayDomain
import banyuwangi.digital.core.domain.model.RoomDomain
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
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailHomestayFragment :
    BaseFragment<FragmentDetailHomestayBinding>(FragmentDetailHomestayBinding::inflate),
    OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var homestay: HomestayDomain? = null
    private var idHomestay: String? = null

    private val viewModel: DetailHomestayViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homestay = arguments?.getParcelable("homestay")
        idHomestay = arguments?.getString("id")

        if (homestay != null) {
            val photos = homestay?.photos ?: arrayListOf()
            val facilities = homestay?.facilities ?: arrayListOf()
            val rooms = homestay?.rooms ?: arrayListOf()

            setHomestayPhotos(photos)
            setHomestayInfo(homestay)
            setupHomestayFacilities(facilities)
            setHomestayRooms(rooms)
            navigateToChooseRoom(homestay)
        }

        binding.maps.onCreate(savedInstanceState)
        binding.maps.getMapAsync(this)
    }

    private fun navigateToChooseRoom(homestay: HomestayDomain?) {
        binding.btnChooseRoom.setOnClickListener {
            val bundle = bundleOf("homestay" to homestay)
            findNavController().navigate(
                R.id.action_navigation_detail_homestay_to_navigation_choose_room,
                bundle
            )
        }

    }

    private fun setHomestayInfo(homestay: HomestayDomain?) {
        binding.tvHomestayName.text = homestay?.name
        binding.star.numStars = homestay?.rating?.toInt() ?: 0
        binding.star.rating = homestay?.rating ?: 0f
        binding.tvCheckIn.text = homestay?.checkIn
        binding.tvCheckOut.text = homestay?.checkOut
        binding.tvAddress.text = homestay?.address
    }

    private fun setupHomestayFacilities(facilities: List<FacilityDomain>) {
        if (facilities.isNotEmpty()) {
            val facilitiesAdapter = FacilitiesAdapter(facilities)
            binding.rvFasilitas.adapter = facilitiesAdapter
            binding.labelFasilitas.visibility = View.VISIBLE
            binding.rvFasilitas.visibility = View.VISIBLE
        } else {
            binding.labelFasilitas.visibility = View.GONE
            binding.rvFasilitas.visibility = View.GONE
        }
    }

    private fun setHomestayPhotos(photos: List<String>) {
        if (photos.isNotEmpty() && photos.size >= 3) {
            Glide.with(requireActivity()).load(photos[0]).placeholder(R.drawable.placeholder)
                .into(binding.imgFirstHomestay)
            Glide.with(requireActivity()).load(photos[1]).placeholder(R.drawable.placeholder)
                .into(binding.imgSecondaryHomestay)
            Glide.with(requireActivity()).load(photos[2]).placeholder(R.drawable.placeholder)
                .into(binding.imgThirdHomestay)
        }
    }

    private fun setHomestayRooms(rooms: List<RoomDomain>) {
        rooms.sortedBy { it.price }

        if (rooms.isNotEmpty()) {
            binding.rlChooseRoom.visibility = View.VISIBLE
            binding.tvPriceStartFrom.text = "IDR ${Utils.thousandSeparator(rooms[0].price)}"
        } else {
            binding.rlChooseRoom.visibility = View.GONE
        }
    }

    private val detailHomestayObserver = Observer<Resource<HomestayDomain>> { res ->
        when (res) {
            is Resource.Loading -> {
                setLoading(true)
            }
            is Resource.Success -> {
                setLoading(false)
                val homestayDomain = res.data

                val photos = homestayDomain?.photos ?: arrayListOf()
                val facilities = homestayDomain?.facilities ?: arrayListOf()
                val rooms = homestayDomain?.rooms ?: arrayListOf()

                setHomestayPhotos(photos)
                setHomestayInfo(homestayDomain)
                setupHomestayFacilities(facilities)
                setHomestayRooms(rooms)
                navigateToChooseRoom(homestayDomain)
                setMarker(homestayDomain)
            }
            is Resource.Error -> {
                setLoading(false)
                Toast.makeText(requireActivity(), res.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isIndoorLevelPickerEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true

        if (homestay !=null){
            setMarker(homestay)
        }else{
            idHomestay?.let {
                viewModel.getDetailHomestay(it).observe(viewLifecycleOwner, detailHomestayObserver)
            }
        }
    }

    private fun setMarker(homestay: HomestayDomain?){
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

    private fun setLoading(isLoading: Boolean) {
        binding.llLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
        binding.clContainer.visibility = if (isLoading) View.GONE else View.VISIBLE
        binding.rlChooseRoom.visibility = if (isLoading) View.GONE else View.VISIBLE
    }
}