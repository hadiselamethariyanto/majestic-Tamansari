package com.bwx.tamansari.ui.wisata.review

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentReviewTransactionWisataBinding
import com.bwx.tamansari.model.ChartDomain
import com.bwx.tamansari.model.WisataDomain
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.Utils


class ReviewTransactionWisataFragment :
    BaseFragment<FragmentReviewTransactionWisataBinding>(FragmentReviewTransactionWisataBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val charts = arguments?.getParcelableArrayList<ChartDomain>("charts")?: arrayListOf()
        val wisata = arguments?.getParcelable<WisataDomain>("wisata")

        val totalPayment = charts.sumOf { it.total * it.productPrice }

        Glide.with(requireActivity()).load(wisata?.foto).placeholder(R.drawable.placeholder)
            .into(binding.imgWisata)
        binding.tvWisataName.text = wisata?.nama

        binding.tvCustomerName.text = "Muhammad Hadi"
        binding.tvCustomerPhone.text = "+6282244087798"
        binding.tvCustomerEmail.text = "adybeldex@gmail.com"

        binding.tvTotalFee.text = "IDR ${Utils.thousandSeparator(totalPayment)}"
        binding.tvTotalPayment.text = "IDR ${Utils.thousandSeparator(totalPayment)}"

        val adapter = ReviewTransactionWisataAdapter(charts)
        binding.rvChart.adapter = adapter
    }
}