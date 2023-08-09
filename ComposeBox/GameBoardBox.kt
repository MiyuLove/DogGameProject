package com.exercise.yachtdiceproject.ComposeBox

import android.app.Activity
import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap.Companion.Square
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.exercise.yachtdiceproject.GlobalApplication
import com.exercise.yachtdiceproject.GlobalApplication.Companion.gameUtil

@Composable
fun SquareGameBoard(
    col : Int = 2,
    row : Int = 2,
    clickedLambda : (Int,Int) ->Unit,
    imageStates : ArrayList<ArrayList<State<Int>>>,
    imageGroup : List<Int>
){
    val context = LocalContext.current
    val activity = context as Activity
    val length = gameUtil.getDeviceDisplayLength(activity,context)* 0.8f
    Column(
        Modifier
            .width(length.dp)
            .height(length.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for(i in 0 until col)
            SquareGameBoardRow(
                colIdx = i,
                row = row,
                modifier = Modifier.weight(0.33f),
                clickedLambda = clickedLambda,
                imageStates = imageStates,
                imageGroup = imageGroup
            )
    }
}

@Composable
fun SquareGameBoardRow(
    colIdx :Int = 0,
    row : Int, modifier : Modifier,
    clickedLambda : (Int,Int) ->Unit,
    imageStates : ArrayList<ArrayList<State<Int>>>,
    imageGroup : List<Int>
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        for(i in 0 until row)
            Box(modifier = Modifier
                .weight(0.33f)
                .border(1.dp, Color.Blue))
            {
                Image(
                    painter = painterResource(id = imageGroup[imageStates[colIdx][i].value]),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable
                        {
                            clickedLambda(colIdx, i)
                        }
                )
            }
    }
}

@Composable
fun SquareGameBoardForBitmap(
    col : Int = 2,
    row : Int = 2,
    clickedLambda : (Int,Int) ->Unit,
    imageStates : ArrayList<ArrayList<State<Int>>>,
    imageGroup : List<Bitmap>
){
    val context = LocalContext.current
    val activity = context as Activity
    val length = gameUtil.getDeviceDisplayLength(activity,context)* 0.8f
    Column(
        Modifier
            .width(length.dp)
            .height(length.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for(i in 0 until col)
            SquareGameBoardRowForBitmap(
                colIdx = i,
                row = row,
                modifier = Modifier.weight(0.33f),
                clickedLambda = clickedLambda,
                imageStates = imageStates,
                imageGroup = imageGroup
            )
    }
}
@Composable
fun SquareGameBoardRowForBitmap(
    colIdx :Int = 0,
    row : Int, modifier : Modifier,
    clickedLambda : (Int,Int) ->Unit,
    imageStates : ArrayList<ArrayList<State<Int>>>,
    imageGroup : List<Bitmap>
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        for(i in 0 until row)
            Box(modifier = Modifier
                .weight(0.33f)
                .border(1.dp, Color.Blue))
            {
                Image(
                    bitmap = imageGroup[imageStates[colIdx][i].value].asImageBitmap(),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable
                        {
                            clickedLambda(colIdx, i)
                        }
                )
            }
    }
}