package com.bwx.tamansari.ui.tpsr

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ItemRiwayatClaimSampahBinding
import com.bwx.tamansari.model.HistoryTpsrDomain
import com.bwx.tamansari.utils.Utils

class HistoryTpsrAdapter : RecyclerView.Adapter<HistoryTpsrAdapter.ViewHolder>() {
    private val claim = ArrayList<HistoryTpsrDomain>()

    fun updateData(new: List<HistoryTpsrDomain>) {
        claim.clear()
        claim.addAll(new)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemRiwayatClaimSampahBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItem(data: HistoryTpsrDomain) {
            binding.tvId.text = data.id
            binding.tvTanggal.text = Utils.formatCalendarToStringDate(data.date)
            binding.tvBiaya.text = "Rp${Utils.thousandSeparator(data.fee)}"

            if (data.type == 1) {
                binding.tvStatus.text = "Pemasukan"
                binding.tvStatus.background =
                    ContextCompat.getDrawable(itemView.context, R.drawable.border_claim)
            } else {
                binding.tvStatus.text = "Pengeluaran"
                binding.tvStatus.background =
                    ContextCompat.getDrawable(itemView.context, R.drawable.border_claim_pengeluaran)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemRiwayatClaimSampahBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(claim[position])
    }

    override fun getItemCount() = claim.size
}