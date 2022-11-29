package com.bwx.tamansari.ui.ticket.wisata

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
import com.bwx.tamansari.databinding.FragmentMyFailedTicketWisataBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.ui.wisata.review.ReviewTransactionWisataAdapter
import com.bwx.tamansari.utils.Utils
import org.koin.androidx.viewmodel.ext.android.viewModel


class MyFailedTicketWisataFragment :
    BaseFragment<FragmentMyFailedTicketWisataBinding>(FragmentMyFailedTicketWisataBinding::inflate) {

    private val viewModel: MyTicketWisataViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transaction = arguments?.getParcelable<TransactionDomain>("transaction")

        binding.tvCustomerName.text = transaction?.customerName
        binding.tvCustomerPhone.text = transaction?.customerPhoneNumber
        binding.tvCustomerEmail.text = transaction?.customerEmail

        binding.tvTotalPayment.text = "IDR ${Utils.thousandSeparator(transaction?.totalFee ?: 0)}"

        val reviewTransactionWisataAdapter = ReviewTransactionWisataAdapter()
        binding.rvChart.adapter = reviewTransactionWisataAdapter


        transaction?.let {
            viewModel.getTransactionWisata(it.id).observe(viewLifecycleOwner) { res ->
                when (res) {
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {
                        val transactionWisata = res.data
                        val detail = transactionWisata?.detail ?: arrayListOf()
                        val wisata = transactionWisata?.wisata

                        reviewTransactionWisataAdapter.updateData(detail)

                        val photos = wisata?.photos ?: arrayListOf()
                        if (photos.isNotEmpty()) {
                            Glide.with(requireActivity()).load(photos[0])
                                .placeholder(R.drawable.placeholder)
                                .transform(CenterCrop(), RoundedCorners(24))
                                .into(binding.imgWisata)
                        }
                        binding.tvWisataName.text = wisata?.name
                        binding.btnBuyAgain.setOnClickListener {
                            val bundle = bundleOf("wisata" to wisata)
                            findNavController().navigate(R.id.navigation_detail_wisata, bundle)
                        }
                    }
                    is Resource.Error -> {

                    }
                }
            }
        }

    }

}