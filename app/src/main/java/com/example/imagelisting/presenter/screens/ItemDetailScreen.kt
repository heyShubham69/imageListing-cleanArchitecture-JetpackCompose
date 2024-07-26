package com.example.imagelisting.presenter.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.imagelisting.presenter.MainViewModel


@Composable
fun ItemDetailScreen(imbdId: String, viewModel: MainViewModel = hiltViewModel()) {
    LaunchedEffect(imbdId) {
        viewModel.fetchMovieDetails(imbdId)
    }
    val item by viewModel.selectedItem.observeAsState()

    item?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(it.Poster),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
            Text(text = "Title : ${it.Title}", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Text(text = "Year : ${it.Year}")
            Text(text = "Type : ${it.Type}")
        }
    } ?: run {
        // Show a loading indicator or a message indicating that the data is being fetched
        Text("Loading...")
    }
}