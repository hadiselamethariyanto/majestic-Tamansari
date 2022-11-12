package com.bwx.tamansari.ui.homestay

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.databinding.FragmentHomestayBinding
import com.bwx.tamansari.model.HomestayModel
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
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvHomestay.adapter = adapter
        binding.rvHomestay.layoutManager = layoutManager
    }
}