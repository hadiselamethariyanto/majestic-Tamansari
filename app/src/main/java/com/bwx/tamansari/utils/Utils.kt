package com.bwx.tamansari.utils

import android.graphics.Bitmap
import android.graphics.Color
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.floor
import kotlin.math.log10


object Utils {

    fun thousandSeparator(n: Int): String {
        val ch = "."
        var t = n
        val l = floor(log10(t.toDouble())).toInt() + 1
        val str = StringBuffer("")
        var count = 0
        var r: Int

        if (l > 3) {
            for (i in l - 1 downTo 0) {
                r = t % 10
                t /= 10
                count++
                if (count % 3 == 0 && i != 0) {

                    str.append(r.toString())
                    str.append(ch)
                } else str.append(r.toString())
            }
            str.reverse()
        } else str.append(t.toString())
        return str.toString()
    }

    fun formatCalendarToStringDate(time: Long): String {
        val formatter = SimpleDateFormat("dd MMM yy", Locale.getDefault())
        return formatter.format(time)
    }

    fun formatCalendarYYYYMMDD(time: Long): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return formatter.format(time)
    }

    fun formatStringDateToLong(date: String): Long {
        return try {
            val dateFormatted: Date =
                SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).parse(date) ?: Date()
            dateFormatted.time
        } catch (e: Exception) {
            0
        }
    }

    fun formatStringDateToYYYYMMDD(date: String): String {
        return try {
            val dateFormatted: Date =
                SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).parse(date) ?: Date()
            SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(dateFormatted)
        } catch (e: Exception) {
            "2022-01-01"
        }
    }

    fun getQrCodeBitmap(orderId: String): Bitmap {
        val size = 512 //pixels
        val bits = QRCodeWriter().encode(orderId, BarcodeFormat.QR_CODE, size, size)
        return Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565).also {
            for (x in 0 until size) {
                for (y in 0 until size) {
                    it.setPixel(x, y, if (bits[x, y]) Color.BLACK else Color.WHITE)
                }
            }
        }
    }
}