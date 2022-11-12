package com.bwx.tamansari.ui.homestay

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
import com.bwx.tamansari.model.HomestayModel

class HomestayAdapter : RecyclerView.Adapter<HomestayAdapter.Viewholder>() {
    private val homestay = mutableListOf<HomestayModel>()

    fun updateData(new: List<HomestayModel>) {
        homestay.clear()
        homestay.addAll(new)
        notifyDataSetChanged()
    }

    class Viewholder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvHomestayName: TextView = view.findViewById(R.id.tvHomestayName)
        private val imgHomestay: ImageView = view.findViewById(R.id.imgHomestay)
        private val tvDistance: TextView = view.findViewById(R.id.tvDistance)
        private val ratingBar: RatingBar = view.findViewById(R.id.ratingbar)
        private val tvPrice: TextView = view.findViewById(R.id.tvPrice)

        fun bindItem(data: HomestayModel) {
            tvHomestayName.text = data.nama
            Glide.with(itemView.context).load(data.foto).placeholder(R.drawable.placeholder)
                .transform(CenterCrop(), RoundedCorners(24))
                .into(imgHomestay)
            tvDistance.text = "${data.jarak} KM"
            ratingBar.rating = data.rating
            tvPrice.text = "Rp ${data.harga}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Viewholder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_homestay, parent, false)
    )

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bindItem(homestay[position])
    }

    override fun getItemCount() = homestay.size

}