package com.bwx.tamansari.model

data class HomestayModel(
    val id: String,
    val nama: String,
    val jarak: Double,
    val harga: Int,
    val rating: Float,
    val totalReview: Int,
    val star:Float,
    val foto: List<String>
)