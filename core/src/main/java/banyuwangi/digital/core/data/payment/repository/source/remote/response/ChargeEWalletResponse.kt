package banyuwangi.digital.core.data.payment.repository.source.remote.response

import com.google.gson.annotations.SerializedName

data class ChargeEWalletResponse(
    val success: Boolean,
    val message: String,
    val data: DataChargeEWalletItem? = null
)

data class DataChargeEWalletItem(
    val id: String? = null,
    val actions: ActionChargeEWalletItem? = null
)

data class ActionChargeEWalletItem(
    @field:SerializedName("mobile_web_checkout_url") val checkoutUrl: String? = null,
    @field:SerializedName("mobile_deeplink_checkout_url") val deeplinkCheckoutUrl: String? = null,
    @field:SerializedName("qr_checkout_string") val qrCheckout: String? = null
)
