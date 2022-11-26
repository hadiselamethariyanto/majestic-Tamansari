package com.bwx.tamansari.ui.transaction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bwx.tamansari.databinding.ItemTransaksiBinding
import com.bwx.tamansari.model.TransaksiModel

class TransactionAdapter : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {
    private val transaksi = mutableListOf<TransaksiModel>()

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemTransaksiBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(transaksi[position])
    }

    override fun getItemCount() = transaksi.size

    fun updateData(new: MutableList<TransaksiModel>) {
        transaksi.clear()
        transaksi.addAll(new)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemTransaksiBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItem(data: TransaksiModel) {
            binding.tvId.text = data.id
            binding.tvBiaya.text = data.biaya
            binding.tvTanggal.text = data.tanggal
            binding.tvDeskripsi.text = data.deskripsi

            itemView.setOnClickListener {
                onItemClickCallback.onItemClicked(data)
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: TransaksiModel)
    }

}