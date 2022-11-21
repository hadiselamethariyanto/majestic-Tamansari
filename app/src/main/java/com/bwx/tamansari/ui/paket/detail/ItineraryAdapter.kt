package com.bwx.tamansari.ui.paket.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bwx.tamansari.databinding.ItemIteneraryBinding
import banyuwangi.digital.core.domain.model.ItineraryDomain

class ItineraryAdapter(private val list: List<ItineraryDomain>) :
    RecyclerView.Adapter<ItineraryAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemIteneraryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(itinerary: ItineraryDomain, position: Int) {
            binding.tvTime.text = itinerary.time
            binding.tvDescription.text = itinerary.description

            when (position) {
                0 -> {
                    binding.vTop.visibility = View.GONE
                }
                list.size-1 -> {
                    binding.vBottom.visibility = View.GONE
                }
                else -> {
                    binding.vTop.visibility = View.VISIBLE
                    binding.vBottom.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemIteneraryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}