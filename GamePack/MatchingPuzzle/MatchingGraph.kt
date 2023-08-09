package com.exercise.yachtdiceproject.GamePack.MatchingPuzzle

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.exercise.yachtdiceproject.GamePack.ImagePuzzle.ImageForNavRoute
import com.exercise.yachtdiceproject.GamePack.ImagePuzzle.ImageGameScreen
import com.exercise.yachtdiceproject.GamePack.ImagePuzzle.ImageMenuScreen
import com.exercise.yachtdiceproject.GamePack.ImagePuzzle.ImageResultScreen

@Composable
fun NavGraphMatchingFor (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = MatchingForNavRoute.MatchingMenu.route)
    {
        composable(route = MatchingForNavRoute.MatchingMenu.route){
            ImageMenuScreen(navController)
        }
        composable(
            route = MatchingForNavRoute.MatchingGame.route + "/{stageInfo}",
            arguments = listOf(navArgument("stageInfo"){type = NavType.IntType}))
        { backStackEntry ->

            var stageInfo = backStackEntry.arguments?.getInt("stageInfo",0)
            if(stageInfo == null )stageInfo = 22
           // MatchingGameScreen(navController,stageInfo)
        }
    }
}