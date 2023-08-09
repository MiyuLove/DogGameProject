package com.exercise.yachtdiceproject.GamePack.GameLogic

import com.exercise.yachtdiceproject.GlobalApplication.Companion.gameUtil
import kotlin.random.Random

class SlideGameLogic(col : Int, row : Int) : GameBoard(col, row) {
    val col = col
    val row = row
    init {
        initData()
    }
    private fun initData(){
        val sourceData = randomList(col * row)
        var sourceIndex = 0

        for(i in 0 until dat.size){
            for(j in 0 until dat[i].size){
                dat[i][j] = sourceData[sourceIndex]
                sourceIndex ++
            }
        }
    }

    override fun setData(x: Int, y: Int) : Array<IntArray> {
        val noneInt = 0
        val setValue = {_x : Int, _y : Int, x : Int, y : Int ->
            dat[_x][_y] = dat[x][y]
            dat[x][y] = 0
        }

        if(searchData(x-1,y,noneInt))
            setValue(x-1,y,x,y)
        else if(searchData(x+1,y,noneInt))
            setValue(x+1,y,x,y)
        else if(searchData(x,y+1,noneInt))
            setValue(x,y+1,x,y)
        else if(searchData(x,y-1,noneInt))
            setValue(x,y-1,x,y)

        checkData()
        return dat
    }

    override fun finishGame(): Boolean{
        var answer = arrayOf(1,2,3,4,5,6,7,8,0)
        var answerIdx = 0
        for(i in dat){
            for(j in i){
                if(j != answer[answerIdx++])
                    return false
            }
        }

        return true
    }

    private fun randomList (_length : Int) : ArrayList<Int>{
        val length = _length-1
        val randomArrayList = arrayListOf<Int>()
        val randomList = Array(length){i -> 0}

        while(randomArrayList.size < length){
            val randInt = Random.nextInt(0,length)

            if(randomList[randInt] != 3){
                randomList[randInt] = 3
                randomArrayList.add(randInt+1)
            }
        }

        randomArrayList.add(0)
        return randomArrayList
    }
}