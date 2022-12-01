package banyuwangi.digital.core.data.transaction_travel_package.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.mechanism.NetworkOnlyResource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.transaction_travel_package.mapper.TransactionTravelPackageMapper
import banyuwangi.digital.core.data.transaction_travel_package.repository.source.remote.TransactionTravelPackageRemoteDataSource
import banyuwangi.digital.core.data.transaction_travel_package.repository.source.remote.response.GetTransactionTravelPackageResponse
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response.InsertTransactionWisataResponse
import banyuwangi.digital.core.data.transactions.mapper.TransactionsMapper
import banyuwangi.digital.core.domain.model.TransactionDomain
import banyuwangi.digital.core.domain.model.TransactionTravelPackageDomain
import banyuwangi.digital.core.domain.repository.TransactionTravelPackageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TransactionTravelPackageRepositoryImpl(private val remoteDataSource: TransactionTravelPackageRemoteDataSource) :
    TransactionTravelPackageRepository {
    override fun insertTransactionTravelPackage(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idTravelPackage: String,
        idTravelPackageType: String,
        selectedDate: String
    ): Flow<Resource<TransactionDomain>> {
        return object : NetworkOnlyResource<TransactionDomain, InsertTransactionWisataResponse>() {
            override fun loadFromNetwork(data: InsertTransactionWisataResponse): Flow<TransactionDomain> {
                val response = TransactionsMapper.mapTransactionItemToDomain(data.data)
                return flowOf(response)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<InsertTransactionWisataResponse>> =
                remoteDataSource.insertTransactionTravelPackage(
                    customerName,
                    customerEmail,
                    customerPhoneNumber,
                    fee,
                    convenienceFee,
                    totalFee,
                    idTravelPackage,
                    idTravelPackageType,
                    selectedDate
                )

        }.asFlow()
    }

    override fun getTransactionTravelPackage(id: String): Flow<Resource<TransactionTravelPackageDomain>> {
        return object :
            NetworkOnlyResource<TransactionTravelPackageDomain, GetTransactionTravelPackageResponse>() {
            override fun loadFromNetwork(data: GetTransactionTravelPackageResponse): Flow<TransactionTravelPackageDomain> {
                val response =
                    TransactionTravelPackageMapper.mapTransactionTravelPackageItemToDomain(data.data)
                return flowOf(response)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<GetTransactionTravelPackageResponse>> =
                remoteDataSource.getTransactionTravelPackage(id)

        }.asFlow()
    }


}