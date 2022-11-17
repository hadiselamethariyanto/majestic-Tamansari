package com.bwx.tamansari.ui.paket.choose_paket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bwx.tamansari.databinding.ItemChooseTravelPackageBinding
import com.bwx.tamansari.model.TravelPackageDomain
import com.bwx.tamansari.utils.Utils

class TravelPackageAdapter(private val list: List<TravelPackageDomain>) :
    RecyclerView.Adapter<TravelPackageAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemChooseTravelPackageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TravelPackageDomain) {
            binding.tvPackageName.text = data.name
            binding.tvPackagePrice.text = "IDR ${Utils.thousandSeparator(data.price)}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemChooseTravelPackageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}