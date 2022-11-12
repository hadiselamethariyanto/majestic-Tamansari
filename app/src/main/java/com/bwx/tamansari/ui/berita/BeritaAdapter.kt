package com.bwx.tamansari.ui.berita

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
import com.bwx.tamansari.model.BeritaModel

class BeritaAdapter : RecyclerView.Adapter<BeritaAdapter.ViewHolder>() {

    private val berita = ArrayList<BeritaModel>()

    fun updateData(new:List<BeritaModel>){
        berita.clear()
        berita.addAll(new)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imgBerita: ImageView = view.findViewById(R.id.imgBerita)
        private val tvJudul: TextView = view.findViewById(R.id.tvJudul)
        private val tvTanggal: TextView = view.findViewById(R.id.tvTanggal)

        fun bindItem(berita: BeritaModel) {
            Glide.with(itemView.context)
                .load(berita.foto)
                .transform(CenterCrop(), RoundedCorners(70))
                .into(imgBerita)

            tvJudul.text = berita.judul
            tvTanggal.text = berita.tanggal

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_berita, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(berita[position])
    }

    override fun getItemCount() = berita.size
}