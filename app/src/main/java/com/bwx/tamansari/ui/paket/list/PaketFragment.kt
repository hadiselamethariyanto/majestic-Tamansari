package com.bwx.tamansari.ui.paket.list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.databinding.FragmentPaketBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.DataDummy


class PaketFragment : BaseFragment<FragmentPaketBinding>(FragmentPaketBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PaketAdapter()
        adapter.updateData(DataDummy.generateTravelPackage())
        val layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvPaket.layoutManager = layoutManager
        binding.rvPaket.adapter = adapter
    }
}