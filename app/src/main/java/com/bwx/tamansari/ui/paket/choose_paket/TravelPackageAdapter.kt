package com.bwx.tamansari.ui.paket.choose_paket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import banyuwangi.digital.core.domain.model.TravelPackageTypeDomain
import com.bwx.tamansari.databinding.ItemChooseTravelPackageBinding
import com.bwx.tamansari.utils.Utils

class TravelPackageAdapter(private val list: List<TravelPackageTypeDomain>) :
    RecyclerView.Adapter<TravelPackageAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    inner class ViewHolder(private val binding: ItemChooseTravelPackageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TravelPackageTypeDomain) {
            binding.tvPackageName.text = data.name
            binding.tvPackagePrice.text = "IDR ${Utils.thousandSeparator(data.price)}"
            binding.btnChoosePackage.setOnClickListener {
                onItemClickCallback.onItemClicked(data)
            }
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

    interface OnItemClickCallback {
        fun onItemClicked(data: TravelPackageTypeDomain)
    }
}