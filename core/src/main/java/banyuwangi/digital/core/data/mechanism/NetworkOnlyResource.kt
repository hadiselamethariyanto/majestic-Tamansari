package banyuwangi.digital.core.data.mechanism

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import kotlinx.coroutines.flow.*

abstract class NetworkOnlyResource<ResultType, RequestType> {

    private val result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        when (val apiResponse = createCall().first()) {
            is ApiResponseOnly.Success -> {
                emitAll(loadFromNetwork(apiResponse.data).map {
                    Resource.Success(it)
                })
            }

            is ApiResponseOnly.Error -> {
                emit(Resource.Error(apiResponse.errorMessage))
            }
        }
    }


    protected abstract fun loadFromNetwork(data: RequestType): Flow<ResultType>

    protected abstract suspend fun createCall(): Flow<ApiResponseOnly<RequestType>>

    fun asFlow(): Flow<Resource<ResultType>> = result
}