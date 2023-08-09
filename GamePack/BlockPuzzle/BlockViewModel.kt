package com.exercise.yachtdiceproject.GamePack.BlockPuzzle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.exercise.yachtdiceproject.GamePack.GameLogic.DogUiItem
import com.exercise.yachtdiceproject.GlobalApplication
import com.exercise.yachtdiceproject.GlobalApplication.Companion.colors
import com.exercise.yachtdiceproject.GlobalApplication.Companion.gameUtil
import com.exercise.yachtdiceproject.R
import java.util.LinkedList
import java.util.Queue
import kotlin.random.Random

class BlockViewModel() : ViewModel() {
    var isCurrentlyDragging by mutableStateOf(false)
        private set
    var time by mutableStateOf(10)
    var isRunning by mutableStateOf(true)

    var itemsGroup = mutableListOf<List<DogUiItem>>()
    var addedDog = mutableStateListOf<DogUiItem>()
    var answerMax = 0
    var answerDog = 0
    var answerDogImage by mutableStateOf(0)
        private set

    var gameScore by mutableStateOf(0)
        private set

    val resourceIdGroup = listOf(
        R.drawable.sample_dog_1,
        R.drawable.sample_dog_2,
        R.drawable.sample_dog_3,
        R.drawable.sample_dog_4,
        R.drawable.sample_dog_7,
        R.drawable.sample_dog_8,
        R.drawable.sample_dog_9,
        R.drawable.sample_dog_10,
        R.drawable.sample_dog_11,
        R.drawable.sample_dog_1,
        R.drawable.sample_dog_2,
        R.drawable.sample_dog_3,
    )

    fun setGameLogicAndData(stageInfo : Int){
        answerMax = BlockPuzzleData().puzzleStage[stageInfo].toInt()
        answerDog = Random.nextInt(0, answerMax)
        answerDogImage = resourceIdGroup[answerDog]
        addedDog = mutableStateListOf<DogUiItem>()
        gameScore = 0

        itemsGroup = mutableListOf()
        itemsGroup.add(makeDragBoxData(stageInfo, true))
        itemsGroup.add(makeDragBoxData(stageInfo, false))
    }

    private fun makeDragBoxData(stageInfo: Int, locationDirection : Boolean) : List<DogUiItem>{
        val returnList = mutableListOf<DogUiItem>()
        val len = BlockPuzzleData().columnInfo[stageInfo]
        val startIndex = if(locationDirection) 0 else len

        gameUtil.logChat(startIndex.toString() +" " +len)
        for(i in 0 + startIndex until len + startIndex) {
            returnList.add(DogUiItem(i, resourceIdGroup[i], colors.txtColor))
        }
        return returnList
    }

    fun startDragging(){
        isCurrentlyDragging = true
    }

    fun stopDragging(){
        isCurrentlyDragging = false
    }

    fun addDog(dogUiItem: DogUiItem){
        if(dogUiItem.queueId == answerDog) {
            addedDog.add(dogUiItem)
            gameScore += 100
            if(addedDog.size > 5)
                addedDog.remove(addedDog[0])
        }
        else {
            if(gameScore >= 200)
                gameScore -= 200
        }
        answerDog = Random.nextInt(0, answerMax)
        answerDogImage = resourceIdGroup[answerDog]
    }

    fun finishGame(){
        isRunning = false
    }
}