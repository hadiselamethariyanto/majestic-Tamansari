package com.bwx.tamansari.ui.restaurant.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import banyuwangi.digital.core.domain.model.HomestayDomain
import com.bwx.tamansari.databinding.ItemLocationBinding

class ChooseLocationAdapter : RecyclerView.Adapter<ChooseLocationAdapter.ViewHolder>() {

    private val homestays = ArrayList<HomestayDomain>()

    fun updateData(newList: List<HomestayDomain>) {
        homestays.clear()
        homestays.addAll(newList)
        notifyDataSetChanged()
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    inner class ViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun binding(homestayDomain: HomestayDomain) {
            binding.tvLocationName.text = homestayDomain.name
            binding.tvLocationAddress.text = homestayDomain.address

            itemView.setOnClickListener {
                onItemClickCallback.onItemClicked(homestayDomain)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(homestays[position])
    }

    override fun getItemCount(): Int = homestays.size

    interface OnItemClickCallback {
        fun onItemClicked(data: HomestayDomain)
    }
}