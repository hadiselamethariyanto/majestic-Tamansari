package com.bwx.tamansari.ui.homestay.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ItemImageListHomestayBinding

class ImageHomestayAdapter(private val list: List<String>) :
    RecyclerView.Adapter<ImageHomestayAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemImageListHomestayBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(url: String) {
            Glide.with(itemView.context).load(url).placeholder(R.drawable.placeholder).centerCrop()
                .into(binding.imgHomestay)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemImageListHomestayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}