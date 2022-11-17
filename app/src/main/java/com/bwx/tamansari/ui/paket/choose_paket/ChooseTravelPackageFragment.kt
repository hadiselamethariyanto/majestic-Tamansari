package com.bwx.tamansari.ui.paket.choose_paket


import android.os.Bundle
import android.view.View
import com.bwx.tamansari.databinding.FragmentChooseTravelPackageBinding
import com.bwx.tamansari.model.TravelPackageDomain
import com.bwx.tamansari.ui.base.BaseFragment

class ChooseTravelPackageFragment :
    BaseFragment<FragmentChooseTravelPackageBinding>(FragmentChooseTravelPackageBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val travelPackages =
            arguments?.getParcelableArrayList<TravelPackageDomain>("packages") ?: arrayListOf()

        val adapter = TravelPackageAdapter(travelPackages)
        binding.rvTravelPackage.adapter = adapter

    }
}