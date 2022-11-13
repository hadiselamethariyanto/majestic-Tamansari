package com.bwx.tamansari.model

data class PaketWisataModel(
    val nama: String,
    val harga: Int,
    val rating: Float,
    val photos: List<String>,
    val totalReview: Int
)