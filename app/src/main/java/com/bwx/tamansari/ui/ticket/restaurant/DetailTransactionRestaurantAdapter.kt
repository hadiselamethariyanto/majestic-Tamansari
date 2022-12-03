package com.bwx.tamansari.ui.ticket.restaurant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import banyuwangi.digital.core.domain.model.ChartDomain
import com.bwx.tamansari.databinding.ItemChartItemBinding
import com.bwx.tamansari.utils.Utils

class DetailTransactionRestaurantAdapter :
    RecyclerView.Adapter<DetailTransactionRestaurantAdapter.ViewHolder>() {

    private val list = ArrayList<ChartDomain>()

    fun updateData(newList: List<ChartDomain>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemChartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ChartDomain) {
            binding.tvItemName.text = data.productName
            binding.tvTotalItem.text = data.total.toString()
            binding.tvFee.text = "x ${Utils.thousandSeparator(data.productPrice)}"
            binding.tvTotalFee.text =
                "IDR ${Utils.thousandSeparator(data.productPrice * data.total)}"
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