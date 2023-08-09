package com.exercise.yachtdiceproject.ComposeBox

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@Composable
fun MidLazyRow(
    modifier: Modifier, buttonImageIDGroup: List<Int>,
    buttonTextGroup : List<String>,
    buttonClickedGroup: List<() -> Unit>
){
    var buttonEnabled by remember{ mutableStateOf(true) }

    var menuButtonClickable = {buttonClicked : () -> Unit ->
        if (buttonEnabled) {
            runBlocking {
                buttonClicked()
                buttonEnabled = false
            }
            GlobalScope.launch {
                delay(1000)
                buttonEnabled = true
            }
        }
    }
    LazyRow(
        modifier = modifier
    ){
        itemsIndexed(buttonImageIDGroup){index, item ->
            GameMenuForButton(modifier = Modifier
                .clickable {
                    menuButtonClickable(buttonClickedGroup[index])
                }
                .padding(20.dp),
                resourceId = item,
                text = buttonTextGroup[index]
            )
        }
    }
}