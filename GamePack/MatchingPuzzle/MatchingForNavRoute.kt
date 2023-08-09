package com.exercise.yachtdiceproject.GamePack.MatchingPuzzle

sealed class MatchingForNavRoute(val route : String){
    object MatchingMenu : MatchingForNavRoute("matching_menu")
    object MatchingGame : MatchingForNavRoute("matching_game")
    object MatchingResult : MatchingForNavRoute("matching_result")
}
