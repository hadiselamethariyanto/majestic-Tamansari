package com.bwx.tamansari.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WisataModel(val nama: String, val foto: String, val rating: Float, val vote_count: Int) :
    Parcelable