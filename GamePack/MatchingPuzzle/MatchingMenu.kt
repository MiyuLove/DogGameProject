package com.exercise.yachtdiceproject.GamePack.MatchingPuzzle

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.exercise.yachtdiceproject.ComposeBox.MidLazyRow
import com.exercise.yachtdiceproject.ComposeBox.TitleRow
import com.exercise.yachtdiceproject.GamePack.ImagePuzzle.ImageForNavRoute
import com.exercise.yachtdiceproject.GamePack.ImagePuzzle.ImagePuzzleData
import com.exercise.yachtdiceproject.R

@Composable
fun MatchingMenuScreen(nc : NavHostController){
    val buttonImageID = listOf(
        R.drawable.sample_dog_1,
        R.drawable.sample_dog_2,
        R.drawable.sample_dog_3,
        R.drawable.sample_dog_4,
    )

    val clickedGroup = listOf(
        { nc.navigate(MatchingForNavRoute.MatchingGame.route + "/0") },
     //   { nc.navigate(ImageForNavRoute.ImageGame.route + "/1") },
       // { nc.navigate(ImageForNavRoute.ImageGame.route + "/2") },
       // { nc.navigate(ImageForNavRoute.ImageGame.route + "/3") },
    )

    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(0.2f)) {
            TitleRow(Modifier, "맞춰! 퍼즐")
        }
        MidLazyRow( modifier = Modifier.weight(0.7f), buttonImageIDGroup = buttonImageID, MatchingPuzzleData().puzzleStage,clickedGroup)

        Row(Modifier.weight(0.1f)){

        }
    }
}