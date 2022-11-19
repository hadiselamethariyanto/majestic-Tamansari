package banyuwangi.digital.core.data.network

sealed class ApiResponseOnly <out R> {
    data class Success<out T>(val data: T) : ApiResponseOnly<T>()
    data class Error(val errorMessage: String) : ApiResponseOnly<Nothing>()
}