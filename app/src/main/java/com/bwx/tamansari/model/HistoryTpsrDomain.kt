package com.bwx.tamansari.model

data class HistoryTpsrDomain(
    val id: String,
    val description: String,
    val fee: Int,
    val date: Long,
    val type: Int
)