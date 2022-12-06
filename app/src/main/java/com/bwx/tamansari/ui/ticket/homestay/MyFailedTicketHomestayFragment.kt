package com.bwx.tamansari.ui.ticket.homestay

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.HomestayDomain
import banyuwangi.digital.core.domain.model.RoomDomain
import banyuwangi.digital.core.domain.model.TransactionDomain
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentMyFailedTicketHomestayBinding
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.Utils
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyFailedTicketHomestayFragment :
    BaseFragment<FragmentMyFailedTicketHomestayBinding>(FragmentMyFailedTicketHomestayBinding::inflate) {

    private val viewModel: MyTicketHomestayViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transaction = arguments?.getParcelable<TransactionDomain>("transaction")

        binding.tvCustomerName.text = transaction?.customerName
        binding.tvCustomerPhone.text = transaction?.customerPhoneNumber
        binding.tvCustomerEmail.text = transaction?.customerEmail

        binding.tvWisataName.text = transaction?.title

        binding.tvTotalPayment.text = "IDR ${Utils.thousandSeparator(transaction?.totalFee ?: 0)}"

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

                        binding.btnBuyAgain.setOnClickListener {
                            val bundle = bundleOf("id" to homestay?.id)
                            findNavController().navigate(R.id.action_navigation_failed_homestay_to_navigation_homestay, bundle)
                        }

                    }
                    is Resource.Error -> {
                        Toast.makeText(requireActivity(), res.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }


    }

    private fun setupHomestay(homestay: HomestayDomain?) {
        binding.tvCheckInHour.text = homestay?.checkIn
        binding.tvCheckOutHour.text = homestay?.checkOut

        val photos = homestay?.photos ?: arrayListOf()
        if (photos.isNotEmpty()) {
            Glide.with(requireActivity())
                .load(photos[0])
                .transform(CenterCrop(), RoundedCorners(12))
                .into(binding.imgWisata)
        }
    }

    private fun setupRoom(room: RoomDomain?) {
        binding.roomCapacity.text = "${room?.roomCapacity} Tamu"
        binding.bedType.text = room?.bedType
        binding.tvBreakfast.text =
            if (room?.breakfast == true) "Sarapan tersedia" else "Sarapan tidak tersedia"

    }
}