package com.bwx.tamansari.ui.wisata.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import banyuwangi.digital.core.domain.model.WisataDomain
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ItemListWisataBinding
import com.bwx.tamansari.utils.Utils

class ListWisataAdapter : RecyclerView.Adapter<ListWisataAdapter.ViewHolder>() {
    private val wisata = mutableListOf<WisataDomain>()

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun updateData(new: List<WisataDomain>) {
        wisata.clear()
        wisata.addAll(new)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemListWisataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItem(data: WisataDomain) {
            binding.tvWisataName.text = data.name
            binding.ratingbar.rating = data.rating
            binding.tvTotalReview.text = "(${data.voteCount} Review)"
            val tickets = data.tickets ?: arrayListOf()
            tickets.sortedBy { it.price }
            if (tickets.isNotEmpty()) {
                binding.tvPrice.text = "IDR ${Utils.thousandSeparator(tickets[0].price)}"
                binding.tvDescriptionPrice.visibility = View.VISIBLE
                binding.tvPrice.visibility = View.VISIBLE
            } else {
                binding.tvDescriptionPrice.visibility = View.GONE
                binding.tvPrice.visibility = View.GONE
            }

            if (data.photos.isNotEmpty()) {
                Glide.with(itemView.context).load(data.photos[0])
                    .placeholder(R.drawable.placeholder)
                    .transform(CenterCrop(), RoundedCorners(24))
                    .into(binding.imgWisata)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemListWisataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(wisata[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(wisata[position])
        }
    }

    override fun getItemCount() = wisata.size

    interface OnItemClickCallback {
        fun onItemClicked(data: WisataDomain)
    }
}