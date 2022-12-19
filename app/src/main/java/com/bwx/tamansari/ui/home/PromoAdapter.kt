package com.bwx.tamansari.ui.home

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import banyuwangi.digital.core.domain.model.BannerDomain
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R

class PromoAdapter : RecyclerView.Adapter<PromoAdapter.ViewHolder>() {
    val list = arrayListOf<BannerDomain>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imgFoto: ImageView = view.findViewById(R.id.img)

        fun bindItem(data: BannerDomain) {
            Glide.with(itemView.context)
                .load(data.backdropUrl)
                .transform(CenterCrop(), RoundedCorners(24))
                .into(imgFoto)

            itemView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(data.redirectUrl))
                itemView.context.startActivity(intent)
            }
        }
    }

    fun updateData(new: List<BannerDomain>) {
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