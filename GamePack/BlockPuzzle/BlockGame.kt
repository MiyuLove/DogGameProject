package com.exercise.yachtdiceproject.GamePack.BlockPuzzle

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.exercise.yachtdiceproject.ComposeBox.TimerText
import com.exercise.yachtdiceproject.GamePack.GameLogic.DogUiItem
import com.exercise.yachtdiceproject.GamePack.GameLogic.DragTarget
import com.exercise.yachtdiceproject.GamePack.GameLogic.DraggableScreen
import com.exercise.yachtdiceproject.GamePack.GameLogic.DropItem
import com.exercise.yachtdiceproject.GlobalApplication.Companion.colors
import com.exercise.yachtdiceproject.GlobalApplication.Companion.gameUtil
import com.exercise.yachtdiceproject.R

@Composable
fun BlockGameScreen(
    nc: NavHostController,
    vm: BlockViewModel,
){
    var rr = remember {
        mutableStateOf(true)
    }
    if(!vm.isRunning && rr.value){
        rr.value = false
        nc.popBackStack()
        nc.navigate(BlockForNavRoute.BlockResult.route)
    }
    DraggableScreen (
        modifier = Modifier
            .fillMaxSize()
            .background(colors.bgColorSkyBlue)
    ){
        BlockGameBoard(vm = vm)
    }
}

@Composable
fun BlockGameBoard(
    vm: BlockViewModel
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(0.3f)
        ) {
            TimerText(vm)

            DragItemBlock(modifier = Modifier
                .padding(10.dp),
                blockViewModel = vm,
                locationNumber = 0)
        }

        DropItemQueue(modifier = Modifier
            .weight(0.2f)
            .padding(10.dp),
            blockViewModel = vm
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                    .weight(0.3f)
        ) {
            Text(text ="score = " + vm.gameScore.toString())
            DragItemBlock(modifier = Modifier
                .padding(10.dp),
                blockViewModel = vm,
                locationNumber = 1
            )
        }
    }
}

@Composable
fun DropItemQueue(modifier : Modifier, blockViewModel: BlockViewModel){
    val screenWidth = LocalConfiguration.current.screenWidthDp
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier.weight(0.8f)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ){
                blockViewModel.addedDog.forEach { dog ->
                    Image(
                        painter = painterResource(id = dog.imageId), contentDescription = "",
                        modifier = Modifier.size(Dp(screenWidth/20f))
                    )
                }
            }
        }

        DropItem<DogUiItem>(
            modifier = Modifier
                .weight(0.2f)
        ) { isInBound, dogItem ->
            if(dogItem != null){
                LaunchedEffect(key1 = dogItem){
                    blockViewModel.addDog(dogItem)
                }
            }
            if(isInBound){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .border(
                            1.dp,
                            color = Color.Red,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .background(Color.Gray.copy(0.5f), RoundedCornerShape(15.dp)),
                    contentAlignment = Alignment.Center
                ){

                }
            }else{
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .border(
                            1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .background(
                            Color.Black.copy(0.5f),
                            RoundedCornerShape(15.dp)
                        ),
                    contentAlignment = Alignment.Center
                ){
                    Image(painter = painterResource(id = blockViewModel.answerDogImage), contentDescription = "")
                }
            }
        }
    }
}

@Composable
fun DragItemBlock(modifier : Modifier, blockViewModel: BlockViewModel, locationNumber :Int = 0){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        if(blockViewModel.itemsGroup[locationNumber].size != 3)
        for(i in 0 until blockViewModel.itemsGroup[locationNumber].size step (2)){
            Row() {
                DragTarget(
                    dataToDrop = blockViewModel.itemsGroup[locationNumber][i], viewModel = blockViewModel) {
                    DogBox(screenRatio = blockViewModel.itemsGroup[locationNumber].size, blockViewModel = blockViewModel, locationNumber = locationNumber, index = i)
                }
                DragTarget(
                    dataToDrop = blockViewModel.itemsGroup[locationNumber][i+1], viewModel = blockViewModel) {
                    DogBox(screenRatio = blockViewModel.itemsGroup[locationNumber].size, blockViewModel = blockViewModel, locationNumber = locationNumber, index = i+1)
                }
            }
        }
        else
            for(i in 0 until 1){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    DragTarget(
                        dataToDrop = blockViewModel.itemsGroup[locationNumber][i+3*i],
                        viewModel = blockViewModel
                    ) {
                        DogBox(
                            screenRatio = blockViewModel.itemsGroup[locationNumber].size,
                            blockViewModel = blockViewModel,
                            locationNumber = locationNumber,
                            index = i+3*i
                        )
                    }
                }
                Row() {
                    DragTarget(
                        dataToDrop = blockViewModel.itemsGroup[locationNumber][i+3*i + 1], viewModel = blockViewModel) {
                        DogBox(screenRatio = blockViewModel.itemsGroup[locationNumber].size, blockViewModel = blockViewModel, locationNumber = locationNumber, index = i + 3 * i + 1)
                    }
                    DragTarget(
                        dataToDrop = blockViewModel.itemsGroup[locationNumber][i+3*i + 2], viewModel = blockViewModel) {
                        DogBox(screenRatio = blockViewModel.itemsGroup[locationNumber].size, blockViewModel = blockViewModel, locationNumber = locationNumber, index = i + 3 * i  + 2)
                    }
                }
            }
    }
}

@Composable
fun DogBox(screenRatio : Int, blockViewModel: BlockViewModel, locationNumber: Int, index : Int){
    val screenWidth = LocalConfiguration.current.screenWidthDp
    Box(
        modifier = Modifier
            .size(Dp(screenWidth / (screenRatio * (10f / screenRatio))))
            .clip(RoundedCornerShape(15.dp))
            .shadow(5.dp, RoundedCornerShape(15.dp))
            .background(
                blockViewModel.itemsGroup[locationNumber][index].backGroundColor,
                RoundedCornerShape(15.dp)
            ),
        contentAlignment = Alignment.Center,
    ){
        Image(painter = painterResource(id = blockViewModel.itemsGroup[locationNumber][index].imageId), contentDescription = "")
    }
}