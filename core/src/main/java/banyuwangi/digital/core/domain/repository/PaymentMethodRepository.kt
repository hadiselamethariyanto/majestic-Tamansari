package banyuwangi.digital.core.domain.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.PaymentMethodDomain
import kotlinx.coroutines.flow.Flow

interface PaymentMethodRepository {

    fun getPaymentMethod(): Flow<Resource<List<PaymentMethodDomain>>>
}