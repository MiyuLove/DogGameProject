package com.exercise.yachtdiceproject.MainNav

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.exercise.yachtdiceproject.ComposeBox.BgMainText
import com.exercise.yachtdiceproject.ComposeBox.MenuMainForButton
import com.exercise.yachtdiceproject.ComposeBox.TitleRow
import com.exercise.yachtdiceproject.GlobalApplication.Companion.colors
import com.exercise.yachtdiceproject.R
import kotlinx.coroutines.runBlocking

@Composable
fun MenuMainScreen(nc : NavHostController){
    Column(
        Modifier
            .fillMaxSize()
            .background(color = colors.bgColorSkyBlue)
            .padding(20.dp)
        //여기에 풀숲 추가욤
    ) {
        MenuMainTopColumn(modifier = Modifier.weight(0.2f),nc)

        MenuMainMidColumn(modifier = Modifier.weight(0.7f),nc)

        MenuMainBottomColumn (modifier = Modifier.weight(0.1f))
    }
}

@Composable
fun MenuMainTopColumn(modifier: Modifier, nc : NavHostController){
    var buttonEnabled by remember{ mutableStateOf(true)}
    var menuButtonClickable = {route : String ->
        if (buttonEnabled) {
            runBlocking {
                nc.navigate(route)
                buttonEnabled = false
            }
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .then(Modifier.fillMaxWidth())
            .padding(start = 60.dp, end = 30.dp)
    //여기에 WoodBoard 추가욤
    ) {
        TitleRow(Modifier, "강아지 놀이터")
        Row(
            Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ){
            Image(painter = painterResource(id = R.drawable.baseline_question_mark_48),
                contentDescription = "setting",
                Modifier
                    .clickable { menuButtonClickable(MenuForNavRoute.MenuHelp.route) }
                    .background(colors.btnLineColorBlue, shape = CircleShape))
        }
    }
}

@Composable
fun MenuMainMidColumn(modifier: Modifier, nc : NavHostController){
    var buttonEnabled by remember{ mutableStateOf(true)}
    var menuButtonClickable = {route : String ->
        if (buttonEnabled) {
            runBlocking {
                nc.navigate(route)
                buttonEnabled = false
            }
        }
    }

    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MenuMainForButton(modifier = Modifier
                .padding(20.dp)
                .clickable(enabled = buttonEnabled) {
                    menuButtonClickable(MenuForNavRoute.MenuGame.route)
                },
                R.drawable.sample_dog_1,
                "게 임"
            )
            MenuMainForButton(modifier = Modifier
                .padding(20.dp)
                .clickable(enabled = buttonEnabled) {
                    menuButtonClickable(MenuForNavRoute.MenuStory.route)
                }, R.drawable.sample_dog_3,
                "이야기"
            )

            MenuMainForButton(modifier = Modifier
                .padding(20.dp)
                .clickable(enabled = buttonEnabled) {
                    menuButtonClickable(MenuForNavRoute.MenuSetting.route)
                }, R.drawable.sample_dog_1,
                "설 정"
            )
            MenuMainForButton(modifier = Modifier
                .padding(20.dp)
                .clickable(enabled = buttonEnabled) {
                    menuButtonClickable(MenuForNavRoute.MenuReward.route)
                }, R.drawable.sample_dog_4
                ,"보 상"
            )
        }
    }
}

@Composable
fun MenuMainBottomColumn(modifier: Modifier){
    Column(modifier = modifier) {}
}

@Preview(device = Devices.AUTOMOTIVE_1024p, widthDp = 720, heightDp = 360)
@Composable
fun previewMain(){
    MenuMainScreen(nc = NavHostController(LocalContext.current))
}