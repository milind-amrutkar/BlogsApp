package com.example.data.network

import com.example.common.Constant.APP_ID
import com.example.data.network.model.BlogDTO
import com.example.data.network.model.BlogsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("post")
    suspend fun getBlogs(
        @Header("app-id") appId: String = APP_ID
    ): Response<BlogsDTO>

    @GET("post")
    suspend fun getBlogsPagination(
        @Header("app-id") appId: String = APP_ID,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<BlogsDTO>

    @GET("post/{id}")
    suspend fun getBlogDetails(
        @Header("app-id") appId: String = APP_ID,
        @Path("id") id: String
    ): Response<BlogDTO>

}