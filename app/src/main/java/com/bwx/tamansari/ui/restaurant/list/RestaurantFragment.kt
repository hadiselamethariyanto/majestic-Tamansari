package com.bwx.tamansari.ui.restaurant.list

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentRestaurantBinding
import com.bwx.tamansari.model.RestaurantDomain
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.DataDummy


class RestaurantFragment :
    BaseFragment<FragmentRestaurantBinding>(FragmentRestaurantBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val restaurantAdapter = RestaurantAdapter()
        restaurantAdapter.updateData(DataDummy.generateRestaurant())
        restaurantAdapter.setOnItemClickCallback(object :RestaurantAdapter.OnItemClickCallback{
            override fun onItemClicked(data: RestaurantDomain) {
                val bundle = bundleOf("restaurant" to data)
                findNavController().navigate(R.id.action_navigation_restaurant_to_navigation_detail_restaurant, bundle)
            }
        })

        binding.rvRestaurant.adapter = restaurantAdapter
    }

}