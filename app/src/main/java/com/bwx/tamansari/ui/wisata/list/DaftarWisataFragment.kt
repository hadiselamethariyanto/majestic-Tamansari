package com.bwx.tamansari.ui.wisata.list

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentDaftarWisataBinding
import com.bwx.tamansari.model.WisataDomain
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.DataDummy

class DaftarWisataFragment : BaseFragment<FragmentDaftarWisataBinding>(FragmentDaftarWisataBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWisata()
    }

    private fun setupWisata() {
        val adapter = ListWisataAdapter()
        adapter.updateData(DataDummy.generateWisata())
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