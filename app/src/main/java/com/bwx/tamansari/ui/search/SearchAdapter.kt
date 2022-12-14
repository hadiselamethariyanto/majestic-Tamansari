package com.bwx.tamansari.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import banyuwangi.digital.core.domain.model.MapsOutletDomain
import com.bwx.tamansari.databinding.ItemLocationBinding
import com.bwx.tamansari.ui.peta.MapsAdapter

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private val list = ArrayList<MapsOutletDomain>()

    fun updateData(newList: List<MapsOutletDomain>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: MapsOutletDomain) {
            binding.tvLocationName.text = data.name
            binding.tvLocationAddress.text = data.address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(list[position])
        }

    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickCallback {
        fun onItemClicked(data: MapsOutletDomain)
    }
}