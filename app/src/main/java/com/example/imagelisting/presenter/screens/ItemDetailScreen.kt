package com.example.imagelisting.presenter.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.imagelisting.presenter.MainViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemDetailScreen(
    imbdId: String,
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    LaunchedEffect(imbdId) {
        viewModel.fetchMovieDetails(imbdId)
    }
    val item by viewModel.selectedItem.observeAsState()
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Item Detail Screen")
            },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },

        ) { padding ->
        item?.let {
            Column(modifier = Modifier.padding(padding)) {
                Image(
                    painter = rememberAsyncImagePainter(it.Poster),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                )
                Box(Modifier.height(5.dp))
                Text(text = "Title : ${it.Title}", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Box(Modifier.height(5.dp))
                Text(text = "Year : ${it.Year}")
                Box(Modifier.height(5.dp))
                Text(text = "Type : ${it.Type}")
            }
        }
    } ?: run {
        // Show a loading indicator or a message indicating that the data is being fetched
        Text("Loading...")
    }
}