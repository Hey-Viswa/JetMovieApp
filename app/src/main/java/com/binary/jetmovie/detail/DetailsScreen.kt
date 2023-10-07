package com.binary.jetmovie.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    navController: NavController,
    movieData: String?
) {

    Scaffold(
        topBar = {
            Row(horizontalArrangement = Arrangement.Start) {
                TopAppBar(
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    ),
                    title = {
                        Text(
                            "Movie",
                            modifier = Modifier.padding(start = 10.dp)
                        )

                    },
                    navigationIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier.clickable {
                                navController.popBackStack()
                            }

                        )
                    }
                )
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Box {
                Text(
                    text = movieData.toString(),
                    style = MaterialTheme.typography.headlineSmall // Add your desired style here
                )
            }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = movieData.toString(),
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(23.dp))
            Button(onClick = {
                    navController.popBackStack()
            }) {
                Text(text = "Go back")
            }
        }
    }
}