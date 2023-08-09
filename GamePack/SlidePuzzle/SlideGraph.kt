package com.exercise.yachtdiceproject.GamePack.SlidePuzzle

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.exercise.yachtdiceproject.MainNav.MenuForNavRoute
import com.exercise.yachtdiceproject.MainNav.MenuGameScreen
import com.exercise.yachtdiceproject.MainNav.MenuHelpScreen
import com.exercise.yachtdiceproject.MainNav.MenuMainScreen
import com.exercise.yachtdiceproject.MainNav.MenuRewardScreen
import com.exercise.yachtdiceproject.MainNav.MenuSettingScreen
import com.exercise.yachtdiceproject.MainNav.MenuStoryScreen


@Composable
fun NavGraphSlideFor (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = SlideForNavRoute.SlideMenu.route)
    {
        composable(route = SlideForNavRoute.SlideMenu.route){
            SlideMenuScreen(navController)
        }

        composable(
            route = SlideForNavRoute.SlideGame.route + "/{stageInfo}",
            arguments = listOf(navArgument("stageInfo"){type = NavType.IntType}))
        { backStackEntry ->

            var stageInfo = backStackEntry.arguments?.getInt("stageInfo",0)
            if(stageInfo == null )stageInfo = 22
            SlideGameScreen(navController, stageInfo)
        }

        composable(route = SlideForNavRoute.SlideResult.route){
            SlideResultScreen(navController)
        }
    }
}