package com.bwx.tamansari.ui.peta

import android.Manifest
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.MapsOutletDomain
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentPetaBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PetaFragment : BaseFragment<FragmentPetaBinding>(FragmentPetaBinding::inflate),
    OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    private val viewModel: MapsViewModel by viewModel()
    private val boundsBuilder = LatLngBounds.Builder()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.maps.onCreate(savedInstanceState)
        binding.maps.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(requireActivity(), R.raw.map_style))

        mMap.uiSettings.isZoomControlsEnabled = false
        mMap.uiSettings.isIndoorLevelPickerEnabled = false
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true

        viewModel.getMapsOutlet().observe(viewLifecycleOwner, mapsObserver)

        getMyLocation()
    }

    private val mapsObserver = Observer<Resource<List<MapsOutletDomain>>> { res ->
        when (res) {
            is Resource.Loading -> {

            }
            is Resource.Success -> {
                val outlets = res.data ?: arrayListOf()
                for (x in outlets) {
                    val location = LatLng(x.latitude, x.longitude)
                    boundsBuilder.include(location)
                    var icon = 0
                    when (x.type) {
                        1 -> {
                            icon = R.drawable.ic_map_attraction
                        }
                        2 -> {
                            icon = R.drawable.ic_maps_restaurant
                        }
                        5 -> {
                            icon = R.drawable.ic_maps_hotel
                        }
                    }

                    mMap.addMarker(
                        MarkerOptions()
                            .position(location)
                            .title(x.name)
                            .snippet(x.address)
                            .icon(vectorToBitmap(icon))
                    )
                }

                val bounds: LatLngBounds = boundsBuilder.build()
                mMap.moveCamera(
                    CameraUpdateFactory.newLatLngBounds(
                        bounds,
                        resources.displayMetrics.widthPixels,
                        resources.displayMetrics.heightPixels,
                        300
                    )
                )
            }
            is Resource.Error -> {

            }
        }
    }

    private fun vectorToBitmap(@DrawableRes id: Int): BitmapDescriptor {
        val vectorDrawable = ResourcesCompat.getDrawable(resources, id, null)
        if (vectorDrawable == null) {
            Log.e("BitmapHelper", "Resource not found")
            return BitmapDescriptorFactory.defaultMarker()
        }
        val bitmap = Bitmap.createBitmap(
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                getMyLocation()
            }
        }

    private fun getMyLocation() {
        if (ContextCompat.checkSelfPermission(
                requireActivity(),
                ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            mMap.isMyLocationEnabled = true
        } else {
            requestPermissionLauncher.launch(ACCESS_FINE_LOCATION)
        }
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