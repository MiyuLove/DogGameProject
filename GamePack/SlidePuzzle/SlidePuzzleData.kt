package com.exercise.yachtdiceproject.GamePack.SlidePuzzle

data class SlidePuzzleData (
    val puzzleStage: List<String> = listOf("3x3","4x4","5x5","6x6"),
    val columnInfo : List<Int> = listOf(3,4,5,6),
    val rowInfo : List<Int> = listOf(3,4,5,6)
)