package banyuwangi.digital.core.data.payment_method.mapper

import banyuwangi.digital.core.data.payment_method.repository.source.remote.response.PaymentMethodItem
import banyuwangi.digital.core.domain.model.PaymentMethodDomain

object PaymentMethodMapper {

    fun mapPaymentMethodItemToDomain(list: List<PaymentMethodItem>): List<PaymentMethodDomain> =
        list.map {
            PaymentMethodDomain(
                id = it.id ?: "",
                name = it.name ?: "",
                code = it.code ?: "",
                type = it.type ?: 0,
                typeName = it.typeName ?: "",
                logo = it.logo ?: ""
            )
        }
}