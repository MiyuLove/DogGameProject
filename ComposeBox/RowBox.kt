package com.exercise.yachtdiceproject.ComposeBox

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.exercise.yachtdiceproject.GlobalApplication
import com.exercise.yachtdiceproject.R


@Composable
fun TitleRow(modifier: Modifier = Modifier, text : String = "강아지 놀이터"){
    Row(modifier = modifier.then(Modifier.padding(start = 60.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,) {
        Image(
            painter = painterResource(id = R.drawable.sample_dog_2),
            contentDescription = "menuMainTopImage"
        )
        BgMainText(text = text, modifier = Modifier, textColor = GlobalApplication.colors.txtColor)
    }
}

