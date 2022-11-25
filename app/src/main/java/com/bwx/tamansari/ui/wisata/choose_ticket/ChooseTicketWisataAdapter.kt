package com.bwx.tamansari.ui.wisata.choose_ticket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import banyuwangi.digital.core.domain.model.TicketWisataDomain
import com.bwx.tamansari.databinding.ItemChooseTicketWisataBinding
import banyuwangi.digital.core.domain.model.ChartDomain
import com.bwx.tamansari.utils.Utils

class ChooseTicketWisataAdapter(private val tickets: List<TicketWisataDomain>) :
    RecyclerView.Adapter<ChooseTicketWisataAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    private val chartTicket = arrayListOf<ChartDomain>()

    fun updateData(newChart: List<ChartDomain>) {
        chartTicket.clear()
        chartTicket.addAll(newChart)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemChooseTicketWisataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ticket: TicketWisataDomain) {
            binding.tvTicketName.text = ticket.name
            binding.tvTicketPrice.text = "IDR ${Utils.thousandSeparator(ticket.price)}"
            binding.btnChooseTicket.setOnClickListener {
                onItemClickCallback.onChooseTicket(ticket)
            }

            binding.tvMinus.setOnClickListener {
                onItemClickCallback.onMinusTicket(ticket)
            }

            binding.tvPlus.setOnClickListener {
                onItemClickCallback.onPlusTicket(ticket)
            }

            binding.llInfo.visibility = View.GONE
            binding.btnChooseTicket.visibility = View.VISIBLE

            for (x in 0 until chartTicket.size) {
                if (chartTicket[x].idProduct == ticket.id) {
                    val total = chartTicket[x].total
                    binding.tvTotal.text = total.toString()
                    binding.llInfo.visibility = View.VISIBLE
                    binding.btnChooseTicket.visibility = View.GONE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemChooseTicketWisataBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tickets[position])
    }

    override fun getItemCount(): Int = tickets.size

    interface OnItemClickCallback {
        fun onChooseTicket(data: TicketWisataDomain)
        fun onPlusTicket(data: TicketWisataDomain)
        fun onMinusTicket(data: TicketWisataDomain)
    }
}