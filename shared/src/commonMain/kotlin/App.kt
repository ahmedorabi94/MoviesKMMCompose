import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import com.movies.datasource.network.MovieServiceImp
import com.movies.domain.model.Movie
import com.movies.ui.MovieCard
import com.movies.ui.MovieList
import com.movies.ui.MovieListViewModel
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterialApi::class,
    ExperimentalComposeUiApi::class
)
@Composable
fun App() {

    val viewModel = MovieListViewModel()

   // print(viewModel.state.value)


    MaterialTheme {
       // var greetingText by remember { mutableStateOf("Hello, World!") }
       /// var showImage by remember { mutableStateOf(false) }


        MovieList(viewModel,state = viewModel.state.value,{})

       // MovieCard(Movie(title = "Ahmed Orabi"),{})

       // val service = MovieServiceImp()




//        currentRecomposeScope.launch {
//            try {
//                val result = service.getNowPlayingMoviesAsync(1)
//                Log.e("results", result.toString())
//            }catch (e : Exception){
//                Log.e("test " , e.toString())
//            }
//
//
//        }


//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = {
//                greetingText = "Hello, ${getPlatformName()}"
//                showImage = !showImage
//            }) {
//                Text(greetingText)
//            }
//            AnimatedVisibility(showImage) {
//                Image(
//                    painterResource("compose-multiplatform.xml"),
//                    null
//                )
//            }
//        }
    }
}

expect fun getPlatformName(): String

