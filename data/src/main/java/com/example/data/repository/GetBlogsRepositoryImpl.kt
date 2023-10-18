package com.example.data.repository

import com.example.data.mappers.toDomain
import com.example.data.network.ApiService
import com.example.data.network.utils.SafeApiRequest
import com.example.domain.model.Blog
import com.example.domain.repository.GetBlogsRepository
import javax.inject.Inject

class GetBlogsRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    GetBlogsRepository, SafeApiRequest() {
    override suspend fun getBlogs(): List<Blog> {
        val response = safeApiRequest {
            apiService.getBlogs()
        }
        return response.data?.toDomain() ?: emptyList()
    }
}