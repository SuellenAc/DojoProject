package br.com.dojo.project.service.regionService

import br.com.dojo.project.model.AppResult
import br.com.dojo.project.service.WebService
import br.com.dojo.project.service.model.ApiError
import com.squareup.moshi.JsonDataException
import retrofit2.HttpException
import retrofit2.http.GET

class AppRegionService(private val webService: WebService) : RegionService {

    private val requests = webService.createRequests(Requests::class.java)

    override suspend fun getRegions(): AppResult<List<String>, ApiError> = try {
        AppResult.Success(requests.getRegions())
    } catch (e: HttpException) {
        AppResult.Error(webService.handleApiError(e))
    } catch (jsonDataException: JsonDataException) {
        AppResult.Error(ApiError(-1, "Invalid Json"))
    }

    interface Requests {
        @GET("regions")
        suspend fun getRegions(): List<String>
    }
}