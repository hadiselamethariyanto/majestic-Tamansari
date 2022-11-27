package com.bwx.tamansari.ui.payment.choose_payment_method

import android.os.Bundle
import android.view.View
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TransactionDomain
import com.bwx.tamansari.databinding.FragmentChoosePaymentMethodBinding
import com.bwx.tamansari.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class ChoosePaymentMethodFragment :
    BaseFragment<FragmentChoosePaymentMethodBinding>(FragmentChoosePaymentMethodBinding::inflate) {

    private val viewModel: ChoosePaymentMethodViewModel by viewModel()
    private lateinit var adapter: ChoosePaymentMethodAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transaction = arguments?.getParcelable<TransactionDomain>("transaction")

        binding.tvOrderId.text = "Order ID: ${transaction?.id?.uppercase()}"

        adapter = ChoosePaymentMethodAdapter()
        binding.rvPaymentMethod.adapter = adapter

        viewModel.getPaymentMethod().observe(viewLifecycleOwner) { res ->
            when (res) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    val paymentMethods = res.data ?: arrayListOf()
                    if (paymentMethods.isNotEmpty()) {
                        adapter.updateData(paymentMethods)
                    }
                }
                is Resource.Error -> {

                }
            }
        }
    }
}