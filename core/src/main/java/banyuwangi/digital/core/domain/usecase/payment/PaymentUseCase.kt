package banyuwangi.digital.core.domain.usecase.payment

import banyuwangi.digital.core.data.Resource
import kotlinx.coroutines.flow.Flow

interface PaymentUseCase {

    fun chargeEWallet(orderId: String, channelCode: String, amount: Int): Flow<Resource<String>>
}