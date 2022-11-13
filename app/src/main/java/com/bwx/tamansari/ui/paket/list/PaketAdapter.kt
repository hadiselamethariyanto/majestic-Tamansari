package com.bwx.tamansari.ui.paket.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bwx.tamansari.databinding.ItemPaketWisataBinding
import com.bwx.tamansari.model.PaketWisataModel
import com.bwx.tamansari.ui.homestay.list.ImageHomestayAdapter
import com.bwx.tamansari.utils.Utils

class PaketAdapter : RecyclerView.Adapter<PaketAdapter.Viewholder>() {
    private val paket = arrayListOf<PaketWisataModel>()

    fun updateData(new: List<PaketWisataModel>) {
        paket.clear()
        paket.addAll(new)
        notifyDataSetChanged()
    }

    class Viewholder(private val binding: ItemPaketWisataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItem(data: PaketWisataModel) {
            binding.tvPackageName.text = data.nama
            binding.tvPrice.text = "IDR ${Utils.thousandSeparator(data.harga)}"
            binding.ratingbar.rating = data.rating
            binding.tvTotalReview.text = "(${data.totalReview} Review)"

            val imageAdapter = ImageHomestayAdapter(data.photos)
            binding.rvImage.adapter = imageAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Viewholder(
        ItemPaketWisataBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bindItem(paket[position])
    }

    override fun getItemCount() = paket.size
}