package com.bwx.tamansari.ui.restaurant.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.CartRestaurantDomain
import banyuwangi.digital.core.domain.model.MenuRestaurantDomain
import com.bwx.tamansari.databinding.FragmentDetailRestaurantBinding
import banyuwangi.digital.core.domain.model.RestaurantDomain
import com.bwx.tamansari.R
import com.bwx.tamansari.ui.base.BaseFragment
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
        val idRestaurant = arguments?.getString("id")

        if (restaurant != null) {
            setRestaurantInfo(restaurant)
            setRestaurantMenus(restaurant.menus)
            navigateToReviewTransaction(restaurant)
        } else {
            idRestaurant?.let {
                viewModel.getDetailRestaurant(it)
                    .observe(viewLifecycleOwner, detailRestaurantObserver)
            }
        }

        viewModel.chart.observe(viewLifecycleOwner) { cart ->
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

    private val detailRestaurantObserver = Observer<Resource<RestaurantDomain>> { res ->
        when (res) {
            is Resource.Loading -> {
                setLoading(true)
            }
            is Resource.Success -> {
                setLoading(false)
                val restaurant = res.data
                setRestaurantInfo(restaurant)
                setRestaurantMenus(restaurant?.menus ?: arrayListOf())
                navigateToReviewTransaction(restaurant)
            }
            is Resource.Error -> {
                setLoading(false)
                Toast.makeText(requireActivity(), res.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setRestaurantInfo(restaurant: RestaurantDomain?) {
        binding.tvRestaurantName.text = restaurant?.name
        binding.tvRestaurantCategory.text = restaurant?.category
//        binding.tvDistance.text = "${restaurant?.distance} km"
        binding.tvRating.text = restaurant?.rating.toString()
        binding.tvTotalReview.text = "${restaurant?.voteCount} rating"
    }

    private fun setRestaurantMenus(menus: List<MenuRestaurantDomain>) {
        menuRestaurantAdapter = MenuRestaurantAdapter(menus)
        menuRestaurantAdapter.setOnItemClickCallback(object :
            MenuRestaurantAdapter.OnItemClickCallback {
            override fun onAddMenu(data: MenuRestaurantDomain) {
                val chart = CartRestaurantDomain(
                    idProduct = data.id,
                    productName = data.name,
                    productPrice = data.price,
                    total = 1,
                    imgProduct = data.photoUrl
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
    }

    private fun navigateToReviewTransaction(restaurant: RestaurantDomain?) {
        binding.llBook.setOnClickListener {
            val cart = viewModel.chart.value
            val bundle = bundleOf("cart" to cart, "restaurant" to restaurant)
            findNavController().navigate(
                R.id.action_navigation_detail_restaurant_to_navigation_review_transaction_restaurant,
                bundle
            )
        }
    }

    private fun setLoading(isLoading: Boolean) {
        binding.llLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
        binding.clContainer.visibility = if (isLoading) View.GONE else View.VISIBLE
        binding.llBook.visibility = if (isLoading) View.GONE else View.VISIBLE
    }

}