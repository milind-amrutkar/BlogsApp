package com.example.blogsapp.navigation

sealed class NavigationItem(val route: String) {
    object Home : NavigationItem("Home")
    object DetailScreen : NavigationItem("details/{blogid}")
}
