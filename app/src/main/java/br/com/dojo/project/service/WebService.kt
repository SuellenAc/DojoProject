package br.com.dojo.project.service

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class WebService {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://a443b97e.ngrok.io")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun <T> createRequests(service: Class<T>): T = retrofit.create(service)

}