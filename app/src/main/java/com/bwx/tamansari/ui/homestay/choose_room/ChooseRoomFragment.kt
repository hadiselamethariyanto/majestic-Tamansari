package com.bwx.tamansari.ui.homestay.choose_room

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.FragmentChooseRoomBinding
import com.bwx.tamansari.model.HomestayDomain
import com.bwx.tamansari.model.RoomDomain
import com.bwx.tamansari.ui.base.BaseFragment
import com.bwx.tamansari.utils.Utils
import java.util.*


class ChooseRoomFragment :
    BaseFragment<FragmentChooseRoomBinding>(FragmentChooseRoomBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rooms = arguments?.getParcelableArrayList<RoomDomain>("rooms") ?: arrayListOf()
        val homestay = arguments?.getParcelable<HomestayDomain>("homestay")

        val adapter = RoomAdapter(rooms)
        adapter.setOnItemClickCallback(object : RoomAdapter.OnItemClickCallback {
            override fun onItemClicked(data: RoomDomain) {
                val checkinDate = binding.etCheckIn.text.toString()
                val checkoutDate = binding.etCheckout.text.toString()
                val bundle =
                    bundleOf(
                        "homestay" to homestay,
                        "room" to data,
                        "checkin" to checkinDate,
                        "checkout" to checkoutDate
                    )
                findNavController().navigate(
                    R.id.action_navigation_choose_room_to_navigation_review_transaction_homestay,
                    bundle
                )
            }
        })
        binding.rvRooms.adapter = adapter

        getToday()
    }

    private fun getToday() {
        val calendar = Calendar.getInstance()
        binding.etCheckIn.setText(Utils.formatCalendarToStringDate(calendar.timeInMillis))
        calendar.add(Calendar.DATE, 1)
        binding.etCheckout.setText(Utils.formatCalendarToStringDate(calendar.timeInMillis))
    }
}