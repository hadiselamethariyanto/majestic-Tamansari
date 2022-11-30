package com.bwx.tamansari.ui.ticket.homestay

import android.os.Bundle
import android.view.View
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.HomestayDomain
import banyuwangi.digital.core.domain.model.RoomDomain
import banyuwangi.digital.core.domain.model.TransactionDomain
import com.bumptech.glide.Glide
import com.bwx.tamansari.databinding.FragmentMyTicketHomestayBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.Utils
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyTicketHomestayFragment :
    BaseFragment<FragmentMyTicketHomestayBinding>(FragmentMyTicketHomestayBinding::inflate) {

    private val viewModel: MyTicketHomestayViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transaction = arguments?.getParcelable<TransactionDomain>("transaction")

        binding.tvOrderId.text = transaction?.id

        Glide.with(requireActivity()).load(Utils.getQrCodeBitmap(transaction?.id ?: ""))
            .centerCrop()
            .into(binding.imgQr)

        binding.tvCustomerName.text = "Nama lengkap: ${transaction?.customerName}"
        binding.tvCustomerPhone.text = "Nomor ponsel: ${transaction?.customerPhoneNumber}"
        binding.tvCustomerEmail.text = "Alamat email: ${transaction?.customerEmail}"

        transaction?.let {
            viewModel.getTransactionHomestay(it.id).observe(viewLifecycleOwner) { res ->
                when (res) {
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {
                        val homestay = res.data?.homestay
                        val room = res.data?.room
                        setupHomestay(homestay)
                        setupRoom(room)
                        binding.tvCheckIn.text = res.data?.checkIn
                        binding.tvCheckOut.text = res.data?.checkOut
                    }
                    is Resource.Error -> {

                    }
                }
            }
        }

//        binding.tvTotalPayment.text = "IDR ${Utils.thousandSeparator(transaction?.totalFee ?: 0)}"

    }

    private fun setupHomestay(homestay: HomestayDomain?) {
        binding.tvCheckInHour.text = homestay?.checkIn
        binding.tvCheckOutHour.text = homestay?.checkOut
    }

    private fun setupRoom(room: RoomDomain?) {
        binding.roomCapacity.text = "${room?.roomCapacity} Tamu"
        binding.bedType.text = room?.bedType
        binding.tvBreakfast.text =
            if (room?.breakfast == true) "Sarapan tersedia" else "Sarapan tidak tersedia"

    }
}