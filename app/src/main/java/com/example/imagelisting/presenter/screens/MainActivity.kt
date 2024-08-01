package com.example.imagelisting.presenter.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.imagelisting.presenter.Navigation
import com.example.imagelisting.ui.theme.ImageListingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            ImageListingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Navigation(navController = rememberNavController())
                }
            }
        }
    }
}