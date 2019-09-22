package br.com.dojo.project.service.regionService

import br.com.dojo.project.service.WebService
import retrofit2.http.GET

class AppRegionService(webService: WebService) : RegionService {

    private val requests = webService.createRequests(Requests::class.java)

    override suspend fun getRegions(): List<String> = requests.getRegions()

    interface Requests {
        @GET("regions")
        suspend fun getRegions(): List<String>
    }
}