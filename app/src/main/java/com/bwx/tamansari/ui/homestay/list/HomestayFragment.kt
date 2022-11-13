package com.bwx.tamansari.ui.homestay.list

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentHomestayBinding
import com.bwx.tamansari.model.HomestayDomain
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.DataDummy


class HomestayFragment : BaseFragment<FragmentHomestayBinding>(FragmentHomestayBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupHomestay()
    }

    private fun setupHomestay() {
        val adapter = HomestayAdapter()
        adapter.updateData(DataDummy.generateHomestay())
        adapter.setOnItemClickCallback(object : HomestayAdapter.OnItemClickCallback {
            override fun onItemClicked(data: HomestayDomain) {
                val bundle = bundleOf("homestay" to data)
                findNavController().navigate(
                    R.id.action_navigation_homestay_to_navigation_detail_homestay,
                    bundle
                )
            }
        })
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvHomestay.adapter = adapter
        binding.rvHomestay.layoutManager = layoutManager
    }
}