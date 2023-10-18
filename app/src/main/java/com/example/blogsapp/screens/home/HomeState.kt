package com.example.blogsapp.screens.home

import com.example.domain.model.Blog

data class HomeState(
    var isLoading: Boolean = false,
    var data: List<Blog>? = null,
    var error: String = ""
)
