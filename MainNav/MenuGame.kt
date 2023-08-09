package com.exercise.yachtdiceproject.MainNav

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.exercise.yachtdiceproject.BlockPuzzleActivity
import com.exercise.yachtdiceproject.ComposeBox.MenuMainForButton
import com.exercise.yachtdiceproject.ComposeBox.MidLazyRow
import com.exercise.yachtdiceproject.ComposeBox.TitleRow
import com.exercise.yachtdiceproject.GlobalApplication.Companion.gameUtil
import com.exercise.yachtdiceproject.ImagePuzzleActivity
import com.exercise.yachtdiceproject.MatchingPuzzleActivity
import com.exercise.yachtdiceproject.ProjectUtil.GameData.Companion.gameNameGroup
import com.exercise.yachtdiceproject.R
import com.exercise.yachtdiceproject.SlidePuzzleActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@Composable
fun MenuGameScreen(nc : NavHostController){
    val context = LocalContext.current
    val activity = context as Activity

    val buttonImageID = listOf(
        R.drawable.sample_dog_1,
        R.drawable.sample_dog_2,
        R.drawable.sample_dog_3,
    )

    val intentGroup = listOf(
        Intent(activity, SlidePuzzleActivity::class.java),
        Intent(activity, ImagePuzzleActivity::class.java),
        Intent(activity, BlockPuzzleActivity::class.java),
    )

    val clickedGroup = listOf(
        { activity.startActivity(intentGroup[0]) },
        { activity.startActivity(intentGroup[1]) },
        { activity.startActivity(intentGroup[2]) },
    )

    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(0.2f)) {
            TitleRow(Modifier, "게임을 선택해!")
        }
        MidLazyRow( modifier = Modifier.weight(0.7f), buttonImageIDGroup = buttonImageID,
            buttonTextGroup = gameNameGroup, clickedGroup)

        Row(Modifier.weight(0.1f)){

        }
    }
}