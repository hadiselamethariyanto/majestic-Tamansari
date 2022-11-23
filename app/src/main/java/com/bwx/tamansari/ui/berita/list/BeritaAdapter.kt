package com.bwx.tamansari.ui.berita.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ItemBeritaBinding
import banyuwangi.digital.core.domain.model.NewsDomain

class BeritaAdapter : RecyclerView.Adapter<BeritaAdapter.ViewHolder>() {

    private val berita = ArrayList<NewsDomain>()

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun updateData(new: List<NewsDomain>) {
        berita.clear()
        berita.addAll(new)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemBeritaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItem(berita: NewsDomain) {
            Glide.with(itemView.context)
                .load(berita.photo)
                .placeholder(R.drawable.placeholder)
                .transform(CenterCrop(), RoundedCorners(24))
                .into(binding.imgBerita)

            binding.tvJudul.text = berita.title
            binding.tvNewsCategory.text = "${berita.category} \u2022 "
            binding.tvTanggal.text = berita.createdDate.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemBeritaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(berita[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(berita[position])
        }
    }

    override fun getItemCount() = berita.size

    interface OnItemClickCallback {
        fun onItemClicked(data: NewsDomain)
    }
}