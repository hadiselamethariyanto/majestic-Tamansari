package banyuwangi.digital.core.data.payment.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.mechanism.NetworkOnlyResource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.payment.repository.source.remote.PaymentRemoteDataSource
import banyuwangi.digital.core.data.payment.repository.source.remote.response.ChargeEWalletResponse
import banyuwangi.digital.core.domain.repository.PaymentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class PaymentRepositoryImpl(private val remoteDataSource: PaymentRemoteDataSource) :
    PaymentRepository {
    override fun chargeEWallet(
        orderId: String,
        channelCode: String,
        amount: Int
    ): Flow<Resource<String>> {
        return object : NetworkOnlyResource<String, ChargeEWalletResponse>() {
            override fun loadFromNetwork(data: ChargeEWalletResponse): Flow<String> {
                return flowOf(data.data?.actions?.checkoutUrl ?: "")
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<ChargeEWalletResponse>> =
                remoteDataSource.chargeEWallet(orderId, channelCode, amount)

        }.asFlow()
    }
}