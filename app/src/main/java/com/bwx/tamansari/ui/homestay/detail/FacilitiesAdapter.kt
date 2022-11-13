package com.bwx.tamansari.ui.homestay.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bwx.tamansari.databinding.ItemFasilitasBinding
import com.bwx.tamansari.model.FacilityDomain

class FacilitiesAdapter(private val facilities: List<FacilityDomain>) :
    RecyclerView.Adapter<FacilitiesAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemFasilitasBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binding(facility: FacilityDomain) {
            binding.tvFacilityName.text = facility.name
            Glide.with(itemView.context).load(facility.iconUrl).into(binding.imgFacility)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemFasilitasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(facilities[position])
    }

    override fun getItemCount(): Int = facilities.size
}