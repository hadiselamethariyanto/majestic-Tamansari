package com.bwx.tamansari.ui.wisata.detail

import android.os.Bundle
import android.view.View
import banyuwangi.digital.core.domain.model.WisataDomain
import com.bwx.tamansari.databinding.FragmentOverviewWisataBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.Gson

private const val ARG_PARAM_WISATA = "wisata"

class OverviewWisataFragment :
    BaseFragment<FragmentOverviewWisataBinding>(FragmentOverviewWisataBinding::inflate),
    OnMapReadyCallback {
    private var wisataJson: String? = null
    private var wisata: WisataDomain? = null
    private lateinit var mMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            wisataJson = it.getString(ARG_PARAM_WISATA)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        wisata = Gson().fromJson(wisataJson, WisataDomain::class.java)

        binding.tvOverview.text = wisata?.description

        binding.maps.onCreate(savedInstanceState)
        binding.maps.getMapAsync(this)
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            OverviewWisataFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM_WISATA, param1)
                }
            }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isIndoorLevelPickerEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true

        val startLocation = LatLng(wisata?.latitude ?: 0.0, wisata?.longitude ?: 0.0)
        mMap.addMarker(
            MarkerOptions()
                .position(startLocation)
                .title(wisata?.name)
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