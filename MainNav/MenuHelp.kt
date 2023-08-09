package com.exercise.yachtdiceproject.MainNav

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.exercise.yachtdiceproject.ComposeBox.MainText

@Composable
fun MenuHelpScreen(nc: NavHostController){
    Column(Modifier.fillMaxSize()) {
        MainText(text = "?", color = Color.Blue)
    }
}