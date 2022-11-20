package com.bwx.tamansari.ui.homestay.review_transaction

import android.os.Bundle
import android.view.View
import banyuwangi.digital.core.domain.model.HomestayDomain
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentReviewTransactionHomestayBinding
import com.bwx.tamansari.model.RoomDomain
import com.bwx.tamansari.ui.base.BaseFragment


class ReviewTransactionHomestayFragment : BaseFragment<FragmentReviewTransactionHomestayBinding>(
    FragmentReviewTransactionHomestayBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homestay = arguments?.getParcelable<HomestayDomain>("homestay")
        val room = arguments?.getParcelable<RoomDomain>("room")
        val checkinDate = arguments?.getString("checkin")
        val checkoutDate = arguments?.getString("checkout")

        binding.tvHomestayName.text = homestay?.name
        binding.tvCheckInHour.text = homestay?.checkIn
        binding.tvCheckOutHour.text = homestay?.checkOut
        binding.tvRoomName.text = "1 x ${room?.name}"
        binding.roomCapacity.text = "${room?.roomCapacity} Tamu"
        binding.bedType.text = room?.bedType
        binding.tvBreakfast.text =
            if (room?.breakfast == true) "Sarapan tersedia" else "Sarapan tidak tersedia"
        binding.tvCheckIn.text = checkinDate
        binding.tvCheckOut.text = checkoutDate

        binding.tvCustomerName.text = "Muhammad Hadi"
        binding.tvCustomerPhone.text = "+6282244087798"
        binding.tvCustomerEmail.text = "adybeldex@gmail.com"

        val photo = homestay?.photos?: arrayListOf()
        Glide.with(requireActivity()).load(photo[0]).placeholder(R.drawable.placeholder)
            .transform(
                CenterCrop(), RoundedCorners(20)
            )
            .into(binding.imgHomestay)

    }

}