package com.exercise.yachtdiceproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.exercise.yachtdiceproject.GlobalApplication.Companion.gameUtil
import com.exercise.yachtdiceproject.GlobalApplication.Companion.phoneDevice
import com.exercise.yachtdiceproject.MainNav.NavGraphMenuFor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        phoneDevice = gameUtil.deviceDisplay(this).second

        setContent {
            MenuViewNav()
        }
    }
}

@Composable
fun MenuViewNav(){
    val navController = rememberNavController()
    NavGraphMenuFor(navController = navController)
}