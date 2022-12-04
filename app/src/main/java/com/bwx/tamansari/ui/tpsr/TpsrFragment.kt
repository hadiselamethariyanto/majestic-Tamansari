package com.bwx.tamansari.ui.tpsr

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.databinding.FragmentTpsrBinding
import com.bwx.tamansari.model.HistoryTpsrDomain
import com.bwx.tamansari.ui.base.BaseFragment

class TpsrFragment : BaseFragment<FragmentTpsrBinding>(FragmentTpsrBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRiwayatClaim()
    }

    private fun setupRiwayatClaim() {
        val claim = ArrayList<HistoryTpsrDomain>()
        claim.add(HistoryTpsrDomain("#JHKDSA342", "", 10000, 1670144776000, 1))
        claim.add(HistoryTpsrDomain("#JHKDSA342", "", 10000, 1670144776000, 1))
        claim.add(HistoryTpsrDomain("#JHKDSA342", "", 10000, 1670144776000, 1))
        claim.add(HistoryTpsrDomain("#JHKDSA342", "", 10000, 1670144776000, 1))
        claim.add(HistoryTpsrDomain("#JHKDSA342", "", 10000, 1670144776000, 2))

        val adapter = HistoryTpsrAdapter()
        adapter.updateData(claim)
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvRiwayat.layoutManager = layoutManager
        binding.rvRiwayat.adapter = adapter
    }


}