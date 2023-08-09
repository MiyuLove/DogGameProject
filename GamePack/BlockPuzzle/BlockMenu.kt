package com.exercise.yachtdiceproject.GamePack.BlockPuzzle

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.exercise.yachtdiceproject.ComposeBox.MidLazyRow
import com.exercise.yachtdiceproject.ComposeBox.TitleRow
import com.exercise.yachtdiceproject.ProjectUtil.GameData
import com.exercise.yachtdiceproject.R

@Composable
fun BlockMenuScreen(nc : NavHostController,vm: BlockViewModel){
    val buttonImageID = listOf(
        R.drawable.sample_dog_1,
        R.drawable.sample_dog_2,
        R.drawable.sample_dog_3,
        R.drawable.sample_dog_4,
    )

    val clickedGroup = listOf(
        {
            vm.setGameLogicAndData(0)
            nc.navigate(BlockForNavRoute.BlockGame.route)
        },
        {
            vm.setGameLogicAndData(1)
            nc.navigate(BlockForNavRoute.BlockGame.route)
        },
        {
            vm.setGameLogicAndData(2)
            nc.navigate(BlockForNavRoute.BlockGame.route)
        },
        {
            vm.setGameLogicAndData(3)
            nc.navigate(BlockForNavRoute.BlockGame.route)
        },
    )

    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(0.2f)) {
            TitleRow(Modifier, GameData.gameNameGroup[2])
        }
        MidLazyRow( modifier = Modifier.weight(0.7f),
            buttonImageIDGroup = buttonImageID, BlockPuzzleData().puzzleStage,clickedGroup)

        Row(Modifier.weight(0.1f)){

        }
    }
}