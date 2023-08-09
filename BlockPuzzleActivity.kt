package com.exercise.yachtdiceproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.exercise.yachtdiceproject.GamePack.BlockPuzzle.BlockGameBoard
import com.exercise.yachtdiceproject.GamePack.BlockPuzzle.BlockGameScreen
import com.exercise.yachtdiceproject.GamePack.BlockPuzzle.BlockViewModel
import com.exercise.yachtdiceproject.GamePack.BlockPuzzle.NavGraphBlockFor

class BlockPuzzleActivity : ComponentActivity() {

    private val viewModel = BlockViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavGraphBlockFor(navController = navController, vm = viewModel)
        }
    }
}