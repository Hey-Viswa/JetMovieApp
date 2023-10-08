package com.binary.jetmovie.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.binary.jetmovie.components.Movie
import com.binary.jetmovie.components.getMovies

@Preview
@Composable
fun MovieRow(
    movie: Movie = getMovies()[0],
    onItemClick: (String) -> Unit = {}
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(all = 4.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .clickable {
                onItemClick(movie.id)
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors((MaterialTheme.colorScheme.onPrimary))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp
            ) {
                Image(
                    painter = rememberImagePainter(data = movie.images[0]),
                    contentDescription = "Movie Poster",
                    contentScale = ContentScale.Crop,
                )
//                Icon(
//                    imageVector = Icons.Default.AccountBox,
//                    contentDescription = "Movie Image"
//                )
            }
            Column(
                modifier = Modifier.padding(4.dp)
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "Director: ${movie.title}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Released: ${movie.year}",
                    style = MaterialTheme.typography.bodySmall
                )
                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text(buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontSize = 13.sp
                                )
                            ) {
                               append("Plot : ")
                            }
                            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onPrimaryContainer,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )){
                                append(movie.plot)
                            }
                        },
                            modifier = Modifier.padding(0.dp))

                        Divider(modifier = Modifier.padding(top = 5.dp,
                            bottom = 5.dp))
                        Text(
                            text = "Director: ${movie.director}",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = "Actors: ${movie.actors}",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = "Rating: ${movie.rating}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else
                        Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Down Arrow",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            expanded = !expanded
                        },
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }


        }
    }
}