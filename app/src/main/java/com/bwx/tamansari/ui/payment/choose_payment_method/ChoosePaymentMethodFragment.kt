package com.bwx.tamansari.ui.payment.choose_payment_method

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.PaymentMethodDomain
import banyuwangi.digital.core.domain.model.TransactionDomain
import banyuwangi.digital.core.domain.model.TransactionHomestayDomain
import banyuwangi.digital.core.domain.model.TransactionWisataDomain
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentChoosePaymentMethodBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.Utils
import org.koin.androidx.viewmodel.ext.android.viewModel


class ChoosePaymentMethodFragment :
    BaseFragment<FragmentChoosePaymentMethodBinding>(FragmentChoosePaymentMethodBinding::inflate) {

    private val viewModel: ChoosePaymentMethodViewModel by viewModel()
    private lateinit var adapter: ChoosePaymentMethodAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transaction = arguments?.getParcelable<TransactionDomain>("transaction")

        binding.tvOrderId.text = "Order ID: ${transaction?.id?.uppercase()}"
        binding.tvTotalFee.text = "IDR ${Utils.thousandSeparator(transaction?.totalFee ?: 0)}"
        binding.btnPayment.setOnClickListener {
            val paymentMethodDomain = viewModel.selectedPaymentMethod.value
            if (paymentMethodDomain != null) {
                transaction?.let { it1 ->
                    viewModel.chargeEWallet(
                        it1.id,
                        paymentMethodDomain.code,
                        it1.totalFee
                    ).observe(viewLifecycleOwner, chargeEWalletObserver)
                }
            } else {
                Toast.makeText(
                    requireActivity(),
                    "Mohon pilih metode pembayaran",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        adapter = ChoosePaymentMethodAdapter()
        adapter.setOnItemClickCallback(object : ChoosePaymentMethodAdapter.OnItemClickCallback {
            override fun onItemClicked(data: PaymentMethodDomain, position: Int) {
                viewModel.selectPaymentMethod(data)
                adapter.setPaymentMethod(position)
            }
        })

        binding.rvPaymentMethod.adapter = adapter

        if (transaction?.type == 1) {
            viewModel.getTransactionWisata(transaction.id)
                .observe(viewLifecycleOwner, transactionWisataObserver)
        } else if (transaction?.type == 5) {
            viewModel.getTransactionHomestay(transaction.id)
                .observe(viewLifecycleOwner, transactionHomestayObserver)
        }

        viewModel.getPaymentMethod().observe(viewLifecycleOwner, paymentMethodObserver)
    }

    private val chargeEWalletObserver = Observer<Resource<String>> { res ->
        when (res) {
            is Resource.Loading -> {
                binding.btnPayment.isEnabled = false
            }
            is Resource.Success -> {
                binding.btnPayment.isEnabled = true
                val bundle = bundleOf("checkout_url" to res.data)
                findNavController().navigate(
                    R.id.action_navigation_choose_payment_method_to_navigation_payment_ewallet,
                    bundle
                )
            }
            is Resource.Error -> {
                binding.btnPayment.isEnabled = true
                Toast.makeText(requireActivity(), res.message, Toast.LENGTH_LONG).show()
            }
        }
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

    private val transactionHomestayObserver = Observer<Resource<TransactionHomestayDomain>> { res ->
        when (res) {
            is Resource.Loading -> {
                setLoadingOutlet(true)
            }
            is Resource.Success -> {
                setLoadingOutlet(false)
                val homestay = res.data?.homestay
                val homestayPhotos = homestay?.photos

                binding.tvOutletName.text = homestay?.name
                if (homestayPhotos?.isNotEmpty() == true) {
                    Glide.with(requireActivity())
                        .load(homestayPhotos[0])
                        .placeholder(R.drawable.placeholder)
                        .transform(CenterCrop(), RoundedCorners(12))
                        .into(binding.imgOutlet)
                }
            }
            is Resource.Error -> {
                setLoadingOutlet(false)
                Toast.makeText(requireActivity(),res.message,Toast.LENGTH_LONG).show()
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