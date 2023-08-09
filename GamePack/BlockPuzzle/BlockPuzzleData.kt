package com.exercise.yachtdiceproject.GamePack.BlockPuzzle

import androidx.compose.ui.graphics.Color

data class BlockPuzzleData (
    val puzzleStage: List<String> = listOf("4","6","8","12"),
    val columnInfo : List<Int> = listOf(2,3,4,6),
    val rowInfo : List<Int> = listOf(2,3,4,6)
)