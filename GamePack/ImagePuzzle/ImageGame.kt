package com.exercise.yachtdiceproject.GamePack.ImagePuzzle

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.exercise.yachtdiceproject.ComposeBox.SquareGameBoard
import com.exercise.yachtdiceproject.GamePack.GameLogic.GameState
import com.exercise.yachtdiceproject.GamePack.GameLogic.ImageGameLogic
import com.exercise.yachtdiceproject.GlobalApplication.Companion.colors
import com.exercise.yachtdiceproject.GlobalApplication.Companion.phoneDevice
import com.exercise.yachtdiceproject.R
import kotlinx.coroutines.runBlocking


lateinit var imageGameLogic : ImageGameLogic
lateinit var imageGameState : GameState
private val testImageGroup = listOf(R.drawable.sample_dog_1, R.drawable.sample_dog_2)

private fun initImageGame(stageInfo: Int){
    imageGameLogic =
        ImageGameLogic(ImagePuzzleData().columnInfo[stageInfo],
            ImagePuzzleData().rowInfo[stageInfo])
    imageGameState =
        GameState(ImagePuzzleData().columnInfo[stageInfo],
            ImagePuzzleData().rowInfo[stageInfo])

    imageGameState.coverColor(imageGameLogic.getData())
}

@Composable
fun ImageGameScreen(nc : NavHostController, stageInfo : Int){
    var initiate by remember{ mutableStateOf(true) }
    if(initiate) {
        initImageGame(stageInfo)
        initiate = false
    }

    val clickedLambda = {i : Int, j : Int ->
        runBlocking {
            imageGameLogic.setData(i, j)
        }
        imageGameState.coverColor(imageGameLogic.getData())
        if(imageGameLogic.finishGame()){
            nc.popBackStack()
            nc.navigate(ImageForNavRoute.ImageResult.route)
        }
    }

    Row(
        Modifier
            .fillMaxSize()
            .background(colors.bgColorSkyBlue)) {
        Column(modifier = Modifier.weight(0.2f)) {
            Text(text = stageInfo.toString())
            Text(text = ImagePuzzleData().columnInfo[stageInfo].toString())
            Text(text = ImagePuzzleData().rowInfo[stageInfo].toString())
        }

        Row(
            modifier = Modifier
                .weight(0.6f)
                .fillMaxHeight()
                .border(3.dp, Color.Black),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            SquareGameBoard(
                col = ImagePuzzleData().columnInfo[stageInfo],
                row = ImagePuzzleData().rowInfo[stageInfo],
                clickedLambda =clickedLambda,
                imageGameState.imageStateGroup,
                testImageGroup
            )
        }
        Column(modifier = Modifier.weight(0.2f)) {

        }
    }
}

