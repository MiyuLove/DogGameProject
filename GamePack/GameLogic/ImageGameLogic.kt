package com.exercise.yachtdiceproject.GamePack.GameLogic

import kotlinx.coroutines.runBlocking
import kotlin.random.Random

class ImageGameLogic (col : Int, row : Int) : GameBoard(col, row) {
    var finishNumber = 0

    init {
        runBlocking {
            initiateData()
            initiateGame()
        }
    }

    override fun setData(x: Int, y: Int) : Array<IntArray> {
        dat[x][y] = setValue(dat[x][y])
        if(searchData(x-1,y))dat[x-1][y] = setValue(dat[x-1][y])
        if(searchData(x+1,y))dat[x+1][y] = setValue(dat[x+1][y])
        if(searchData(x,y+1))dat[x][y+1] = setValue(dat[x][y+1])
        if(searchData(x,y-1))dat[x][y-1] = setValue(dat[x][y-1])

        checkData()
        //이 finishGame을 imageGame에서 호출하도록 합시당
        return dat
    }

    private fun setValue(dat : Int):Int{
        return if(dat == 0) 1 else 0
    }

    private fun initiateData(){
        for(i in 0 until dat.size){
            for(j in 0 until dat[i].size){
                dat[i][j] = 0
            }
        }
    }
     private fun initiateGame(){
        for(i in 0 until dat.size)
            setData(Random.nextInt(0, dat.size),Random.nextInt(0, dat[0].size))
        if(finishGame())initiateGame()
     }

     override fun finishGame():Boolean {
         val q = dat[0][0]
         for (i in dat) {
             for (j in i) {
                 if (q != j) return false
             }
         }
         finishNumber = q
         return true
     }
}