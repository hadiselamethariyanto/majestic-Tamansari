package com.bwx.tamansari.ui.riwayat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bwx.tamansari.R
import com.bwx.tamansari.model.TransaksiModel

class RiwayatAdapter : RecyclerView.Adapter<RiwayatAdapter.ViewHolder>() {
    private val transaksi = mutableListOf<TransaksiModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_transaksi, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(transaksi[position])
    }

    override fun getItemCount() = transaksi.size

    fun updateData(new: MutableList<TransaksiModel>) {
        transaksi.clear()
        transaksi.addAll(new)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var tvId: TextView = view.findViewById(R.id.tvId)
        private var tvBiaya: TextView = view.findViewById(R.id.tvBiaya)
        private var tvTanggal: TextView = view.findViewById(R.id.tvTanggal)
        private var tvDeskripsi: TextView = view.findViewById(R.id.tvDeskripsi)

        fun bindItem(data: TransaksiModel) {
            tvId.text = data.id
            tvBiaya.text = data.biaya
            tvTanggal.text = data.tanggal
            tvDeskripsi.text = data.deskripsi
        }
    }

}