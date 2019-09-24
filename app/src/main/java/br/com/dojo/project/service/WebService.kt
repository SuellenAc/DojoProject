package br.com.dojo.project.service

import br.com.dojo.project.service.model.ApiError
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class WebService {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://d79a100f.ngrok.io")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun <T> createRequests(service: Class<T>): T = retrofit.create(service)

    fun handleApiError(httpException: HttpException): ApiError =
        try {
            val errorBodyJson = httpException.response()?.errorBody()?.string() ?: ""
            val moshi = Moshi.Builder().build()
            val jsonAdapter: JsonAdapter<ApiError> = moshi.adapter(ApiError::class.java)
            val apiError: ApiError? = jsonAdapter.fromJson(errorBodyJson)

            apiError?.copy(errorCode = httpException.code()) ?: ApiError(
                httpException.code(),
                httpException.message()
            )
        } catch (exception: Exception) {
            ApiError(httpException.code(), httpException.message())
        }
}