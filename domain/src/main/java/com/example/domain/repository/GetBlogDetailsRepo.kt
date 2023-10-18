package com.example.domain.repository

import com.example.domain.model.Blog

interface GetBlogDetailsRepo {
    suspend fun getBlogDetails(id: String): Blog
}