package com.bwx.tamansari.ui.restaurant.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ItemMenuRestaurantBinding
import com.bwx.tamansari.model.MenuRestaurantDomain
import com.bwx.tamansari.utils.Utils

class MenuRestaurantAdapter(private val list: List<MenuRestaurantDomain>) :
    RecyclerView.Adapter<MenuRestaurantAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemMenuRestaurantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MenuRestaurantDomain) {
            binding.menuName.text = data.name
            binding.menuPrice.text = Utils.thousandSeparator(data.price)

            Glide.with(itemView.context).load(data.photoUrl)
                .placeholder(R.drawable.placeholder)
                .transform(CenterCrop(), RoundedCorners(24))
                .into(binding.imgMenu)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemMenuRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}