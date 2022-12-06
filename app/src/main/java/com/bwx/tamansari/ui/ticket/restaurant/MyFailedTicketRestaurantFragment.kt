package com.bwx.tamansari.ui.ticket.restaurant

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TransactionDomain
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentMyFailedTicketRestaurantBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.Utils
import org.koin.androidx.viewmodel.ext.android.viewModel


class MyFailedTicketRestaurantFragment :
    BaseFragment<FragmentMyFailedTicketRestaurantBinding>(FragmentMyFailedTicketRestaurantBinding::inflate) {

    private val viewModel: MyTicketRestaurantViewModel by viewModel()

    private lateinit var detailTransactionRestaurantAdapter: DetailTransactionRestaurantAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transaction = arguments?.getParcelable<TransactionDomain>("transaction")

        binding.tvCustomerName.text = transaction?.customerName
        binding.tvCustomerPhone.text = transaction?.customerPhoneNumber
        binding.tvCustomerEmail.text = transaction?.customerEmail

        detailTransactionRestaurantAdapter = DetailTransactionRestaurantAdapter()
        binding.rvCart.adapter = detailTransactionRestaurantAdapter

        binding.tvTotalPayment.text = "IDR ${Utils.thousandSeparator(transaction?.totalFee ?: 0)}"

        transaction?.let {
            viewModel.getTransactionRestaurant(it.id).observe(viewLifecycleOwner) { res ->
                when (res) {
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {
                        val homestay = res.data?.homestay
                        val restaurant = res.data?.restaurant
                        val ongkir = res.data?.ongkir
                        val detail = res.data?.detail ?: arrayListOf()

                        Glide.with(requireActivity()).load(restaurant?.photoUrl)
                            .placeholder(R.drawable.placeholder)
                            .transform(CenterCrop(), RoundedCorners(24))
                            .into(binding.imgRestaurant)

                        binding.tvRestaurantName.text = restaurant?.name
                        binding.tvOngkir.text = "IDR ${Utils.thousandSeparator(ongkir ?: 0)}"
                        detailTransactionRestaurantAdapter.updateData(detail)

                        binding.btnBuyAgain.setOnClickListener {
                            val bundle = bundleOf("id" to restaurant?.id)
                            findNavController().navigate(
                                R.id.action_navigation_failed_restaurant_to_navigation_restaurant,
                                bundle
                            )
                        }
                    }
                    is Resource.Error -> {

                    }
                }
            }
        }


    }
}