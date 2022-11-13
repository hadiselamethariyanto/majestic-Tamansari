package com.bwx.tamansari.ui.berita.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.databinding.ItemBeritaBinding
import com.bwx.tamansari.model.BeritaModel

class BeritaAdapter : RecyclerView.Adapter<BeritaAdapter.ViewHolder>() {

    private val berita = ArrayList<BeritaModel>()

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun updateData(new: List<BeritaModel>) {
        berita.clear()
        berita.addAll(new)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemBeritaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItem(berita: BeritaModel) {
            Glide.with(itemView.context)
                .load(berita.foto)
                .transform(CenterCrop(), RoundedCorners(70))
                .into(binding.imgBerita)

            binding.tvJudul.text = berita.judul
            binding.tvNewsCategory.text = "${berita.category} \u2022 "
            binding.tvTanggal.text = berita.tanggal
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
        fun onItemClicked(data: BeritaModel)
    }
}