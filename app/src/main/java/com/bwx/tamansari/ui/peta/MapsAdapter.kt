package com.bwx.tamansari.ui.peta

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import banyuwangi.digital.core.domain.model.MapsOutletDomain
import banyuwangi.digital.core.domain.model.RestaurantDomain
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ItemMapsBinding
import com.bwx.tamansari.ui.restaurant.list.RestaurantAdapter

class MapsAdapter : RecyclerView.Adapter<MapsAdapter.ViewHolder>() {

    private val list = ArrayList<MapsOutletDomain>()

    fun updateData(newList: List<MapsOutletDomain>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ViewHolder(private val binding: ItemMapsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binding(data: MapsOutletDomain) {
            binding.tvOutletName.text = data.name
            binding.tvOutletType.text = data.typeName
            binding.tvTotalReview.text = "(${data.voteCount} Review)"
            binding.ratingbar.rating = data.rating
            val photos = data.photos
            if (photos.isNotEmpty()) {
                Glide.with(itemView.context)
                    .load(photos[0])
                    .placeholder(R.drawable.placeholder)
                    .transform(CenterCrop(), RoundedCorners(14))
                    .into(binding.imgOutlet)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMapsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)

        val position = holder.adapterPosition
        val outlet = list[position]
        onItemClickCallback.onItemDisplayed(outlet)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(list[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(list[position])
        }
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickCallback {
        fun onItemDisplayed(data: MapsOutletDomain)
        fun onItemClicked(data: MapsOutletDomain)
    }
}