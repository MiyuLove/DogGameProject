package com.exercise.yachtdiceproject.MainNav

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.exercise.yachtdiceproject.R


@Composable
fun MenuStoryScreen(nc : NavHostController){
    Column(Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.sample_dog_3), contentDescription = "")
    }
}