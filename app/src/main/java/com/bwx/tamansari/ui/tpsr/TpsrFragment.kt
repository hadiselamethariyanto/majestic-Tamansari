package com.bwx.tamansari.ui.tpsr

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TpsrBalanceDomain
import com.bwx.tamansari.databinding.FragmentTpsrBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.Utils
import org.koin.androidx.viewmodel.ext.android.viewModel

class TpsrFragment : BaseFragment<FragmentTpsrBinding>(FragmentTpsrBinding::inflate) {

    private val viewModel: TpsrViewModel by viewModel()
    private lateinit var adapter: HistoryTpsrAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()

        viewModel.getUser()
        viewModel.user.observe(viewLifecycleOwner) {
            it?.email?.let { it1 ->
                viewModel.getTpsrBalance(it1).observe(viewLifecycleOwner, tpsrBalanceObserver)
            }
        }
    }

    private fun setupAdapter() {
        adapter = HistoryTpsrAdapter()
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvRiwayat.layoutManager = layoutManager
        binding.rvRiwayat.adapter = adapter
    }

    private val tpsrBalanceObserver = Observer<Resource<TpsrBalanceDomain>> { res ->
        when (res) {
            is Resource.Loading -> {

            }
            is Resource.Success -> {
                val data = res.data
                val saldo = data?.saldo
                val history = data?.history?: arrayListOf()
                binding.tvSaldo.text = "IDR ${Utils.thousandSeparator(saldo ?: 0)}"
                adapter.updateData(history)
            }
            is Resource.Error -> {

            }
        }
    }


}