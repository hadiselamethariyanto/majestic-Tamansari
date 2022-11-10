package com.bwx.tamansari.ui.tpsr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bwx.tamansari.R
import com.bwx.tamansari.model.RiwayatClaimSampahModel

class RiwayatClaimSampahAdapter : RecyclerView.Adapter<RiwayatClaimSampahAdapter.Viewholder>() {
    val claim = mutableListOf<RiwayatClaimSampahModel>()

    fun updateData(new: MutableList<RiwayatClaimSampahModel>) {
        claim.clear()
        claim.addAll(new)
        notifyDataSetChanged()
    }

    class Viewholder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvId: TextView = view.findViewById(R.id.tvId)
        private val tvTanggal: TextView = view.findViewById(R.id.tvTanggal)
        private val tvBiaya: TextView = view.findViewById(R.id.tvBiaya)

        fun bindItem(data: RiwayatClaimSampahModel) {
            tvId.text = data.id
            tvTanggal.text = data.tanggal
            tvBiaya.text = "Rp${data.biaya}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Viewholder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_riwayat_claim_sampah, parent, false)
    )

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bindItem(claim[position])
    }

    override fun getItemCount() = claim.size
}