package com.exercise.yachtdiceproject.GamePack.ImagePuzzle

sealed class ImageForNavRoute(val route : String) {
    object ImageMenu : ImageForNavRoute("image_menu")
    object ImageGame : ImageForNavRoute("image_game")
    object ImageResult : ImageForNavRoute("image_result")
}