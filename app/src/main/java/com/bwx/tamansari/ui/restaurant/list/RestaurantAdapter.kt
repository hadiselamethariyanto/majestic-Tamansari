package com.bwx.tamansari.ui.restaurant.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ItemRestaurantBinding
import com.bwx.tamansari.model.RestaurantDomain

class RestaurantAdapter : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    private val list = ArrayList<RestaurantDomain>()

    fun updateData(newList: List<RestaurantDomain>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemRestaurantBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: RestaurantDomain) {
            binding.tvRestaurantName.text = data.name
            binding.tvRestaurantCategory.text = data.category
            binding.tvRating.text = data.rating.toString()
            binding.tvDistance.text = "${data.distance} Km dari lokasimu"

            Glide.with(itemView.context).load(data.photoUrl).placeholder(R.drawable.placeholder)
                .transform(
                    CenterCrop(), RoundedCorners(24)
                ).into(binding.imgRestaurant)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}