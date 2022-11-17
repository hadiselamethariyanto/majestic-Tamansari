package com.bwx.tamansari.ui.paket.detail


import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentDetailTravelPackageBinding
import com.bwx.tamansari.model.PaketWisataModel
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.ui.homestay.list.ImageHomestayAdapter
import com.bwx.tamansari.utils.DataDummy
import com.bwx.tamansari.utils.Utils
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class DetailTravelPackageFragment :
    BaseFragment<FragmentDetailTravelPackageBinding>(FragmentDetailTravelPackageBinding::inflate),
    OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var travelPackage: PaketWisataModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        travelPackage = arguments?.getParcelable("paket")

        binding.tvPackageName.text = travelPackage?.nama
        binding.tvRating.text = travelPackage?.rating.toString()
        binding.tvTotalReview.text = "(${travelPackage?.totalReview} Review)"
        binding.tvSold.text = travelPackage?.totalSold.toString()
        binding.tvAddress.text = travelPackage?.address

        val photos = travelPackage?.photos ?: arrayListOf()
        if (photos.isNotEmpty()) {
            Glide.with(requireActivity()).load(photos[0]).placeholder(R.drawable.placeholder)
                .into(binding.imageFirstTravelPackage)
            if (photos.size > 1) {
                val newPhotos = photos.drop(1)
                val imageAdapter = ImageHomestayAdapter(newPhotos)
                binding.rvImage.adapter = imageAdapter
                binding.rvImage.visibility = View.VISIBLE
            } else {
                binding.rvImage.visibility = View.GONE
            }
        }

        val itineraries = travelPackage?.itineraries ?: arrayListOf()
        val itineraryAdapter = ItineraryAdapter(itineraries)
        binding.rvItinerary.adapter = itineraryAdapter

        val travelPackages = DataDummy.generateTravelPackageTicket()
        if (travelPackages.isNotEmpty()) {
            binding.rlChooseTicket.visibility = View.VISIBLE
            binding.tvPriceStartFrom.text =
                "IDR ${Utils.thousandSeparator(travelPackages[0].price)}"
        } else {
            binding.rlChooseTicket.visibility = View.GONE
        }

        binding.btnChooseTicket.setOnClickListener {
            val bundle = bundleOf("package" to travelPackage, "packages" to travelPackages)
            findNavController().navigate(
                R.id.action_navigation_detail_travel_packaage_to_navigation_choose_travel_package,
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

        val startLocation = LatLng(travelPackage?.latitude ?: 0.0, travelPackage?.longitude ?: 0.0)
        mMap.addMarker(
            MarkerOptions()
                .position(startLocation)
                .title(travelPackage?.nama)
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