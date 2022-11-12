package com.bwx.tamansari.ui.wisata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bwx.tamansari.R
import com.bwx.tamansari.model.WisataDomain

class WisataPopulerAdapter : RecyclerView.Adapter<WisataPopulerAdapter.ViewHolder>() {
    private val wisata = mutableListOf<WisataDomain>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imgWisata: ImageView = view.findViewById(R.id.imgWisata)
        private val tvNamaWisata: TextView = view.findViewById(R.id.tvNamaWisata)
        private val ratingBar: RatingBar = view.findViewById(R.id.ratingbar)
        private val vote_count: TextView = view.findViewById(R.id.vote_count)

        fun bindItem(data: WisataDomain) {
            Glide.with(itemView.context).load(data.foto)
                .transform(CenterCrop())
                .into(imgWisata)

            tvNamaWisata.text = data.nama
            ratingBar.rating = data.rating
            vote_count.text = "(${data.vote_count})"
        }
    }

    fun updateData(new: MutableList<WisataDomain>) {
        wisata.clear()
        wisata.addAll(new)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_wisata, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(wisata[position])
    }

    override fun getItemCount() = wisata.size

}