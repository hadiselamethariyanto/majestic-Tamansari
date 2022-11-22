package com.bwx.tamansari.ui.restaurant.detail

import android.os.Bundle
import android.view.View
import com.bwx.tamansari.databinding.FragmentDetailRestaurantBinding
import banyuwangi.digital.core.domain.model.RestaurantDomain
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.DataDummy


class DetailRestaurantFragment : BaseFragment<FragmentDetailRestaurantBinding>(
    FragmentDetailRestaurantBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val restaurant = arguments?.getParcelable<RestaurantDomain>("restaurant")

        binding.tvRestaurantName.text = restaurant?.name
        binding.tvRestaurantCategory.text = restaurant?.category
//        binding.tvDistance.text = "${restaurant?.distance} km"
        binding.tvRating.text = restaurant?.rating.toString()
        binding.tvTotalReview.text = "${restaurant?.voteCount} rating"
        val menus = restaurant?.menus ?: arrayListOf()
        val menuRestaurantAdapter = MenuRestaurantAdapter(menus)
        binding.rvMenusRestaurant.adapter = menuRestaurantAdapter
    }

}