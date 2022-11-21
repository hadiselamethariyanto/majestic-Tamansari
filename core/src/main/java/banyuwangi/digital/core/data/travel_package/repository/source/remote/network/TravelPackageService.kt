package banyuwangi.digital.core.data.travel_package.repository.source.remote.network

import banyuwangi.digital.core.data.travel_package.repository.source.remote.response.GetTravelPackageResponse
import banyuwangi.digital.core.utils.Constant
import retrofit2.http.GET

interface TravelPackageService {

    @GET(Constant.API_GET_TRAVEL_PACKAGE)
    suspend fun getTravelPackage(): GetTravelPackageResponse
}