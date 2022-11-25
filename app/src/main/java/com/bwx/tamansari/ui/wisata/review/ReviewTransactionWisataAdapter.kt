package com.bwx.tamansari.ui.wisata.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bwx.tamansari.databinding.ItemChartItemBinding
import banyuwangi.digital.core.domain.model.ChartDomain
import com.bwx.tamansari.utils.Utils

class ReviewTransactionWisataAdapter(private val list: List<ChartDomain>) :
    RecyclerView.Adapter<ReviewTransactionWisataAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemChartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ChartDomain) {
            binding.tvItemName.text = data.productName
            binding.tvTotalItem.text = data.total.toString()
            binding.tvTotalFee.text = "IDR ${Utils.thousandSeparator(data.productPrice)}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemChartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}