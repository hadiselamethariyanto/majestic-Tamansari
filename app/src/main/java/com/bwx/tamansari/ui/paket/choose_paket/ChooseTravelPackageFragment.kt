package com.bwx.tamansari.ui.paket.choose_paket


import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.domain.model.TravelPackageDomain
import banyuwangi.digital.core.domain.model.TravelPackageTypeDomain
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentChooseTravelPackageBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.Utils
import java.util.*

class ChooseTravelPackageFragment :
    BaseFragment<FragmentChooseTravelPackageBinding>(FragmentChooseTravelPackageBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val travelPackage = arguments?.getParcelable<TravelPackageDomain>("package")
        val travelPackageType =
            arguments?.getParcelableArrayList<TravelPackageTypeDomain>("packages") ?: arrayListOf()

        val adapter = TravelPackageAdapter(travelPackageType)
        adapter.setOnItemClickCallback(object : TravelPackageAdapter.OnItemClickCallback {
            override fun onItemClicked(data: TravelPackageTypeDomain) {
                val date = binding.etDate.text.toString()
                val bundle =
                    bundleOf("package_type" to data, "package" to travelPackage, "date" to date)
                findNavController().navigate(
                    R.id.action_navigation_choose_travel_package_to_navigation_review_transaction_travel_package,
                    bundle
                )
            }
        })
        binding.rvTravelPackage.adapter = adapter

        getToday()
    }

    private fun getToday() {
        val calendar = Calendar.getInstance()
        binding.etDate.setText(Utils.formatCalendarToStringDate(calendar.timeInMillis))
    }
}