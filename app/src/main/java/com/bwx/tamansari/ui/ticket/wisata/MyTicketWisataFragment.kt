package com.bwx.tamansari.ui.ticket.wisata

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.view.View
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TransactionDomain
import com.bumptech.glide.Glide
import com.bwx.tamansari.databinding.FragmentMyTicketWisataBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.ui.wisata.review.ReviewTransactionWisataAdapter
import com.bwx.tamansari.utils.Utils
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import org.koin.androidx.viewmodel.ext.android.viewModel


class MyTicketWisataFragment :
    BaseFragment<FragmentMyTicketWisataBinding>(FragmentMyTicketWisataBinding::inflate) {

    private val viewModel: MyTicketWisataViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transaction = arguments?.getParcelable<TransactionDomain>("transaction")

        binding.tvOrderId.text = transaction?.id

        Glide.with(requireActivity()).load(getQrCodeBitmap(transaction?.id ?: "")).centerCrop()
            .into(binding.imgQr)

        binding.tvCustomerName.text = "Nama lengkap: ${transaction?.customerName}"
        binding.tvCustomerPhone.text = "Nomor ponsel: ${transaction?.customerPhoneNumber}"
        binding.tvCustomerEmail.text = "Alamat email: ${transaction?.customerEmail}"

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
                        reviewTransactionWisataAdapter.updateData(
                            transactionWisata?.detail ?: arrayListOf()
                        )
                    }
                    is Resource.Error -> {

                    }
                }
            }
        }
    }

    private fun getQrCodeBitmap(orderId: String): Bitmap {
        val size = 512 //pixels
        val bits = QRCodeWriter().encode(orderId, BarcodeFormat.QR_CODE, size, size)
        return Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565).also {
            for (x in 0 until size) {
                for (y in 0 until size) {
                    it.setPixel(x, y, if (bits[x, y]) Color.BLACK else Color.WHITE)
                }
            }
        }
    }
}