package com.bwx.tamansari.ui.wisata.list

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
import com.bwx.tamansari.model.WisataDomain

class ListWisataAdapter : RecyclerView.Adapter<ListWisataAdapter.Viewholder>() {
    private val wisata = mutableListOf<WisataDomain>()

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun updateData(new: MutableList<WisataDomain>) {
        wisata.clear()
        wisata.addAll(new)
        notifyDataSetChanged()
    }

    class Viewholder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvNamaWisata: TextView = view.findViewById(R.id.tvNamaWisata)
        private val ratingBar: RatingBar = view.findViewById(R.id.ratingbar)
        private val tvVoteCount: TextView = view.findViewById(R.id.tvVoteCount)
        private val imgWisata: ImageView = view.findViewById(R.id.imgWisata)

        fun bindItem(data: WisataDomain) {
            tvNamaWisata.text = data.nama
            ratingBar.rating = data.rating
            tvVoteCount.text = "(${data.vote_count})"
            Glide.with(itemView.context).load(data.foto).transform(CenterCrop(), RoundedCorners(24))
                .into(imgWisata)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Viewholder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_list_wisata, parent, false)
    )

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
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