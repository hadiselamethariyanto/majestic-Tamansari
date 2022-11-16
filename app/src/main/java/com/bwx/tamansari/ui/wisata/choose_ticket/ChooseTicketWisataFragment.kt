package com.bwx.tamansari.ui.wisata.choose_ticket

import android.os.Bundle
import android.view.View
import com.bwx.tamansari.databinding.FragmentChooseTicketWisataBinding
import com.bwx.tamansari.model.ChartDomain
import com.bwx.tamansari.model.TicketWisataDomain
import com.bwx.tamansari.ui.base.BaseFragment


class ChooseTicketWisataFragment :
    BaseFragment<FragmentChooseTicketWisataBinding>(FragmentChooseTicketWisataBinding::inflate) {

    private val chartTicket = arrayListOf<ChartDomain>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tickets =
            arguments?.getParcelableArrayList<TicketWisataDomain>("tickets") ?: arrayListOf()

        val chooseTicketWisataAdapter = ChooseTicketWisataAdapter(tickets)
        chooseTicketWisataAdapter.setOnItemClickCallback(object :
            ChooseTicketWisataAdapter.OnItemClickCallback {
            override fun onChooseTicket(data: TicketWisataDomain) {
                chartTicket.add(
                    ChartDomain(
                        idProduct = data.id,
                        productName = data.name,
                        productPrice = data.price,
                        total = 1
                    )
                )
                chooseTicketWisataAdapter.updateData(chartTicket)
            }

            override fun onPlusTicket(data: TicketWisataDomain) {
                for (x in 0 until chartTicket.size){
                    if (chartTicket[x].idProduct == data.id){
                        chartTicket[x].total++
                    }
                }
                chooseTicketWisataAdapter.updateData(chartTicket)
            }

            override fun onMinusTicket(data: TicketWisataDomain) {
                for (x in 0 until chartTicket.size){
                    if (chartTicket[x].idProduct == data.id){
                        val total = chartTicket[x].total
                        if (total==1){
                            chartTicket.removeAt(x)
                        }else{
                            chartTicket[x].total--
                        }
                    }
                }
                chooseTicketWisataAdapter.updateData(chartTicket)
            }

        })
        binding.rvTicketWisata.adapter = chooseTicketWisataAdapter

    }

}