package com.myapplication

import MainView
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.movies.datasource.network.KtorClientFactory
import com.movies.datasource.network.MovieServiceImp
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


      //  val client = KtorClientFactory().build()

//        val service = MovieServiceImp()
//
//        lifecycleScope.launch {
//            try {
//                val result = service.getNowPlayingMoviesAsync(1)
//                Log.e("results", result.toString())
//            }catch (e : Exception){
//                Log.e("test " , e.toString())
//            }
//
//
//        }


        setContent {




            MainView()
        }
    }
}