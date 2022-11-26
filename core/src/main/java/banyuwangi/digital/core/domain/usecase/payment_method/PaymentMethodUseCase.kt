package banyuwangi.digital.core.domain.usecase.payment_method

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.PaymentMethodDomain
import kotlinx.coroutines.flow.Flow

interface PaymentMethodUseCase {

    fun getPaymentMethod(): Flow<Resource<List<PaymentMethodDomain>>>
}