package com.bwx.tamansari.ui.homestay.choose_room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ItemRoomBinding
import com.bwx.tamansari.model.RoomDomain
import com.bwx.tamansari.utils.Utils

class RoomAdapter(private val rooms: List<RoomDomain>) :
    RecyclerView.Adapter<RoomAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemRoomBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(room: RoomDomain) {
            binding.tvRoomName.text = room.name
            binding.tvRoomName2.text = room.name
            binding.tvRoomArea.text = "${room.area} m2"
            binding.bedType.text = room.bedType
            binding.tvBreakfast.text =
                if (room.breakfast) "Sarapan tersedia" else "Sarapan tidak tersedia"
            binding.roomCapacity.text = "${room.roomCapacity} Tamu"
            binding.tvPrice.text = "IDR ${Utils.thousandSeparator(room.price)}"
            Glide.with(itemView.context).load(room.image).placeholder(R.drawable.placeholder)
                .into(binding.imgRoom)
            binding.btnBook.setOnClickListener {

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
}