package com.binary.jetmovie.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.binary.jetmovie.navigation.MoviesScreens
import com.binary.jetmovie.widget.MovieRow


@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
    ) {
        LazyColumn(

        ) {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    // Log.d("Tag", "MainContent: $movie")
                    navController.navigate(route = MoviesScreens.DetailScreen.name + "/$movie")
                }
            }
        }
    }
}