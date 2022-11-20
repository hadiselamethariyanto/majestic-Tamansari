package com.bwx.tamansari.ui.homestay.choose_room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import banyuwangi.digital.core.domain.model.AvailableRoomDomain
import com.bwx.tamansari.databinding.ItemRoomBinding
import com.bwx.tamansari.utils.Utils

class RoomAdapter :
    RecyclerView.Adapter<RoomAdapter.ViewHolder>() {

    private val rooms = ArrayList<AvailableRoomDomain>()

    fun updateData(newList: List<AvailableRoomDomain>) {
        rooms.clear()
        rooms.addAll(newList)
        notifyDataSetChanged()
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ViewHolder(private val binding: ItemRoomBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(room: AvailableRoomDomain) {
            binding.tvRoomName.text = room.name
            binding.tvRoomName2.text = room.name
            binding.tvRoomArea.text = "${room.area} m2"
            binding.bedType.text = room.bedType
            binding.tvBreakfast.text =
                if (room.breakfast) "Sarapan tersedia" else "Sarapan tidak tersedia"
            binding.roomCapacity.text = "${room.capacity} Tamu"
            binding.tvPrice.text = "IDR ${Utils.thousandSeparator(room.price)}"

            val imageAdapter = ImageRoomAdapter(room.photos)
            binding.rvImageRoom.adapter = imageAdapter
            binding.btnBook.setOnClickListener {
                onItemClickCallback.onItemClicked(room)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRoomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(rooms[position])
    }

    override fun getItemCount(): Int = rooms.size

    interface OnItemClickCallback {
        fun onItemClicked(data: AvailableRoomDomain)
    }
}