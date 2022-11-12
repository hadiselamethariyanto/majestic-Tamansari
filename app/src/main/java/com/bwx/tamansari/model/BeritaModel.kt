package com.bwx.tamansari.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BeritaModel(
    val judul: String,
    val tanggal: String,
    val foto: String,
    val description: String,
    val totalComments: Int,
    val totalLikes: Int,
    val category:String
) : Parcelable