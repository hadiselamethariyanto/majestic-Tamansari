package banyuwangi.digital.core.data.transaction_restaurant.repository.source.remote

import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.transaction_restaurant.repository.source.remote.network.TransactionRestaurantService
import banyuwangi.digital.core.data.transaction_restaurant.repository.source.remote.response.GetTransactionRestaurantResponse
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response.InsertTransactionWisataResponse
import banyuwangi.digital.core.domain.model.CartRestaurantDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class TransactionRestaurantRemoteDataSource(private val service: TransactionRestaurantService) {
    suspend fun insertTransactionRestaurant(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idHomestay: String,
        idRestaurant: String,
        carts: List<CartRestaurantDomain>,
        ongkir: Int
    ): Flow<ApiResponseOnly<InsertTransactionWisataResponse>> {
        return flow {
            try {
                val cartMap: HashMap<String, RequestBody> = HashMap()
                for ((index, cart) in carts.withIndex()) {
                    cartMap["cart[${index}][id_product]"] =
                        cart.idProduct.toRequestBody("text/plain".toMediaType())
                    cartMap["cart[${index}][product_price]"] =
                        cart.productPrice.toString().toRequestBody("text/plain".toMediaType())
                    cartMap["cart[${index}][total]"] =
                        cart.total.toString().toRequestBody("text/plain".toMediaType())
                }
                val response = service.insertTransaction(
                    customerName = customerName.toRequestBody("text/plain".toMediaType()),
                    customerEmail = customerEmail.toRequestBody("text/plain".toMediaType()),
                    customerPhoneNumber = customerPhoneNumber.toRequestBody("text/plain".toMediaType()),
                    fee = fee.toString().toRequestBody("text/plain".toMediaType()),
                    convenienceFee = convenienceFee.toString()
                        .toRequestBody("text/plain".toMediaType()),
                    totalFee = totalFee.toString().toRequestBody("text/plain".toMediaType()),
                    idHomestay = idHomestay.toRequestBody("text/plain".toMediaType()),
                    idRestaurant = idRestaurant.toRequestBody("text/plain".toMediaType()),
                    cart = cartMap,
                    ongkir = ongkir.toString().toRequestBody("text/plain".toMediaType())
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

    suspend fun getTransactionRestaurant(id: String): Flow<ApiResponseOnly<GetTransactionRestaurantResponse>> {
        return flow {
            try {
                val response = service.getTransactionRestaurant(id)
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