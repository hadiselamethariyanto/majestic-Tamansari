package com.bwx.tamansari.ui.paket.review

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentReviewTransactionTravelPackageBinding
import com.bwx.tamansari.model.PaketWisataModel
import com.bwx.tamansari.model.TravelPackageDomain
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.Utils


class ReviewTransactionTravelPackageFragment :
    BaseFragment<FragmentReviewTransactionTravelPackageBinding>(
        FragmentReviewTransactionTravelPackageBinding::inflate
    ) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val travelPackageDomain = arguments?.getParcelable<TravelPackageDomain>("package_type")
        val travelPackage = arguments?.getParcelable<PaketWisataModel>("package")
        val date = arguments?.getString("date")

        binding.tvTravelPackageName.text = travelPackage?.nama
        val photos = travelPackage?.photos ?: arrayListOf()
        if (photos.isNotEmpty()) {
            Glide.with(requireActivity()).load(photos[0])
                .transform(CenterCrop(), RoundedCorners(24)).placeholder(R.drawable.placeholder)
                .into(binding.imgTravelPackage)
        }
        binding.tvPackageType.text = travelPackageDomain?.name
        binding.tvDate.text = date

        binding.tvCustomerName.text = "Muhammad Hadi"
        binding.tvCustomerPhone.text = "+6282244087798"
        binding.tvCustomerEmail.text = "adybeldex@gmail.com"

        binding.tvTotalFee.text = "IDR ${Utils.thousandSeparator(travelPackageDomain?.price ?: 0)}"

    }

}