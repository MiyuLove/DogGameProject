package com.exercise.yachtdiceproject.ComposeBox

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exercise.yachtdiceproject.GlobalApplication
import com.exercise.yachtdiceproject.GlobalApplication.Companion.colors
import com.exercise.yachtdiceproject.R

@Composable
fun ImageButton(
    onClick: () -> Unit,
    pResource :Int,
    sex : String,
    modifier: Modifier,
    buttonColor : Color
){
    Button(
        onClick =  onClick,
        shape = RoundedCornerShape(50.dp),
        contentPadding = PaddingValues(15.dp),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
        )
    ){
        Box(
        ){
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center){
                Icon(painterResource(id = pResource),"imageButton", tint = Color.Unspecified)
                Spacer(modifier = Modifier.width(10.dp))
                Text(sex, color = Color.Black, fontStyle = FontStyle(R.font.base_font), fontSize = 25.sp)
            }
        }
    }
}

@Composable
fun MenuMainForButton(modifier: Modifier, resourceId : Int,text : String = "시작"){
    Column(
        modifier = modifier.then(Modifier
            .width(100.dp)
            .fillMaxHeight()
            .background(
                colors.btnColorSkyBlue,
                shape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 40.dp,
                ),
            )
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = resourceId), contentDescription = "",
        modifier = Modifier.fillMaxWidth().weight(0.7f))
        BgMainText(text = text, modifier = Modifier.fillMaxWidth().weight(0.3f))
    }
}

@Composable
fun GameMenuForButton(modifier: Modifier, resourceId : Int,text : String = "시작"){
    Column(
        modifier = modifier.then(Modifier
            .width(300.dp)
            .height(intrinsicSize = IntrinsicSize.Max)
            .background(
                colors.btnColorSkyBlue,
                shape = RoundedCornerShape(40.dp),
            )
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = resourceId), contentDescription = "",
            modifier = Modifier.fillMaxWidth().weight(0.7f))
        BgMainText(text = text, modifier = Modifier.fillMaxWidth().weight(0.3f))
    }
}