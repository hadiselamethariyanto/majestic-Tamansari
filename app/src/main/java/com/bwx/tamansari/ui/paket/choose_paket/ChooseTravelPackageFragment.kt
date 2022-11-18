package com.bwx.tamansari.ui.paket.choose_paket


import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentChooseTravelPackageBinding
import com.bwx.tamansari.model.PaketWisataModel
import com.bwx.tamansari.model.TravelPackageDomain
import com.bwx.tamansari.ui.base.BaseFragment

class ChooseTravelPackageFragment :
    BaseFragment<FragmentChooseTravelPackageBinding>(FragmentChooseTravelPackageBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val travelPackage = arguments?.getParcelable<PaketWisataModel>("package")
        val travelPackages =
            arguments?.getParcelableArrayList<TravelPackageDomain>("packages") ?: arrayListOf()

        val adapter = TravelPackageAdapter(travelPackages)
        adapter.setOnItemClickCallback(object : TravelPackageAdapter.OnItemClickCallback {
            override fun onItemClicked(data: TravelPackageDomain) {
                val bundle = bundleOf("package_type" to data, "package" to travelPackage)
                findNavController().navigate(
                    R.id.action_navigation_choose_travel_package_to_navigation_review_transaction_travel_package,
                    bundle
                )
            }
        })
        binding.rvTravelPackage.adapter = adapter


    }
}