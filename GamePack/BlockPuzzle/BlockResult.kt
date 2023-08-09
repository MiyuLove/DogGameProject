package com.exercise.yachtdiceproject.GamePack.BlockPuzzle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.exercise.yachtdiceproject.ComposeBox.MainText
import com.exercise.yachtdiceproject.GlobalApplication.Companion.colors

@Composable
fun BlockResultScreen(nc : NavHostController,vm: BlockViewModel){
    Column(Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        MainText(text = vm.gameScore.toString(), color = colors.txtColor)
    }
}