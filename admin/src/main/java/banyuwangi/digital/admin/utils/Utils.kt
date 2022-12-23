package banyuwangi.digital.admin.utils

import com.google.gson.Gson

object Utils {
    fun <A> String.fromJson(type: Class<A>): A {
        return Gson().fromJson(this, type)
    }

    fun <A> A.toJson(): String? {
        return Gson().toJson(this)
    }
}