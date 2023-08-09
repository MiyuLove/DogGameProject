package com.exercise.yachtdiceproject.MainNav

sealed class MenuForNavRoute(val route : String){
    object MenuMain : MenuForNavRoute("menu_screen")
    object MenuGame : MenuForNavRoute("menu_game")
    object MenuHelp : MenuForNavRoute("menu_help")
    object MenuReward : MenuForNavRoute("menu_reward")
    object MenuSetting : MenuForNavRoute("menu_setting")
    object MenuStory : MenuForNavRoute("menu_story")
}