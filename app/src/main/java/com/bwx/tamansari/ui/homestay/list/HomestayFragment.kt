package com.bwx.tamansari.ui.homestay.list

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.HomestayDomain
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentHomestayBinding
import com.bwx.tamansari.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomestayFragment : BaseFragment<FragmentHomestayBinding>(FragmentHomestayBinding::inflate) {

    private val viewModel: HomestayViewModel by viewModel()
    private lateinit var adapter: HomestayAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupHomestay()

        viewModel.getHomestay().observe(viewLifecycleOwner) { res ->
            when (res) {
                is Resource.Loading -> {
                    setLoading(true)
                }
                is Resource.Success -> {
                    setLoading(false)
                    val homestays = res.data ?: arrayListOf()
                    if (homestays.isNotEmpty()) {
                        binding.rvHomestay.visibility = View.VISIBLE
                        adapter.updateData(homestays)
                    } else {
                        binding.rvHomestay.visibility = View.GONE
                    }
                }
                is Resource.Error -> {
                    setLoading(false)
                }
            }
        }
    }

    private fun setLoading(isLoading: Boolean) {
        binding.llLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
        binding.rvHomestay.visibility = if (isLoading) View.GONE else View.VISIBLE
    }

    private fun setupHomestay() {
        adapter = HomestayAdapter()
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