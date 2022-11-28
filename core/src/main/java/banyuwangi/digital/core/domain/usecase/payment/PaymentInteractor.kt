package banyuwangi.digital.core.domain.usecase.payment

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.repository.PaymentRepository
import kotlinx.coroutines.flow.Flow

class PaymentInteractor(private val repository: PaymentRepository) : PaymentUseCase {

    override fun chargeEWallet(
        orderId: String,
        channelCode: String,
        amount: Int
    ): Flow<Resource<String>> = repository.chargeEWallet(orderId, channelCode, amount)
}