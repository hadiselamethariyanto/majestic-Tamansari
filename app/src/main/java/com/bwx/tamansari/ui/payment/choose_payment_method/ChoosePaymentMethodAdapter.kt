package com.bwx.tamansari.ui.payment.choose_payment_method

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import banyuwangi.digital.core.domain.model.PaymentMethodDomain
import com.bumptech.glide.Glide
import com.bwx.tamansari.databinding.ItemPaymentMethodBinding

class ChoosePaymentMethodAdapter : RecyclerView.Adapter<ChoosePaymentMethodAdapter.ViewHolder>() {

    private val list = ArrayList<PaymentMethodDomain>()

    var selectedPosition = -1

    fun setPaymentMethod(position: Int) {
        selectedPosition = position
        notifyDataSetChanged()
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun updateData(newList: List<PaymentMethodDomain>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemPaymentMethodBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: PaymentMethodDomain, position: Int) {
            binding.tvMethodName.text = data.name
            binding.radio.isChecked = selectedPosition == position
            binding.radio.setOnClickListener {
                onItemClickCallback.onItemClicked(data, position)
            }
            Glide.with(itemView.context).load(data.logo).fitCenter().into(binding.imgLogo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemPaymentMethodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickCallback {
        fun onItemClicked(data: PaymentMethodDomain, position: Int)
    }
}