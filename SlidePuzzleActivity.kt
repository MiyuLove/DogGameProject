package com.exercise.yachtdiceproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.exercise.yachtdiceproject.GamePack.SlidePuzzle.NavGraphSlideFor

class SlidePuzzleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameMenuViewNav()
        }
    }
}

@Composable
fun GameMenuViewNav(){
    val navController = rememberNavController()
    NavGraphSlideFor(navController = navController)
}