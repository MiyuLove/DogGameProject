package com.exercise.yachtdiceproject.GamePack.MatchingPuzzle

data class MatchingPuzzleData(
    val puzzleStage: List<String> = listOf("3x3","6x6","10x10","15x15"),
    val columnInfo : List<Int> = listOf(3,6,10,15),
    val rowInfo : List<Int> = listOf(3,6,10,15)
)
