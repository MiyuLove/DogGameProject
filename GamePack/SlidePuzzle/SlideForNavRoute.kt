package com.exercise.yachtdiceproject.GamePack.SlidePuzzle

import com.exercise.yachtdiceproject.MainNav.MenuForNavRoute

sealed class SlideForNavRoute(val route : String){
    object SlideMenu : SlideForNavRoute("slide_menu")
    object SlideGame : SlideForNavRoute("slide_game")
    object SlideResult : SlideForNavRoute("slide_result")
}
