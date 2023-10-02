package com.binary.jetmovie.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MainContent(
    movieList: List<String> = listOf(
        "Avatar",
        "Hexa",
        "life",
        "Harry",
        "Avatar",
        "Hexa",
        "life",
        "Avatar",
        "Hexa",
        "life",
        "Avatar",
        "Hexa",
        "life",
        "Avatar",
        "Hexa",
        "life",
        "Avatar",
        "Hexa",
        "life",


    )
) {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
    ) {
        LazyColumn(

        ) {
            items(items = movieList) {
                MovieRow(movie = it){
                    movie ->
                    Log.d("Tag", "MainContent: $movie")
                }
            }
        }
    }
}