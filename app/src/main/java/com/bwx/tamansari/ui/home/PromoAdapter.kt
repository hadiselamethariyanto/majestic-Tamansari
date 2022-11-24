package com.bwx.tamansari.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.model.PromoModel

class PromoAdapter : RecyclerView.Adapter<PromoAdapter.ViewHolder>() {
    val list = arrayListOf<PromoModel>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imgFoto: ImageView = view.findViewById(R.id.img)

        fun bindItem(data: PromoModel) {

            Glide.with(itemView.context)
                .load(data.foto)
                .transform(CenterCrop(), RoundedCorners(24))
                .into(imgFoto)

        }
    }

    fun updateData(new: List<PromoModel>) {
        list.clear()
        list.addAll(new)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_promo, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount() = list.size
}