package com.exercise.yachtdiceproject

import android.app.Application
import com.exercise.yachtdiceproject.ProjectUtil.GameUtil
import com.exercise.yachtdiceproject.ui.theme.ColorYD

class GlobalApplication : Application(){
    companion object{
        val colors = ColorYD()
        val gameUtil = GameUtil()
        var phoneDevice = 0
    }


    override fun onCreate() {
        super.onCreate()
    }
}