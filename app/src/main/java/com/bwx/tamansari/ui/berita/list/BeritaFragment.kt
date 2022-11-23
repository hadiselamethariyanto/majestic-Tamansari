package com.bwx.tamansari.ui.berita.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import banyuwangi.digital.core.data.Resource
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentBeritaBinding
import banyuwangi.digital.core.domain.model.NewsDomain
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.DataDummy
import org.koin.androidx.viewmodel.ext.android.viewModel


class BeritaFragment : BaseFragment<FragmentBeritaBinding>(FragmentBeritaBinding::inflate) {

    private val viewModel: NewsViewModel by viewModel()
    private lateinit var adapter: BeritaAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = BeritaAdapter()
        adapter.setOnItemClickCallback(object : BeritaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: NewsDomain) {
                val bundle = bundleOf("berita" to data)
                findNavController().navigate(
                    R.id.action_navigation_news_to_navigation_detail_news,
                    bundle
                )
            }
        })

        binding.rvBerita.adapter = adapter
        binding.rvBerita.addItemDecoration(
            DividerItemDecoration(
                requireActivity(),
                LinearLayoutManager.VERTICAL
            )
        )

        viewModel.getNews().observe(viewLifecycleOwner) { res ->
            when (res) {
                is Resource.Loading -> {
                    setLoading(true)
                }
                is Resource.Success -> {
                    setLoading(false)
                    val news = res.data ?: arrayListOf()
                    if (news.isNotEmpty()) {
                        binding.rvBerita.visibility = View.VISIBLE
                        adapter.updateData(news)
                    } else {
                        binding.rvBerita.visibility = View.GONE
                    }
                }
                is Resource.Error -> {
                    setLoading(false)
                    Toast.makeText(requireActivity(),res.message.toString(),Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun setLoading(isLoading: Boolean) {
        binding.llLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
        binding.rvBerita.visibility = if (isLoading) View.GONE else View.VISIBLE
    }
}