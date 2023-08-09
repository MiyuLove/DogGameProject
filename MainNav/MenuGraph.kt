package com.exercise.yachtdiceproject.MainNav

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.exercise.yachtdiceproject.ComposeBox.MainText

@Composable
fun NavGraphMenuFor (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = MenuForNavRoute.MenuMain.route)
    {
        composable(route = MenuForNavRoute.MenuMain.route){
            MenuMainScreen(navController)
        }
        composable(route = MenuForNavRoute.MenuGame.route){
            MenuGameScreen(navController)
        }
        composable(route = MenuForNavRoute.MenuHelp.route){
            MenuHelpScreen(navController)
        }
        composable(route = MenuForNavRoute.MenuReward.route){
            MenuRewardScreen(navController)
        }
        composable(route = MenuForNavRoute.MenuSetting.route){
            MenuSettingScreen(navController)
        }
        composable(route = MenuForNavRoute.MenuStory.route){
            MenuStoryScreen(navController)
        }
    }
}