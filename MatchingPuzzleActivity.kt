package com.exercise.yachtdiceproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.exercise.yachtdiceproject.GamePack.MatchingPuzzle.NavGraphMatchingFor


class MatchingPuzzleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MatchingViewNav()
        }
    }
}

@Composable
fun MatchingViewNav(){
    val navController = rememberNavController()
    NavGraphMatchingFor(navController = navController)
}