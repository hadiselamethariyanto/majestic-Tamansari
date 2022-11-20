package com.bwx.tamansari.ui.homestay.choose_room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ItemImageRoomBinding

class ImageRoomAdapter(private val list: List<String>) :
    RecyclerView.Adapter<ImageRoomAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemImageRoomBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(url: String, index: Int, total: Int) {
            binding.tvIndexTotalImage.text = "$index/$total"
            Glide.with(itemView.context).load(url).placeholder(R.drawable.placeholder).centerCrop()
                .into(binding.imgRoom)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemImageRoomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], position, list.size)
    }

    override fun getItemCount(): Int = list.size
}