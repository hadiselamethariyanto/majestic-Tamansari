package com.bwx.tamansari.ui.paket.detail


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TravelPackageDomain
import com.bumptech.glide.Glide
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentDetailTravelPackageBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.ui.homestay.list.ImageHomestayAdapter
import com.bwx.tamansari.utils.Utils
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailTravelPackageFragment :
    BaseFragment<FragmentDetailTravelPackageBinding>(FragmentDetailTravelPackageBinding::inflate),
    OnMapReadyCallback {

    private val viewModel: DetailTravelPackageViewModel by viewModel()
    private lateinit var mMap: GoogleMap
    private var travelPackage: TravelPackageDomain? = null
    private var idTravelPackage:String?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        travelPackage = arguments?.getParcelable("paket")
        idTravelPackage = arguments?.getString("id")

        if (travelPackage != null) {
            setTravelPackageInfo(travelPackage)
            setTravelPackagePhotos(travelPackage)
            setTravelPackageItineraries(travelPackage)
            setTravelPackageTypes(travelPackage)
            navigateToChooseTicket(travelPackage)
        }

        binding.maps.onCreate(savedInstanceState)
        binding.maps.getMapAsync(this)
    }

    private val getDetailTravelPackageObserver = Observer<Resource<TravelPackageDomain>> { res ->
        when (res) {
            is Resource.Loading -> {
                setLoading(true)
            }
            is Resource.Success -> {
                setLoading(false)
                val travelPackage = res.data
                setTravelPackageInfo(travelPackage)
                setTravelPackagePhotos(travelPackage)
                setTravelPackageItineraries(travelPackage)
                setTravelPackageTypes(travelPackage)
                navigateToChooseTicket(travelPackage)
                setMarker(travelPackage)
            }
            is Resource.Error -> {
                setLoading(false)
                Toast.makeText(requireActivity(), res.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setTravelPackageInfo(travelPackage: TravelPackageDomain?) {
        binding.tvPackageName.text = travelPackage?.name
        binding.tvRating.text = travelPackage?.rating.toString()
        binding.tvTotalReview.text = "(${travelPackage?.voteCount} Review)"
        binding.tvSold.text = travelPackage?.totalSold.toString()
        binding.tvAddress.text = travelPackage?.address
    }

    private fun setTravelPackagePhotos(travelPackage: TravelPackageDomain?) {
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
    }

    private fun setTravelPackageItineraries(travelPackage: TravelPackageDomain?) {
        val itineraries = travelPackage?.itinerary ?: arrayListOf()
        val itineraryAdapter = ItineraryAdapter(itineraries)
        binding.rvItinerary.adapter = itineraryAdapter
    }

    private fun setTravelPackageTypes(travelPackage: TravelPackageDomain?) {
        val travelPackageTypes = travelPackage?.travelPackageType ?: arrayListOf()
        if (travelPackageTypes.isNotEmpty()) {
            binding.rlChooseTicket.visibility = View.VISIBLE
            binding.tvPriceStartFrom.text =
                "IDR ${Utils.thousandSeparator(travelPackageTypes[0].price)}"
        } else {
            binding.rlChooseTicket.visibility = View.GONE
        }
    }

    private fun navigateToChooseTicket(travelPackage: TravelPackageDomain?) {
        val travelPackageTypes = travelPackage?.travelPackageType
        binding.btnChooseTicket.setOnClickListener {
            val bundle = bundleOf("package" to travelPackage, "packages" to travelPackageTypes)
            findNavController().navigate(
                R.id.action_navigation_detail_travel_packaage_to_navigation_choose_travel_package,
                bundle
            )
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isIndoorLevelPickerEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true

        if (travelPackage != null){
            setMarker(travelPackage)
        }else{
            idTravelPackage?.let { viewModel.getDetailTravelPackage(it).observe(viewLifecycleOwner, getDetailTravelPackageObserver) }
        }

    }

    private fun setMarker(travelPackage: TravelPackageDomain?){
        val startLocation = LatLng(travelPackage?.latitude ?: 0.0, travelPackage?.longitude ?: 0.0)
        mMap.addMarker(
            MarkerOptions()
                .position(startLocation)
                .title(travelPackage?.name)
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
        binding.rlChooseTicket.visibility = if (isLoading) View.GONE else View.VISIBLE
    }
}