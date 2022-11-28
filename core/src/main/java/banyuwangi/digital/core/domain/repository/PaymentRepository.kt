package banyuwangi.digital.core.domain.repository

import banyuwangi.digital.core.data.Resource
import kotlinx.coroutines.flow.Flow

interface PaymentRepository {

    fun chargeEWallet(orderId: String, channelCode: String, amount: Int): Flow<Resource<String>>
}