package br.com.dojo.project.service

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

}