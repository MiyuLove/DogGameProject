package com.exercise.yachtdiceproject.ProjectUtil

import android.graphics.Bitmap

class ImageUtil() {
    fun divideImage(bitmap :Bitmap, col : Int = 2, row : Int = 2) : MutableList<Bitmap>{
        val imageParts = mutableListOf<Bitmap>()
        val partHeight = bitmap.height / col
        val partWidth = bitmap.width / row

        if(isTrueSize(partWidth, partHeight))
            return mutableListOf(bitmap)

        var colCursor = 0

        for(i in 0 until col) {
            var rowCursor = 0
            for (j in 0 until row) {
                imageParts.add(
                    Bitmap.createBitmap(
                        bitmap, rowCursor, colCursor, partWidth, partHeight
                    )
                )
                rowCursor += partWidth
            }
            colCursor += partHeight
        }

        return imageParts
    }
    private fun isTrueSize(width : Int, height : Int) = if(width <= 0|| height <= 0)true else false

}