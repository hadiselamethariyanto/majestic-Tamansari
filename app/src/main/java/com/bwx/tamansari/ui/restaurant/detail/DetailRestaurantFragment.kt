package com.bwx.tamansari.ui.restaurant.detail

import android.os.Bundle
import android.view.View
import banyuwangi.digital.core.domain.model.ChartDomain
import banyuwangi.digital.core.domain.model.MenuRestaurantDomain
import com.bwx.tamansari.databinding.FragmentDetailRestaurantBinding
import banyuwangi.digital.core.domain.model.RestaurantDomain
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.DataDummy
import com.bwx.tamansari.utils.Utils
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailRestaurantFragment : BaseFragment<FragmentDetailRestaurantBinding>(
    FragmentDetailRestaurantBinding::inflate
) {

    private val viewModel: DetailRestaurantViewModel by viewModel()
    private lateinit var menuRestaurantAdapter: MenuRestaurantAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val restaurant = arguments?.getParcelable<RestaurantDomain>("restaurant")

        binding.tvRestaurantName.text = restaurant?.name
        binding.tvRestaurantCategory.text = restaurant?.category
//        binding.tvDistance.text = "${restaurant?.distance} km"
        binding.tvRating.text = restaurant?.rating.toString()
        binding.tvTotalReview.text = "${restaurant?.voteCount} rating"
        val menus = restaurant?.menus ?: arrayListOf()
        menuRestaurantAdapter = MenuRestaurantAdapter(menus)
        menuRestaurantAdapter.setOnItemClickCallback(object :MenuRestaurantAdapter.OnItemClickCallback{
            override fun onAddMenu(data: MenuRestaurantDomain) {
                val chart = ChartDomain(
                    idProduct = data.id,
                    productName = data.name,
                    productPrice = data.price,
                    total = 1
                )
                viewModel.addChart(chart)
            }

            override fun onPlusMenu(data: MenuRestaurantDomain) {
                viewModel.plusChart(data)
            }

            override fun onMinusMenu(data: MenuRestaurantDomain) {
                viewModel.deleteChart(data)
            }
        })
        binding.rvMenusRestaurant.adapter = menuRestaurantAdapter

        viewModel.chart.observe(viewLifecycleOwner) {cart->
            menuRestaurantAdapter.updateData(cart)
            if (cart.isNotEmpty()) {
                val totalFee = cart.sumOf { it.productPrice * it.total }
                binding.tvTotalItem.text = "${cart.size} Item"
                binding.tvTotalFee.text = "IDR ${Utils.thousandSeparator(totalFee)}"
                binding.llBook.visibility = View.VISIBLE
            } else {
                binding.llBook.visibility = View.GONE
            }
        }
    }

}