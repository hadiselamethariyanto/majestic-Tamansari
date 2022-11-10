package com.bwx.tamansari.ui.tpsr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.model.SampahModel

class HargaSampahAdapter : RecyclerView.Adapter<HargaSampahAdapter.Viewholder>() {

    private val sampah = mutableListOf<SampahModel>()

    class Viewholder(view: View) : RecyclerView.ViewHolder(view) {
        private val imgSampah = view.findViewById<ImageView>(R.id.imgSampah)
        private val tvNamaSampah = view.findViewById<TextView>(R.id.tvNamaSampah)
        private val tvHargaSampah = view.findViewById<TextView>(R.id.tvHargaSampah)

        fun bindItem(data: SampahModel) {
            Glide.with(itemView.context)
                .load(data.foto)
                .transform(CenterCrop(), RoundedCorners(40))
                .into(imgSampah)

            tvNamaSampah.text = data.nama
            tvHargaSampah.text = "Rp${data.harga}"
        }
    }

    fun updateData(new: MutableList<SampahModel>) {
        sampah.clear()
        sampah.addAll(new)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Viewholder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_sampah, parent, false)
    )

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bindItem(sampah[position])
    }

    override fun getItemCount() = sampah.size
}