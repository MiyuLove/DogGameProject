package com.exercise.yachtdiceproject.GamePack.ImagePuzzle

data class ImagePuzzleData (
    val puzzleStage: List<String> = listOf("2x2","2x3","3x3","4x4"),
    val columnInfo : List<Int> = listOf(2,2,3,4),
    val rowInfo : List<Int> = listOf(2,3,3,4)
)

//1. 스테이지를 추가하려면 여기에 추가할 블록 수와 그 수를 차례대로 밑에 추가한다.
//2. 메뉴에 버튼 ID에 사진 하나를 추가한다.
//3. 메뉴에 버튼 Text에 문자열을 하나 추가한다. 추가 안하면 "시작"이라는 버튼이 붙으니 null 에러는 신경쓰지 말라.