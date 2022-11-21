package com.bwx.tamansari.ui.paket.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import banyuwangi.digital.core.domain.model.TravelPackageDomain
import com.bwx.tamansari.databinding.ItemPaketWisataBinding
import com.bwx.tamansari.ui.homestay.list.ImageHomestayAdapter
import com.bwx.tamansari.utils.Utils

class PaketAdapter : RecyclerView.Adapter<PaketAdapter.ViewHolder>() {
    private val paket = arrayListOf<TravelPackageDomain>()

    fun updateData(new: List<TravelPackageDomain>) {
        paket.clear()
        paket.addAll(new)
        notifyDataSetChanged()
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ViewHolder(private val binding: ItemPaketWisataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItem(data: TravelPackageDomain) {
            binding.tvPackageName.text = data.name
            val travelPackageTypes = data.travelPackageType
            travelPackageTypes.sortedBy { it.price }
            if (travelPackageTypes.isNotEmpty()) {
                binding.tvPrice.text = "IDR ${Utils.thousandSeparator(travelPackageTypes[0].price)}"
                binding.tvPrice.visibility = View.VISIBLE
                binding.tvDescriptionPrice.visibility = View.VISIBLE
            } else {
                binding.tvPrice.visibility = View.GONE
                binding.tvDescriptionPrice.visibility = View.GONE
            }
            binding.ratingbar.rating = data.rating
            binding.tvTotalReview.text = "(${data.voteCount} Review)"

            val imageAdapter = ImageHomestayAdapter(data.photos)
            binding.rvImage.adapter = imageAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemPaketWisataBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(paket[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(paket[position])
        }
    }

    override fun getItemCount() = paket.size

    interface OnItemClickCallback {
        fun onItemClicked(data: TravelPackageDomain)
    }
}