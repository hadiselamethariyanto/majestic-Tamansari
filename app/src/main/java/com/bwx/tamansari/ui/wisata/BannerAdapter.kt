package com.bwx.tamansari.ui.wisata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.model.BannerPromo
import com.smarteist.autoimageslider.SliderViewAdapter

class BannerAdapter(private val banners: List<BannerPromo>) :
    SliderViewAdapter<BannerAdapter.SliderViewHolder>() {
    class SliderViewHolder(itemView: View) : SliderViewAdapter.ViewHolder(itemView) {
        val imgBanner: ImageView = itemView.findViewById(R.id.imgBanner)

        fun bindItem(item: BannerPromo) {

            Glide.with(itemView.context)
                .load(item.url)
                .transform(CenterCrop(), RoundedCorners(40))
                .into(imgBanner)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_banner, parent, false)
        return SliderViewHolder(v)
    }

    override fun getCount(): Int {
        return banners.size
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder, position: Int) {
        viewHolder.bindItem(banners[position])
    }

}