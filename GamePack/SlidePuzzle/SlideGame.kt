package com.exercise.yachtdiceproject.GamePack.SlidePuzzle

import android.graphics.BitmapFactory
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.exercise.yachtdiceproject.ComposeBox.SquareGameBoardForBitmap
import com.exercise.yachtdiceproject.GamePack.GameLogic.GameState
import com.exercise.yachtdiceproject.GamePack.GameLogic.SlideGameLogic
import com.exercise.yachtdiceproject.GlobalApplication
import com.exercise.yachtdiceproject.ProjectUtil.ImageUtil
import com.exercise.yachtdiceproject.R

lateinit var slideGameLogic : SlideGameLogic
lateinit var slideGameState : GameState

private fun initSlideGame(stageInfo: Int){
    slideGameLogic =
        SlideGameLogic(SlidePuzzleData().columnInfo[stageInfo],
            SlidePuzzleData().rowInfo[stageInfo])

    slideGameState =
        GameState(SlidePuzzleData().columnInfo[stageInfo],
            SlidePuzzleData().rowInfo[stageInfo])

    slideGameState.coverColor(slideGameLogic.getData())
}

@Composable
fun SlideGameScreen(nc: NavHostController, stageInfo: Int){
    initSlideGame(stageInfo)
    val context = LocalContext.current

    val testSlideGroup =
        ImageUtil().divideImage(BitmapFactory.decodeResource(
            context.resources,R.drawable.sample_dog_2),SlidePuzzleData().columnInfo[stageInfo],
            SlidePuzzleData().rowInfo[stageInfo])

    testSlideGroup.add(0,BitmapFactory.decodeResource(context.resources,R.drawable.one_star))

    val clickedLambda = {i : Int, j : Int ->
        slideGameState.coverColor(slideGameLogic.setData(i, j))
        if(slideGameLogic.finishGame()){
            nc.popBackStack()
            nc.navigate(SlideForNavRoute.SlideResult.route)
        }
    }

    Row(
        Modifier
            .fillMaxSize()
            .background(GlobalApplication.colors.bgColorSkyBlue)) {
        Column(modifier = Modifier.weight(0.2f)) {
            Text(text = stageInfo.toString())
            Text(text = SlidePuzzleData().columnInfo[stageInfo].toString())
            Text(text = SlidePuzzleData().rowInfo[stageInfo].toString())
        }

        Row(modifier = Modifier
            .weight(0.6f)
            .fillMaxHeight()
            .border(3.dp, Color.Black),
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){

            SquareGameBoardForBitmap(
                col = SlidePuzzleData().columnInfo[stageInfo],
                row = SlidePuzzleData().rowInfo[stageInfo],
                clickedLambda = clickedLambda,
                imageStates = slideGameState.imageStateGroup,
                imageGroup = testSlideGroup
            )
        }

        Column(modifier = Modifier.weight(0.2f)) {

        }
    }
}