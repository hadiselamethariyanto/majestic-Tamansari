package com.bwx.tamansari.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.BannerDomain
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentHomeBinding
import com.bwx.tamansari.model.MenuModel
import com.bwx.tamansari.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var adapter: PromoAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMenu()
        setupPromo()

        binding.etSearch.isFocusable = false
        binding.etSearch.isClickable = true
        binding.etSearch.setOnClickListener {
            findNavController().navigate(R.id.navigation_search)
        }

        viewModel.getBanner().observe(viewLifecycleOwner, bannerObserver)

    }

    private fun setupMenu() {
        val list = ArrayList<MenuModel>()
        list.add(MenuModel("Wisata", R.drawable.ic_wisata))
        list.add(MenuModel("Homestay", R.drawable.ic_homestay))
        list.add(MenuModel("Paket", R.drawable.ic_travel_package))
        list.add(MenuModel("Restoran", R.drawable.ic_restaurant))
        list.add(MenuModel("Peta", R.drawable.ic_maps))
        list.add(MenuModel("Berita", R.drawable.ic_berita))
        list.add(MenuModel("TPS3R", R.drawable.ic_tps3r))

        val gridLayoutManager = GridLayoutManager(activity, 5, GridLayoutManager.VERTICAL, false)
        val adapter = MenuGridAdapter(list, requireActivity())
        adapter.setOnItemClickCallback(object : MenuGridAdapter.OnItemClickCallback {
            override fun onItemClicked(data: MenuModel, position: Int) {
                when (position) {
                    0 -> {
                        findNavController().navigate(R.id.action_navigation_home_to_daftarWisataFragment)
                    }
                    1 -> {
                        findNavController().navigate(R.id.action_navigation_home_to_navigation_homestay)
                    }
                    2 -> {
                        findNavController().navigate(R.id.action_navigation_home_to_navigation_travel_package)
                    }
                    3 -> {
                        findNavController().navigate(R.id.action_navigation_home_to_navigation_restaurant)
                    }
                    4 -> {
                        findNavController().navigate(R.id.navigation_maps)
                    }
                    5 -> {
                        findNavController().navigate(R.id.action_navigation_home_to_navigation_news)
                    }
                    6 -> {
                        findNavController().navigate(R.id.action_navigation_home_to_navigation_tpsr)
                    }
                }
            }
        })

        binding.menu.layoutManager = gridLayoutManager
        binding.menu.adapter = adapter
    }

    private fun setupPromo() {
        adapter = PromoAdapter()
        val linearLayoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        binding.promo.layoutManager = linearLayoutManager
        binding.promo.adapter = adapter
    }

    private val bannerObserver = Observer<Resource<List<BannerDomain>>> { res ->
        when (res) {
            is Resource.Loading -> {
                setLoading(true)
            }
            is Resource.Success -> {
                setLoading(false)
                val banners = res.data ?: arrayListOf()
                adapter.updateData(banners)
            }
            is Resource.Error -> {
                setLoading(false)
                Toast.makeText(requireActivity(), res.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.promo.visibility = View.GONE
            binding.shimmerBanner.visibility = View.VISIBLE
            binding.shimmerBanner.startShimmer()
        } else {
            binding.promo.visibility = View.VISIBLE
            binding.shimmerBanner.visibility = View.GONE
            binding.shimmerBanner.stopShimmer()
        }
    }

    override fun onResume() {
        super.onResume()
        binding.shimmerBanner.startShimmer()
    }

    override fun onPause() {
        binding.shimmerBanner.stopShimmer()
        super.onPause()
    }

}