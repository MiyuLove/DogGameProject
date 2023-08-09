package com.exercise.yachtdiceproject.ProjectUtil

import android.app.Activity
import android.content.Context
import android.graphics.Point

class GameUtil {
    fun logChat(text : String){
        println("dd123 : " + text)
    }

    fun logChat(num : Int){
        logChat(num.toString())
    }
    fun logChat(float : Float){
        logChat(Float.toString())
    }
    fun logChat(bool : Boolean){
        println(bool.toString())
    }

    fun deviceDisplay(activity: Activity) : Pair<Int,Int>{
        val display = activity!!.windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val rtn = Pair(size.x,size.y)
        return rtn
    }

    fun pxToDp(context : Context, px : Int):Int{
        val density = context.resources.displayMetrics.density
        return (px.toFloat()/density).toInt()
    }

    fun getDeviceDisplayLength(activity: Activity, context: Context): Int{
        return pxToDp(context, deviceDisplay(activity).second)
    }
}