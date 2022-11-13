package com.bwx.tamansari.model

data class RestaurantDomain(
    val id: String,
    val name: String,
    val category: String,
    val latitude: Double,
    val longitude: Double,
    val photoUrl: String,
    val rating: Float,
    val distance:Double
)