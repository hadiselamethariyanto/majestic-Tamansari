package com.bwx.tamansari.ui.berita.list

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentBeritaBinding
import com.bwx.tamansari.model.BeritaModel
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.DataDummy


class BeritaFragment : BaseFragment<FragmentBeritaBinding>(FragmentBeritaBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BeritaAdapter()
        adapter.updateData(DataDummy.generateNews())
        adapter.setOnItemClickCallback(object : BeritaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: BeritaModel) {
                val bundle = bundleOf("berita" to data)
                findNavController().navigate(R.id.action_navigation_news_to_navigation_detail_news, bundle)
            }
        })

        binding.rvBerita.adapter = adapter
        binding.rvBerita.addItemDecoration(
            DividerItemDecoration(
                requireActivity(),
                LinearLayoutManager.VERTICAL
            )
        )
    }
}