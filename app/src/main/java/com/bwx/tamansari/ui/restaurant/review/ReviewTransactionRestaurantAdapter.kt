package com.bwx.tamansari.ui.restaurant.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import banyuwangi.digital.core.domain.model.CartRestaurantDomain
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ItemCartRestaurantBinding
import com.bwx.tamansari.utils.Utils

class ReviewTransactionRestaurantAdapter : RecyclerView.Adapter<ReviewTransactionRestaurantAdapter.ViewHolder>() {

    private val list = ArrayList<CartRestaurantDomain>()

    fun updateData(newList:List<CartRestaurantDomain>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemCartRestaurantBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: CartRestaurantDomain) {
            binding.tvProductName.text = data.productName + " (${data.total})"
            binding.tvProductPrice.text = Utils.thousandSeparator(data.productPrice * data.total)
            Glide.with(itemView.context).load(data.imgProduct)
                .placeholder(R.drawable.placeholder).transform(
                    CenterCrop(), RoundedCorners(24)
                )
                .into(binding.imgProduct)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCartRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}