package banyuwangi.digital.core.domain.model

data class PaymentMethodDomain(
    val id: String,
    val name: String,
    val code: String,
    val type: Int,
    val typeName: String,
    val logo: String
)