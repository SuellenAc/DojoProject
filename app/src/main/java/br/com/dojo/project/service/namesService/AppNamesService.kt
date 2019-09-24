package br.com.dojo.project.service.namesService

import br.com.dojo.project.model.PersonName
import br.com.dojo.project.model.AppResult
import br.com.dojo.project.service.WebService
import br.com.dojo.project.service.model.ApiError
import com.squareup.moshi.JsonDataException
import retrofit2.HttpException
import retrofit2.http.GET
import retrofit2.http.Query

class AppNamesService(private val webService: WebService) : NamesService {

    private val requests = webService.createRequests(Requests::class.java)

    override suspend fun getNames(
        amount: String?,
        region: String?,
        gender: String?
    ): AppResult<List<PersonName>, ApiError> =
        try {
            AppResult.Success(requests.getNames(amount, region, gender))
        } catch (e: HttpException) {
            AppResult.Error(webService.handleApiError(e))
        } catch (jsonDataException: JsonDataException) {
            AppResult.Error(ApiError(-1, "Invalid Json"))
        }

    interface Requests {
        @GET("names")
        suspend fun getNames(
            @Query("amount") amount: String?,
            @Query("region") region: String?,
            @Query("gender") gender: String?
        ): List<PersonName>
    }

}