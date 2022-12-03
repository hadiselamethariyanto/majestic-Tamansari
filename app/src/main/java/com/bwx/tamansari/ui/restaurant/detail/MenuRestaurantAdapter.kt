package com.bwx.tamansari.ui.restaurant.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import banyuwangi.digital.core.domain.model.CartRestaurantDomain
import banyuwangi.digital.core.domain.model.ChartDomain
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bwx.tamansari.R
import com.bwx.tamansari.databinding.ItemMenuRestaurantBinding
import banyuwangi.digital.core.domain.model.MenuRestaurantDomain
import com.bwx.tamansari.utils.Utils

class MenuRestaurantAdapter(private val list: List<MenuRestaurantDomain>) :
    RecyclerView.Adapter<MenuRestaurantAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    private val chartTicket = arrayListOf<CartRestaurantDomain>()

    fun updateData(newChart: List<CartRestaurantDomain>) {
        chartTicket.clear()
        chartTicket.addAll(newChart)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemMenuRestaurantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MenuRestaurantDomain) {
            binding.menuName.text = data.name
            binding.menuPrice.text = Utils.thousandSeparator(data.price)

            binding.btnAddMenu.setOnClickListener {
                onItemClickCallback.onAddMenu(data)
            }

            binding.tvMinus.setOnClickListener {
                onItemClickCallback.onMinusMenu(data)
            }

            binding.tvPlus.setOnClickListener {
                onItemClickCallback.onPlusMenu(data)
            }

            binding.llInfo.visibility = View.GONE
            binding.btnAddMenu.visibility = View.VISIBLE

            for (x in 0 until chartTicket.size) {
                if (chartTicket[x].idProduct == data.id) {
                    val total = chartTicket[x].total
                    binding.tvTotal.text = total.toString()
                    binding.llInfo.visibility = View.VISIBLE
                    binding.btnAddMenu.visibility = View.GONE
                }
            }

            Glide.with(itemView.context).load(data.photoUrl)
                .placeholder(R.drawable.placeholder)
                .transform(CenterCrop(), RoundedCorners(24))
                .into(binding.imgMenu)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemMenuRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickCallback {
        fun onAddMenu(data: MenuRestaurantDomain)
        fun onPlusMenu(data: MenuRestaurantDomain)
        fun onMinusMenu(data: MenuRestaurantDomain)
    }
}