package com.example.imagelisting.presenter.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.imagelisting.presenter.MainViewModel


@Composable
fun ItemDetailScreen(imbdId: String,viewModel: MainViewModel = hiltViewModel()) {
    val item = viewModel.items.value?.find { it.imdbID == imbdId }
    item?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(model = item.Poster),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
            Text(text = "Title: ${item.Title}")
            Text(text = "Year: ${item.Year}")
            Text(text = "Type: ${item.Type}")
            Text(text = "Poster: ${item.Poster}")

        }
    }
}