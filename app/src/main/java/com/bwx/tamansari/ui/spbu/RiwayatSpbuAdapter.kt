package com.bwx.tamansari.ui.spbu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bwx.tamansari.R
import com.bwx.tamansari.model.RiwayatSpbuModel

class RiwayatSpbuAdapter : RecyclerView.Adapter<RiwayatSpbuAdapter.Viewholder>() {
    private val riwayat = mutableListOf<RiwayatSpbuModel>()

    fun updateData(new: MutableList<RiwayatSpbuModel>) {
        riwayat.clear()
        riwayat.addAll(new)
        notifyDataSetChanged()
    }

    class Viewholder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvBiaya: TextView = view.findViewById(R.id.tvBiaya)
        private val tvTanggal: TextView = view.findViewById(R.id.tvTanggal)

        fun bindItem(data: RiwayatSpbuModel) {
            tvBiaya.text = "Rp ${data.biaya}"
            tvTanggal.text = data.tanggal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Viewholder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_riwayat_spbu, parent, false)
    )

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bindItem(riwayat[position])
    }

    override fun getItemCount() = riwayat.size
}