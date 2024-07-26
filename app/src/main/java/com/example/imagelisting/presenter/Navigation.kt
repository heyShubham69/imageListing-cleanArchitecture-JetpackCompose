package com.example.imagelisting.presenter

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.imagelisting.presenter.screens.ItemDetailScreen
import com.example.imagelisting.presenter.screens.ItemListScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            ItemListScreen(navController)
        }
        composable("details/{imdbId}") { backStackEntry ->
            val imdbId = backStackEntry.arguments?.getString("imdbId")
            if (imdbId != null) {
                ItemDetailScreen(imdbId)
            }
        }
    }
}