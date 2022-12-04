package banyuwangi.digital.core.data.tpsr.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.mechanism.NetworkOnlyResource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.tpsr.mapper.TpsrMapper
import banyuwangi.digital.core.data.tpsr.repository.source.remote.TpsrRemoteDataSource
import banyuwangi.digital.core.data.tpsr.repository.source.remote.response.GetTpsrBalanceResponse
import banyuwangi.digital.core.domain.model.TpsrBalanceDomain
import banyuwangi.digital.core.domain.repository.TpsrRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TpsrRepositoryImpl(private val remoteDataSource: TpsrRemoteDataSource) : TpsrRepository {
    override fun getTpsrBalance(email: String): Flow<Resource<TpsrBalanceDomain>> {
        return object : NetworkOnlyResource<TpsrBalanceDomain, GetTpsrBalanceResponse>() {
            override fun loadFromNetwork(data: GetTpsrBalanceResponse): Flow<TpsrBalanceDomain> {
                val response = TpsrMapper.mapTpsrBalanceItemToDomain(data.data)
                return flowOf(response)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<GetTpsrBalanceResponse>> =
                remoteDataSource.getTpsrBalance(email)
        }.asFlow()
    }
}