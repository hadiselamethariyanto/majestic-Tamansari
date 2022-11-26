package banyuwangi.digital.core.data.payment_method.repository.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetPaymentMethodResponse(
    val success: Boolean,
    val message: String,
    val data: List<PaymentMethodItem>
)

data class PaymentMethodItem(
    val id: String? = null,
    val name: String? = null,
    val code: String? = null,
    val type: Int? = null,
    @field:SerializedName("type_name")
    val typeName: String? = null,
    val logo: String? = null
)