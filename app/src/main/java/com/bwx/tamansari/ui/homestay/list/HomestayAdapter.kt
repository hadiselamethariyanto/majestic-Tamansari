package com.bwx.tamansari.ui.homestay.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bwx.tamansari.databinding.ItemHomestayBinding
import com.bwx.tamansari.model.HomestayDomain
import com.bwx.tamansari.utils.Utils

class HomestayAdapter : RecyclerView.Adapter<HomestayAdapter.ViewHolder>() {
    private val homestay = mutableListOf<HomestayDomain>()

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
            binding.tvHomestayName.text = data.nama
            binding.tvDistance.text = "• ${data.jarak} km dari lokasimu"
            binding.tvHomestayRating.text = data.rating.toString()
            binding.tvPrice.text = "IDR ${Utils.thousandSeparator(data.harga)}"
            binding.tvTotalReview.text = "${data.totalReview} (Review)"
            binding.homestayStar.numStars = data.star.toInt()
            binding.homestayStar.rating = data.star

            binding.rvImage.adapter = ImageHomestayAdapter(data.foto)
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