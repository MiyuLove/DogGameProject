package com.exercise.yachtdiceproject.GamePack.SlidePuzzle

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.exercise.yachtdiceproject.ComposeBox.MenuMainForButton
import com.exercise.yachtdiceproject.ComposeBox.MidLazyRow
import com.exercise.yachtdiceproject.ComposeBox.TitleRow
import com.exercise.yachtdiceproject.GamePack.ImagePuzzle.ImageForNavRoute
import com.exercise.yachtdiceproject.GamePack.ImagePuzzle.ImagePuzzleData
import com.exercise.yachtdiceproject.GlobalApplication.Companion.colors
import com.exercise.yachtdiceproject.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@Composable
fun SlideMenuScreen(nc : NavHostController){
    val buttonImageID = listOf(
        R.drawable.sample_dog_1,
        R.drawable.sample_dog_2,
        R.drawable.sample_dog_3,
        R.drawable.sample_dog_4,
    )

    val clickedGroup = listOf(
        { nc.navigate(SlideForNavRoute.SlideGame.route+"/0") },
        { nc.navigate(SlideForNavRoute.SlideGame.route+"/1") },
        { nc.navigate(SlideForNavRoute.SlideGame.route+"/2") },
        { nc.navigate(SlideForNavRoute.SlideGame.route+"/3") },
    )

    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(0.2f)) {
            TitleRow(Modifier, "밀어! 퍼즐")
        }
        MidLazyRow( modifier = Modifier.weight(0.7f), buttonImageIDGroup = buttonImageID, SlidePuzzleData().puzzleStage,clickedGroup)

        Row(Modifier.weight(0.1f)){

        }
    }
}