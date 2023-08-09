package com.exercise.yachtdiceproject.GamePack.ImagePuzzle

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.exercise.yachtdiceproject.R

@Composable
fun ImageResultScreen(nc : NavHostController){
    Image(painter = painterResource(id = R.drawable.sample_dog_2), contentDescription = "", modifier = Modifier.fillMaxSize())
}