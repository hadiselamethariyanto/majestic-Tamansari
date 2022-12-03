package com.bwx.tamansari.ui.restaurant.review

import android.os.Bundle
import android.view.View
import banyuwangi.digital.core.domain.model.HomestayDomain
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentChooseLocationBinding
import com.bwx.tamansari.ui.base.BaseBottomSheetDialog
import org.koin.androidx.navigation.koinNavGraphViewModel


class ChooseLocationFragment :
    BaseBottomSheetDialog<FragmentChooseLocationBinding>(FragmentChooseLocationBinding::inflate) {

    private val viewModel: ReviewTransactionRestaurantViewModel by koinNavGraphViewModel(R.id.navigation_review_transaction_restaurant)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ChooseLocationAdapter()
        adapter.setOnItemClickCallback(object : ChooseLocationAdapter.OnItemClickCallback {
            override fun onItemClicked(data: HomestayDomain) {
                viewModel.setSelectedHomestay(data)
                dismiss()
            }
        })
        binding.rvLocation.adapter = adapter
        viewModel.dataHomestays.observe(viewLifecycleOwner) { homestays ->
            adapter.updateData(homestays)
        }
    }
}