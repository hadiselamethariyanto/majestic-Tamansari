package com.bwx.tamansari.ui.restaurant

import android.os.Bundle
import android.view.View
import com.bwx.tamansari.databinding.FragmentRestaurantBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.DataDummy


class RestaurantFragment :
    BaseFragment<FragmentRestaurantBinding>(FragmentRestaurantBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val restaurantAdapter = RestaurantAdapter()
        restaurantAdapter.updateData(DataDummy.generateRestaurant())

        binding.rvRestaurant.adapter = restaurantAdapter
    }

}