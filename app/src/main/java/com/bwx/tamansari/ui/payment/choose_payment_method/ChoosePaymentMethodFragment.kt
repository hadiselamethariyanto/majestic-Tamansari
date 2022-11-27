package com.bwx.tamansari.ui.payment.choose_payment_method

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.PaymentMethodDomain
import banyuwangi.digital.core.domain.model.TransactionDomain
import banyuwangi.digital.core.domain.model.TransactionWisataDomain
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
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

        if (transaction?.type == 1) {
            viewModel.getTransactionWisata(transaction.id)
                .observe(viewLifecycleOwner, transactionWisataObserver)
        }

        viewModel.getPaymentMethod().observe(viewLifecycleOwner, paymentMethodObserver)
    }

    private val transactionWisataObserver = Observer<Resource<TransactionWisataDomain>> { res ->
        when (res) {
            is Resource.Loading -> {
                setLoadingOutlet(true)
            }
            is Resource.Success -> {
                setLoadingOutlet(false)
                val wisata = res.data?.wisata
                val wisataPhotos = wisata?.photos

                binding.tvOutletName.text = wisata?.name
                if (wisataPhotos?.isNotEmpty() == true) {
                    Glide.with(requireActivity())
                        .load(wisataPhotos[0])
                        .placeholder(R.drawable.placeholder)
                        .transform(CenterCrop(), RoundedCorners(12))
                        .into(binding.imgOutlet)
                }
            }
            is Resource.Error -> {
                setLoadingOutlet(false)
            }
        }
    }

    private val paymentMethodObserver = Observer<Resource<List<PaymentMethodDomain>>> { res ->
        when (res) {
            is Resource.Loading -> {
                setLoadingPayment(true)
            }
            is Resource.Success -> {
                setLoadingPayment(false)
                val paymentMethods = res.data ?: arrayListOf()
                if (paymentMethods.isNotEmpty()) {
                    adapter.updateData(paymentMethods)
                }
            }
            is Resource.Error -> {
                setLoadingPayment(false)
            }
        }

    }

    private fun setLoadingPayment(isLoading: Boolean) {
        if (isLoading) {
            binding.shimmerPaymentMethod.apply {
                visibility = View.VISIBLE
                startShimmer()
            }
        } else {
            binding.shimmerPaymentMethod.apply {
                stopShimmer()
                visibility = View.GONE
            }
        }
    }

    private fun setLoadingOutlet(isLoading: Boolean) {
        if (isLoading) {
            binding.shimmerOutlet.apply {
                visibility = View.VISIBLE
                startShimmer()
            }
        } else {
            binding.shimmerOutlet.apply {
                stopShimmer()
                visibility = View.GONE
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.shimmerPaymentMethod.startShimmer()
        binding.shimmerOutlet.startShimmer()
    }

    override fun onPause() {
        binding.shimmerPaymentMethod.stopShimmer()
        binding.shimmerOutlet.stopShimmer()
        super.onPause()
    }
}