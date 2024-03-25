package com.example.ubereatsclone.Screens.MainScreen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ubereatsclone.R

@Composable
fun TopBar(menuState: MutableIntState){
    val topMenus = listOf("Delivery","Pick-up","Dine-in")
    //get topbar height
    val topBarHeight = MaterialTheme.typography.bodyMedium.fontSize.value.dp + 24.dp
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = topBarHeight),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        topMenus.forEachIndexed { index,item->
            val selected:Boolean = menuState.intValue == index
            Card (
                modifier = Modifier.clickable {  menuState.intValue = index }
                    .clip(CircleShape),
            ){
                Text(text = item,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.nunito_sans)),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        color = if (selected) Color.White else Color.Black
                    ),
                    modifier = Modifier
                        .background(
                            color = if (selected) Color.Black else Color.White,
                        )
                        .padding(horizontal = 14.dp, vertical = 4.dp).clip(CircleShape)

                )
            }

        }
    }


}

@Preview(showBackground = true, showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE
)
@Composable
fun TopBarPreview(){
    val menuState = remember { mutableIntStateOf(0) }
    TopBar(menuState)
}