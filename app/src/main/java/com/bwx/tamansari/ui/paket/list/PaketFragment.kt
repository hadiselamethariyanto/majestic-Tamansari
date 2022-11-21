package com.bwx.tamansari.ui.paket.list

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TravelPackageDomain
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentPaketBinding
import com.bwx.tamansari.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class PaketFragment : BaseFragment<FragmentPaketBinding>(FragmentPaketBinding::inflate) {

    private val viewModel: PaketViewModel by viewModel()
    private lateinit var adapter: PaketAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PaketAdapter()
        adapter.setOnItemClickCallback(object : PaketAdapter.OnItemClickCallback {
            override fun onItemClicked(data: TravelPackageDomain) {
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

        viewModel.getTravelPackage().observe(viewLifecycleOwner) { res ->
            when (res) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    val packages = res.data ?: arrayListOf()
                    if (packages.isNotEmpty()) {
                        binding.rvPaket.visibility = View.VISIBLE
                        adapter.updateData(packages)
                    } else {
                        binding.rvPaket.visibility = View.GONE
                    }
                }
                is Resource.Error -> {

                }
            }
        }
    }
}