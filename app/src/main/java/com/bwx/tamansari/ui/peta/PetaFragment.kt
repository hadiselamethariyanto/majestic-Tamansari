package com.bwx.tamansari.ui.peta

import android.os.Bundle
import android.view.View
import com.bwx.tamansari.databinding.FragmentPetaBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng

class PetaFragment : BaseFragment<FragmentPetaBinding>(FragmentPetaBinding::inflate),
    OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.maps.onCreate(savedInstanceState)
        binding.maps.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isIndoorLevelPickerEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true

        val startLocation = LatLng(-8.167879, 114.2521131)
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