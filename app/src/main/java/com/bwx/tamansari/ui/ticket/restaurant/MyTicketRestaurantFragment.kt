package com.bwx.tamansari.ui.ticket.restaurant

import android.os.Bundle
import android.view.View
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TransactionDomain
import com.bwx.tamansari.databinding.FragmentMyTicketRestaurantBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.Utils
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyTicketRestaurantFragment :
    BaseFragment<FragmentMyTicketRestaurantBinding>(FragmentMyTicketRestaurantBinding::inflate) {

    private val viewModel: MyTicketRestaurantViewModel by viewModel()

    private lateinit var reviewTransactionWisataAdapter: DetailTransactionRestaurantAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transaction = arguments?.getParcelable<TransactionDomain>("transaction")

        reviewTransactionWisataAdapter = DetailTransactionRestaurantAdapter()
        binding.rvChart.adapter = reviewTransactionWisataAdapter

        binding.tvOrderId.text = transaction?.id

        binding.tvCustomerName.text = "Nama lengkap: ${transaction?.customerName}"
        binding.tvCustomerPhone.text = "Nomor ponsel: ${transaction?.customerPhoneNumber}"
        binding.tvCustomerEmail.text = "Alamat email: ${transaction?.customerEmail}"

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

                        binding.tvRestaurantName.text = restaurant?.name
                        binding.tvLocationName.text = homestay?.name
                        binding.tvOngkir.text = "IDR ${Utils.thousandSeparator(ongkir ?: 0)}"
                        reviewTransactionWisataAdapter.updateData(detail)
                    }
                    is Resource.Error -> {

                    }
                }
            }
        }

    }
}