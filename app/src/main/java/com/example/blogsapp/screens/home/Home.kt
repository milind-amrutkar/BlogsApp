package com.example.blogsapp.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.domain.model.Blog

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val res = viewModel.blogs.value

    if (res.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (res.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = res.error.toString(), modifier = Modifier.align(Alignment.Center))
        }
    }

    LazyColumn {
        res.data?.let {
            items(it) {
                PostItem(it)
            }
        }
    }
}

@Composable
fun PostItem(it: Blog) {
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularImage(50.0, 50.0, 25.0, it.owner.picture)
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "${it.owner.firstName} ${it.owner.lastName}")
        }
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            painter = rememberAsyncImagePainter(model = it.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = it.text,
            modifier = Modifier.padding(12.dp),
            style = TextStyle(color = Color.Gray, fontSize = 20.sp)
        )
        Divider()
    }
}

@Composable
fun CircularImage(width: Double, height: Double, radius: Double, imageUrl: String) {
    Card(
        modifier = Modifier
            .width(width = width.dp)
            .height(height = height.dp),
        shape = RoundedCornerShape(radius.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = imageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}
