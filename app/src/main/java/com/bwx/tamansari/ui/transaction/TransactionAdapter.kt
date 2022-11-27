package com.bwx.tamansari.ui.transaction

import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bwx.tamansari.databinding.ItemTransaksiBinding
import banyuwangi.digital.core.domain.model.TransactionDomain
import com.bumptech.glide.Glide
import com.bwx.tamansari.R
import com.bwx.tamansari.utils.Utils
import java.util.*

class TransactionAdapter : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {
    private val transaksi = mutableListOf<TransactionDomain>()

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

    fun updateData(new: List<TransactionDomain>) {
        transaksi.clear()
        transaksi.addAll(new)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemTransaksiBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var timer: CountDownTimer? = null

        fun bindItem(data: TransactionDomain) {
            binding.tvId.text = "Order ID : ${data.id.uppercase()}"
            binding.tvTitle.text = data.title
            binding.tvTotalFee.text = "IDR ${Utils.thousandSeparator(data.totalFee)}"

            val currentTime = Calendar.getInstance()
            val different = (data.expiredAt * 1000) - currentTime.time.time

            timer = object : CountDownTimer(different, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val minutes = (millisUntilFinished / 1000) / 60
                    val seconds = (millisUntilFinished / 1000) % 60
                    binding.tvTimeRemaining.text = "Selesaikan pembayaran $minutes:$seconds"
                }

                override fun onFinish() {
                    binding.tvTimeRemaining.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.background_time_remaining_finished
                    )
                    binding.tvTimeRemaining.text = "Pembayaran berakhir 00:00:00"
                }
            }
            timer?.start()

            Glide.with(itemView.context).load(R.drawable.ic_ticket_transaction)
                .into(binding.imgIcon)

            itemView.setOnClickListener {
                onItemClickCallback.onItemClicked(data)
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: TransactionDomain)
    }

    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)

        if (holder.timer != null) {
            holder.timer?.cancel()
        }

    }

}