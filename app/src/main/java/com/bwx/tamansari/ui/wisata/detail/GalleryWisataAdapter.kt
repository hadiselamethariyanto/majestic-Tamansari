package com.bwx.tamansari.ui.wisata.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ItemGalleryWisataBinding
import com.bwx.tamansari.model.GalleryWisataDomain

class GalleryWisataAdapter(private val list: List<GalleryWisataDomain>) :
    RecyclerView.Adapter<GalleryWisataAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemGalleryWisataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binding(data: GalleryWisataDomain) {
            val requestOptions = RequestOptions().transform(CenterCrop(), RoundedCorners(36))
            Glide.with(itemView.context).load(data.photoUrl).placeholder(R.drawable.placeholder)
                .apply(requestOptions)
                .into(binding.imageWisata)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemGalleryWisataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(list[position])
    }

    override fun getItemCount(): Int = list.size
}