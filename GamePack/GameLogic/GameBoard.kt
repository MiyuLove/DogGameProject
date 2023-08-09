package com.exercise.yachtdiceproject.GamePack.GameLogic

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import kotlin.random.Random

abstract class GameBoard (col : Int, row : Int){
    protected var dat = Array(col){IntArray(row)}
    protected var restoreDat = ArrayList<Array<IntArray>>()


    abstract fun setData(x : Int, y : Int) :  Array<IntArray>
    abstract fun finishGame() : Boolean

    fun getData(): Array<IntArray>{
        return dat
    }

    protected fun searchData(x : Int, y : Int) : Boolean{
        if(x >= dat.size || y >= dat[0].size) return false
        if(x < 0 || y < 0)return false

        return true
    }

    protected fun searchData(x : Int, y : Int, xyValue : Int) : Boolean{
        if(x >= dat.size || y >= dat[0].size) return false
        if(x < 0 || y < 0)return false
        if(dat[x][y] != 0) return false

        return true
    }

    protected fun checkData(){
        for(i in 0 until dat.size){
            print("dd123 : ")
            for(j in 0 until dat[i].size){
                print(dat[i][j].toString() + " ")
            }
            println()
        }
    }

    private var resetNum = 0
    private var resetT = false

    private fun restoreBoard(){
        if(resetT) {
            restoreDat = ArrayList<Array<IntArray>>()
            resetNum = 0
        }
        //restoreDat.add(copyDat())
        resetNum ++

        resetT = false
        if(resetNum > 30){
            resetNum --
            restoreDat.removeAt(0)
        }
    }

    fun resetBtn(){
        if(resetNum - 1 < 0) return
        resetT = true
        --resetNum
        dat = restoreDat[resetNum]
        //coverColor()
    }
}