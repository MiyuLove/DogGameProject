package com.exercise.yachtdiceproject.GamePack.BlockPuzzle

sealed class BlockForNavRoute (val route : String) {
    object BlockMenu : BlockForNavRoute("block_menu")
    object BlockGame : BlockForNavRoute("block_game")
    object BlockResult : BlockForNavRoute("block_result")
}