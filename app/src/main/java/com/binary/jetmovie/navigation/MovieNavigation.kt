package com.binary.jetmovie.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.binary.jetmovie.detail.DetailsScreen
import com.binary.jetmovie.screens.home.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MoviesScreens.HomeScreen.name
    ) {
        composable(MoviesScreens.HomeScreen.name) {
            //here we pass where this should lead us to
            HomeScreen(navController = navController)
        }
        composable(MoviesScreens.DetailScreen.name+"/{movie}",
                arguments = listOf(navArgument(name = "movie"){
                    type = NavType.StringType
                })
            ){backStackEntry ->
            DetailsScreen(navController = navController,
                backStackEntry.arguments?.getString("movie"))
        }
    }
}