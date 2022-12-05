package com.bwx.tamansari.ui.search

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import banyuwangi.digital.core.data.Resource
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentSearchBinding
import com.bwx.tamansari.ui.base.BaseBottomSheetDialog
import com.bwx.tamansari.utils.Utils.textChanges
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchFragment :
    BaseBottomSheetDialog<FragmentSearchBinding>(FragmentSearchBinding::inflate) {

    private val viewModel: SearchViewModel by viewModel()
    private lateinit var adapter: SearchAdapter

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SearchAdapter()
        binding.rvLocation.adapter = adapter

        binding.etSearch.textChanges().debounce(300).filterNot { it.isNullOrBlank() }
            .onEach {
                if (it?.isNotEmpty() == true) {
                    search(it.toString())
                }
            }
            .launchIn(lifecycleScope)
    }

    private fun search(keyword: String) {
        viewModel.search(keyword).observe(viewLifecycleOwner) { res ->
            when (res) {
                is Resource.Loading -> {
                    setLoading(true)
                }
                is Resource.Success -> {
                    setLoading(false)
                    val data = res.data ?: arrayListOf()
                    if (data.isNotEmpty()) {
                        binding.rvLocation.visibility = View.VISIBLE
                        binding.llEmpty.visibility = View.GONE
                        adapter.updateData(data)
                    } else {
                        val searchKeyword = binding.etSearch.text.toString()
                        binding.rvLocation.visibility = View.GONE
                        binding.llEmpty.visibility = View.VISIBLE
                        binding.tvSearchEmpty.text =
                            getString(R.string.no_search_result_found, searchKeyword)
                    }
                }
                is Resource.Error -> {
                    setLoading(false)
                    Toast.makeText(requireActivity(), res.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun setLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.rvLocation.visibility = View.GONE
            binding.shimmerSearch.visibility = View.VISIBLE
            binding.shimmerSearch.startShimmer()
        } else {
            binding.rvLocation.visibility = View.VISIBLE
            binding.shimmerSearch.visibility = View.GONE
            binding.shimmerSearch.stopShimmer()
        }
    }

    override fun onResume() {
        super.onResume()
        binding.shimmerSearch.startShimmer()
    }

    override fun onPause() {
        binding.shimmerSearch.stopShimmer()
        super.onPause()
    }

}