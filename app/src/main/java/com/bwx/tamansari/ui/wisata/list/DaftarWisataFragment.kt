package com.bwx.tamansari.ui.wisata.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.WisataDomain
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentDaftarWisataBinding
import com.bwx.tamansari.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DaftarWisataFragment :
    BaseFragment<FragmentDaftarWisataBinding>(FragmentDaftarWisataBinding::inflate) {

    private val viewModel: ListWisataViewModel by viewModel()
    private lateinit var adapter: ListWisataAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWisata()
        viewModel.getWisata().observe(viewLifecycleOwner) { res ->
            when (res) {
                is Resource.Loading -> {
                    setLoading(true)
                }
                is Resource.Success -> {
                    setLoading(false)
                    val wisatas = res.data?: arrayListOf()
                    adapter.updateData(wisatas)
                }
                is Resource.Error -> {
                    setLoading(false)
                }
            }
        }
    }

    private fun setLoading(isLoading:Boolean){
        binding.llLoading.visibility = if(isLoading) View.VISIBLE else View.GONE
        binding.rvWisata.visibility = if (isLoading) View.GONE else View.VISIBLE
    }

    private fun setupWisata() {
        adapter = ListWisataAdapter()
        adapter.setOnItemClickCallback(object : ListWisataAdapter.OnItemClickCallback {
            override fun onItemClicked(data: WisataDomain) {
                val bundle = bundleOf("wisata" to data)
                findNavController().navigate(
                    R.id.action_navigation_daftar_wisata_to_navigation_detail_wisata,
                    bundle
                )
            }
        })
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvWisata.layoutManager = layoutManager
        binding.rvWisata.adapter = adapter
    }

}