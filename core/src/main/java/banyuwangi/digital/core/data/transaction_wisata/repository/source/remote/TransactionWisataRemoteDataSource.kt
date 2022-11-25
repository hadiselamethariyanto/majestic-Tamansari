package banyuwangi.digital.core.data.transaction_wisata.repository.source.remote

import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.network.TransactionWisataService
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response.InsertTransactionWisataResponse
import banyuwangi.digital.core.domain.model.ChartDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class TransactionWisataRemoteDataSource(private val service: TransactionWisataService) {

    suspend fun insertTransactionWisata(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idWisata: String,
        charts: List<ChartDomain>
    ): Flow<ApiResponseOnly<InsertTransactionWisataResponse>> {
        return flow {
            try {
                val chartMap: HashMap<String, RequestBody> = HashMap()
                for ((index, chart) in charts.withIndex()) {
                    chartMap["chart[${index}][id_product]"] =
                        chart.idProduct.toRequestBody("text/plain".toMediaType())
                    chartMap["chart[${index}][product_price]"] =
                        chart.productPrice.toString().toRequestBody("text/plain".toMediaType())
                    chartMap["chart[${index}][total]"] =
                        chart.total.toString().toRequestBody("text/plain".toMediaType())
                }

                val response =
                    service.insertTransactionWisata(
                        customerName = customerName.toRequestBody("text/plain".toMediaType()),
                        customerEmail = customerEmail.toRequestBody("text/plain".toMediaType()),
                        customerPhoneNumber = customerPhoneNumber.toRequestBody("text/plain".toMediaType()),
                        fee = fee.toString().toRequestBody("text/plain".toMediaType()),
                        convenienceFee = convenienceFee.toString()
                            .toRequestBody("text/plain".toMediaType()),
                        totalFee = totalFee.toString().toRequestBody("text/plain".toMediaType()),
                        idWisata = idWisata.toRequestBody("text/plain".toMediaType()),
                        chart = chartMap
                    )
                if (response.success) {
                    emit(ApiResponseOnly.Success(response))
                } else {
                    emit(ApiResponseOnly.Error(response.message))
                }
            } catch (e: Exception) {
                emit(ApiResponseOnly.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}