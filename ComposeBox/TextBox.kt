package com.exercise.yachtdiceproject.ComposeBox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exercise.yachtdiceproject.GamePack.BlockPuzzle.BlockViewModel
import com.exercise.yachtdiceproject.GlobalApplication.Companion.colors
import com.exercise.yachtdiceproject.R
import kotlinx.coroutines.delay

@Composable
fun MainText(text : String, modifier: Modifier = Modifier, fontSize : Int = 40, color : Color){
    Text(
        text = text,
        textAlign = TextAlign.Start,
        color = color,
        fontSize = fontSize.sp,
        modifier = modifier,
        fontFamily = FontFamily(Font(R.font.base_font))
    )
}

@Composable
fun BgMainText(
    text : String = "Sample",
    modifier: Modifier,
    bgColor : Color = colors.bgColorSkyBlue,
    textColor : Color = colors.bgColorBeige
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.then(Modifier.background(bgColor))
    ) {
        MainText(text = text, color = textColor)
    }
}

@Composable
fun TimerText(
    vm : BlockViewModel
){
    if(vm.isRunning){
        LaunchedEffect(true){
            while(vm.isRunning){
                delay(1000)
                if(--vm.time <= 0) {
                    vm.finishGame()
                }
            }
        }
    }
    BgMainText(modifier = Modifier, text = vm.time.toString())
}

@Preview(showSystemUi = true)
@Composable
fun textPreview(){
    MainText(text = "df", color = colors.bgColorBeige)
    BgMainText(modifier = Modifier
        .width(200.dp)
        .height(100.dp))
}
