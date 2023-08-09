package com.exercise.yachtdiceproject.GamePack.GameLogic

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

class GameState (col : Int, row : Int){
    protected val _imageStateGroup = arrayListOf(arrayListOf<MutableState<Int>>())
    val imageStateGroup = arrayListOf(arrayListOf<State<Int>>())

    init{
        initiateStates(col, row)
    }

    fun coverColor(dat : Array<IntArray>){
        var idx = 0
        for(i in dat){
            var jdx = 0
            for(j in i){
                updateImageState(idx,jdx,j)
                jdx ++
            }
            idx ++
        }
    }

    fun updateImageState(x : Int, y : Int, state : Int){
        _imageStateGroup[x][y].value = state
        imageStateGroup[x][y] = _imageStateGroup[x][y]
    }

    private fun initiateStates(col : Int, row : Int){
        for(i in 0 until col){
            _imageStateGroup.add(arrayListOf())
            imageStateGroup.add(arrayListOf())

            for(j in 0 until row){
                _imageStateGroup[i].add(mutableStateOf(0))
                imageStateGroup[i].add(_imageStateGroup[i][j])
            }
        }
    }
}