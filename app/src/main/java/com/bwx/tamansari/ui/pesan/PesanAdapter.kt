package com.bwx.tamansari.ui.pesan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bwx.tamansari.R
import com.bwx.tamansari.model.PesanModel

class PesanAdapter : RecyclerView.Adapter<PesanAdapter.ViewHolder>() {
    private val pesan = mutableListOf<PesanModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_pesan, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(pesan[position])
    }

    override fun getItemCount() = pesan.size

    fun updateData(new: MutableList<PesanModel>) {
        pesan.clear()
        pesan.addAll(new)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var tvTanggal: TextView = view.findViewById(R.id.tvTanggal)
        private var tvJenis: TextView = view.findViewById(R.id.tvJenis)
        private var tvPesan: TextView = view.findViewById(R.id.tvPesan)

        fun bindItem(data: PesanModel) {
            tvTanggal.text = data.tanggal
            tvJenis.text = data.jenis
            tvPesan.text = data.pesan
        }
    }

}