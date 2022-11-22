package com.bwx.tamansari.ui.restaurant.list

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.data.Resource
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentRestaurantBinding
import banyuwangi.digital.core.domain.model.RestaurantDomain
import com.bwx.tamansari.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class RestaurantFragment :
    BaseFragment<FragmentRestaurantBinding>(FragmentRestaurantBinding::inflate) {

    private val viewModel: RestaurantViewModel by viewModel()
    private lateinit var restaurantAdapter: RestaurantAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        restaurantAdapter = RestaurantAdapter()
        restaurantAdapter.setOnItemClickCallback(object : RestaurantAdapter.OnItemClickCallback {
            override fun onItemClicked(data: RestaurantDomain) {
                val bundle = bundleOf("restaurant" to data)
                findNavController().navigate(
                    R.id.action_navigation_restaurant_to_navigation_detail_restaurant,
                    bundle
                )
            }
        })

        binding.rvRestaurant.adapter = restaurantAdapter

        viewModel.getRestaurant().observe(viewLifecycleOwner) { res ->
            when (res) {
                is Resource.Loading -> {
                    setLoading(true)
                }
                is Resource.Success -> {
                    setLoading(false)
                    val restaurants = res.data ?: arrayListOf()
                    if (restaurants.isNotEmpty()) {
                        binding.rvRestaurant.visibility = View.VISIBLE
                        restaurantAdapter.updateData(restaurants)
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
        binding.rvRestaurant.visibility = if (isLoading) View.GONE else View.VISIBLE
    }

}