package com.bwx.tamansari.ui.ticket

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.view.View
import banyuwangi.digital.core.domain.model.TransactionDomain
import com.bumptech.glide.Glide
import com.bwx.tamansari.databinding.FragmentMyTicketWisataBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter


class MyTicketWisataFragment :
    BaseFragment<FragmentMyTicketWisataBinding>(FragmentMyTicketWisataBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transaction = arguments?.getParcelable<TransactionDomain>("transaction")

        binding.tvOrderId.text = transaction?.id

        Glide.with(requireActivity()).load(getQrCodeBitmap(transaction?.id ?: "")).centerCrop()
            .into(binding.imgQr)

        binding.tvCustomerName.text = "Nama lengkap: ${transaction?.customerName}"
        binding.tvCustomerPhone.text = "Nomor ponsel: ${transaction?.customerPhoneNumber}"
        binding.tvCustomerEmail.text = "Alamat email: ${transaction?.customerEmail}"


    }

    fun getQrCodeBitmap(orderId: String): Bitmap {
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