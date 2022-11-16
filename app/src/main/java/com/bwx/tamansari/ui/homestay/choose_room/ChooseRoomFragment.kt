package com.bwx.tamansari.ui.homestay.choose_room

import android.os.Bundle
import android.view.View
import com.bwx.tamansari.databinding.FragmentChooseRoomBinding
import com.bwx.tamansari.model.HomestayDomain
import com.bwx.tamansari.model.RoomDomain
import com.bwx.tamansari.ui.base.BaseFragment


class ChooseRoomFragment : BaseFragment<FragmentChooseRoomBinding>(FragmentChooseRoomBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rooms = arguments?.getParcelableArrayList<RoomDomain>("rooms")?: arrayListOf()
        val homestay = arguments?.getParcelable<HomestayDomain>("homestay")

        val adapter = RoomAdapter(rooms)
        binding.rvRooms.adapter = adapter
    }
}