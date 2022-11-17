package com.bwx.tamansari.utils

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

    fun formatCalendarToStringDate(time:Long):String{
        val formatter = SimpleDateFormat("dd MMM yy", Locale.getDefault())
        return formatter.format(time)
    }
}