package com.bwx.tamansari.ui.paket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.model.PaketWisataModel

class PaketAdapter : RecyclerView.Adapter<PaketAdapter.Viewholder>() {
    private val paket = arrayListOf<PaketWisataModel>()

    fun updateData(new: List<PaketWisataModel>) {
        paket.clear()
        paket.addAll(new)
        notifyDataSetChanged()
    }

    class Viewholder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvPackageName: TextView = view.findViewById(R.id.tvPackageName)
        private val tvPrice: TextView = view.findViewById(R.id.tvPrice)
        private val ratingBar: RatingBar = view.findViewById(R.id.ratingbar)
        private val imgPaket: ImageView = view.findViewById(R.id.imgPaket)

        fun bindItem(data: PaketWisataModel) {
            tvPackageName.text = data.nama
            tvPrice.text = "Rp ${data.harga}"
            ratingBar.rating = data.rating
            Glide.with(itemView.context).load(data.foto).transform(CenterCrop(), RoundedCorners(24))
                .into(imgPaket)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Viewholder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_paket_wisata, parent, false)
    )

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bindItem(paket[position])
    }

    override fun getItemCount() = paket.size
}