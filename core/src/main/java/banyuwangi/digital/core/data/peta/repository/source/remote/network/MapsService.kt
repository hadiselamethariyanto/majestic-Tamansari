package banyuwangi.digital.core.data.peta.repository.source.remote.network

import banyuwangi.digital.core.data.peta.repository.source.remote.response.GetMapsOutletResponse
import banyuwangi.digital.core.utils.Constant
import retrofit2.http.GET

interface MapsService {

    @GET(Constant.API_GET_MAPS_OUTLET)
    suspend fun getMapsOutlet():GetMapsOutletResponse
}