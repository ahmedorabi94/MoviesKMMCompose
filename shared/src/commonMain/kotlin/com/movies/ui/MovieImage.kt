package com.movies.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberAsyncImagePainter


@Composable
fun MovieImage(url: String, desc: String) {

    val imageUrl  = "http://image.tmdb.org/t/p/w500$url"

    val painter = rememberAsyncImagePainter(imageUrl)

//    val painter = rememberCoilPainter(request = imageUrl)
//

    Box() {
        Image(
            painter = painter, contentDescription = desc,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }

//    when(painter.loadState){
//        is ImageLoadState.Error -> {
//            Box(modifier = Modifier.fillMaxWidth().height(200.dp)) {
//
//            }
//        }
//        is ImageLoadState.Loading -> {
//            Box(modifier = Modifier.fillMaxWidth().height(200.dp)) {
//
//            }
//
//        }
//        is ImageLoadState.Success -> {
//
//        }
//    }

}