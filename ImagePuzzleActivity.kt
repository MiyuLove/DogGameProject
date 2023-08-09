package com.exercise.yachtdiceproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.exercise.yachtdiceproject.GamePack.ImagePuzzle.NavGraphImageFor

class ImagePuzzleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlobalApplication.gameUtil.logChat("start")
            ImageGameMenuViewNav()
            GlobalApplication.gameUtil.logChat("finish")
        }
    }
}
@Composable
fun ImageGameMenuViewNav(){
    val navController = rememberNavController()
    NavGraphImageFor(navController = navController)
}