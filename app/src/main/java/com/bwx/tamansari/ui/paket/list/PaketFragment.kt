package com.bwx.tamansari.ui.paket.list

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentPaketBinding
import com.bwx.tamansari.model.PaketWisataModel
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.DataDummy


class PaketFragment : BaseFragment<FragmentPaketBinding>(FragmentPaketBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PaketAdapter()
        adapter.updateData(DataDummy.generateTravelPackage())
        adapter.setOnItemClickCallback(object : PaketAdapter.OnItemClickCallback {
            override fun onItemClicked(data: PaketWisataModel) {
                val bundle = bundleOf("paket" to data)
                findNavController().navigate(
                    R.id.action_navigation_travel_package_to_navigation_detail_travel_packaage,
                    bundle
                )
            }
        })
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvPaket.layoutManager = layoutManager
        binding.rvPaket.adapter = adapter
    }
}