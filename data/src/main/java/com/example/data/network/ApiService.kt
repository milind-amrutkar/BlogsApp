package com.example.data.network

import com.example.common.Constant.APP_ID
import com.example.data.network.model.BlogsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("post")
    suspend fun getBlogs(
        @Header("app-id") appId: String = APP_ID
    ): Response<BlogsDTO>

}