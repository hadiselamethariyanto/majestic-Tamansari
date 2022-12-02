package com.bwx.tamansari.ui.restaurant.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import banyuwangi.digital.core.domain.model.ChartDomain
import banyuwangi.digital.core.domain.model.MenuRestaurantDomain
import banyuwangi.digital.core.domain.model.TicketWisataDomain

class DetailRestaurantViewModel : ViewModel() {

    private val _chart = MutableLiveData<ArrayList<ChartDomain>>()
    val chart: LiveData<ArrayList<ChartDomain>> get() = _chart

    fun addChart(chart: ChartDomain) {
        val list = _chart.value ?: arrayListOf()
        list.add(chart)
        _chart.value = list
    }

    fun plusChart(data: MenuRestaurantDomain) {
        val chartTicket = _chart.value ?: arrayListOf()
        for (x in 0 until chartTicket.size) {
            if (chartTicket[x].idProduct == data.id) {
                chartTicket[x].total++
            }
        }
        _chart.value = chartTicket
    }

    fun deleteChart(data: MenuRestaurantDomain) {
        val chartTicket = _chart.value ?: arrayListOf()
        for (x in 0 until chartTicket.size) {
            if (chartTicket[x].idProduct == data.id) {
                val total = chartTicket[x].total
                if (total == 1) {
                    chartTicket.remove(chartTicket[x])
                    break
                } else {
                    chartTicket[x].total--
                }
            }
        }
        _chart.value = chartTicket
    }
}