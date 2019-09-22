package br.com.dojo.project.service.namesService

import br.com.dojo.project.model.PersonName
import br.com.dojo.project.service.WebService
import retrofit2.http.GET
import retrofit2.http.Query

class AppNamesService(webService: WebService) : NamesService {

    private val requests = webService.createRequests(Requests::class.java)

    override suspend fun getNames(amount: String?, region: String?, gender: String?) =
        requests.getNames(amount, region, gender)

    interface Requests {
        @GET("names")
        suspend fun getNames(
            @Query("amount") amount: String?,
            @Query("region") region: String?,
            @Query("gender") gender: String?
        ): List<PersonName>
    }

}