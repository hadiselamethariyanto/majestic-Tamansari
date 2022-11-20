package com.bwx.tamansari.ui.homestay.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import banyuwangi.digital.core.domain.model.HomestayDomain
import com.bwx.tamansari.databinding.ItemHomestayBinding
import com.bwx.tamansari.utils.Utils

class HomestayAdapter : RecyclerView.Adapter<HomestayAdapter.ViewHolder>() {
    private val homestay = arrayListOf<HomestayDomain>()

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    fun updateData(new: List<HomestayDomain>) {
        homestay.clear()
        homestay.addAll(new)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemHomestayBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItem(data: HomestayDomain) {
            binding.tvHomestayName.text = data.name
//            binding.tvDistance.text = "• ${data.jarak} km dari lokasimu"
            binding.tvHomestayRating.text = data.rating.toString()
            val rooms = data.rooms
            rooms.sortedBy { it.price }
            if (rooms.isNotEmpty()) {
                binding.tvPrice.text = "IDR ${Utils.thousandSeparator(rooms[0].price)}"
            }
            binding.tvTotalReview.text = "${data.voteCount} (Review)"
            binding.homestayStar.numStars = data.rating.toInt()
            binding.homestayStar.rating = data.rating

            binding.rvImage.adapter = ImageHomestayAdapter(data.photos)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemHomestayBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(homestay[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(homestay[position])
        }
    }

    override fun getItemCount() = homestay.size

    interface OnItemClickCallback {
        fun onItemClicked(data: HomestayDomain)
    }
}