package banyuwangi.digital.core.domain.usecase.payment_method

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.PaymentMethodDomain
import banyuwangi.digital.core.domain.repository.PaymentMethodRepository
import kotlinx.coroutines.flow.Flow

class PaymentMethodInteractor(private val repository: PaymentMethodRepository) :
    PaymentMethodUseCase {

    override fun getPaymentMethod(): Flow<Resource<List<PaymentMethodDomain>>> =
        repository.getPaymentMethod()

    }