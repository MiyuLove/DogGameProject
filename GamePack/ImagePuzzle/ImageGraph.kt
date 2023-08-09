package com.exercise.yachtdiceproject.GamePack.ImagePuzzle

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.exercise.yachtdiceproject.GamePack.SlidePuzzle.SlideForNavRoute
import com.exercise.yachtdiceproject.GamePack.SlidePuzzle.SlideGameScreen
import com.exercise.yachtdiceproject.GamePack.SlidePuzzle.SlideMenuScreen
import com.exercise.yachtdiceproject.GamePack.SlidePuzzle.SlideResultScreen


@Composable
fun NavGraphImageFor (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = ImageForNavRoute.ImageMenu.route)
    {
        composable(route = ImageForNavRoute.ImageMenu.route){
            ImageMenuScreen(navController)
        }
        composable(
            route = ImageForNavRoute.ImageGame.route + "/{stageInfo}",
            arguments = listOf(navArgument("stageInfo"){type = NavType.IntType}))
        { backStackEntry ->

            var stageInfo = backStackEntry.arguments?.getInt("stageInfo",0)
            if(stageInfo == null )stageInfo = 22
            ImageGameScreen(navController,stageInfo)
        }

        composable(route = ImageForNavRoute.ImageResult.route){
            ImageResultScreen(navController)
        }
    }
}