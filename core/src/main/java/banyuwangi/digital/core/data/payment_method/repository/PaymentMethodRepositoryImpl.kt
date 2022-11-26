package banyuwangi.digital.core.data.payment_method.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.mechanism.NetworkOnlyResource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.payment_method.mapper.PaymentMethodMapper
import banyuwangi.digital.core.data.payment_method.repository.source.remote.PaymentMethodRemoteDataSource
import banyuwangi.digital.core.data.payment_method.repository.source.remote.response.GetPaymentMethodResponse
import banyuwangi.digital.core.domain.model.PaymentMethodDomain
import banyuwangi.digital.core.domain.repository.PaymentMethodRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class PaymentMethodRepositoryImpl(private val remoteDataSource: PaymentMethodRemoteDataSource) :
    PaymentMethodRepository {
    override fun getPaymentMethod(): Flow<Resource<List<PaymentMethodDomain>>> {
        return object : NetworkOnlyResource<List<PaymentMethodDomain>, GetPaymentMethodResponse>() {
            override fun loadFromNetwork(data: GetPaymentMethodResponse): Flow<List<PaymentMethodDomain>> {
                val paymentMethods = PaymentMethodMapper.mapPaymentMethodItemToDomain(data.data)
                return flowOf(paymentMethods)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<GetPaymentMethodResponse>> =
                remoteDataSource.getPaymentMethod()

        }.asFlow()
    }
}