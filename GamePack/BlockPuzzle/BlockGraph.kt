package com.exercise.yachtdiceproject.GamePack.BlockPuzzle

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun NavGraphBlockFor (navController: NavHostController, vm : BlockViewModel){
    NavHost(
        navController = navController,
        startDestination = BlockForNavRoute.BlockMenu.route)
    {
        composable(route = BlockForNavRoute.BlockMenu.route){
            BlockMenuScreen(navController, vm = vm)
        }

        composable(route = BlockForNavRoute.BlockGame.route){
            BlockGameScreen(nc = navController, vm = vm)
        }

        composable(route = BlockForNavRoute.BlockResult.route){
            BlockResultScreen(navController, vm = vm)
        }
    }
}