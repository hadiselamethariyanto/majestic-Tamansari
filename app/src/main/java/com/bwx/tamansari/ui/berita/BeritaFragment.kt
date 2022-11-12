package com.bwx.tamansari.ui.berita

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bwx.tamansari.databinding.FragmentBeritaBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.DataDummy


class BeritaFragment : BaseFragment<FragmentBeritaBinding>(FragmentBeritaBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BeritaAdapter()
        adapter.updateData(DataDummy.generateNews())
        binding.rvBerita.adapter = adapter
        binding.rvBerita.addItemDecoration(
            DividerItemDecoration(
                requireActivity(),
                LinearLayoutManager.VERTICAL
            )
        )
    }
}