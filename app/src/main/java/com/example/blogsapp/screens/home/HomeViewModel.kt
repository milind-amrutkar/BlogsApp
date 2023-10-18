package com.example.blogsapp.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.data.paging.BlogRemoteMediator
import com.example.data.room.BlogDAO
import com.example.domain.repository.GetPagerBlogsRepo
import com.example.domain.use_cases.GetBlogsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getBlogsUseCase: GetBlogsUseCase,
    private val getPagerBlogsRepo: GetPagerBlogsRepo,
    private val blogDAO: BlogDAO
) :
    ViewModel() {

    @OptIn(ExperimentalPagingApi::class)
    val pager = Pager(
        config = PagingConfig(pageSize = 10, prefetchDistance = 5),
        remoteMediator = BlogRemoteMediator(
            getPagerBlogsRepo = getPagerBlogsRepo,
            blogDAO = blogDAO
        )
    ) {
        blogDAO.getAllBlogItems()
    }.flow.cachedIn(viewModelScope)

//    private val _blogs = mutableStateOf<HomeState>(HomeState())
//    val blogs: State<HomeState> = _blogs

//    init {
//        getBlogs()
//    }
//
//    fun getBlogs() {
//        getBlogsUseCase().onEach {
//            when (it) {
//                is Resource.Loading -> {
//                    _blogs.value = HomeState(isLoading = true)
//                }
//
//                is Resource.Error -> {
//                    _blogs.value = HomeState(error = it.message.toString())
//                }
//
//                is Resource.Success -> {
//                    _blogs.value = HomeState(data = it.data)
//                }
//            }
//        }.launchIn(viewModelScope)
//    }
}