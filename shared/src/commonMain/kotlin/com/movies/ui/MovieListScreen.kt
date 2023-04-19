package com.movies.ui



import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.movies.presentation.movie_list.MovieListState


@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun MovieList(
    viewModel: MovieListViewModel,
    state: MovieListState,
    onMovieItemClick: (Int) -> Unit
) {

    LazyColumn {
        itemsIndexed(items = viewModel.state.value.movies) { index, movie ->
//            if ((index + 1) >= (viewModel.state.value.page * 20) && !viewModel.state.value.isLoading) {
//               // onTriggerNextPage(MovieListEvents.NextPage)
//            }
            MovieCard(movie = movie, onClick = {
                onMovieItemClick(movie.id)
            }
            )
        }


    }


}