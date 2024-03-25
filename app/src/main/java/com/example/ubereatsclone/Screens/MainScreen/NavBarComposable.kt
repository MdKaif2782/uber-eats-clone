package com.example.ubereatsclone.Screens.MainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ubereatsclone.R

@Composable
fun NavBar(navState:MutableIntState){
    NavigationBar {
        getNavItems().forEachIndexed{index,navItem ->
            NavigationBarItem(
                selected = navState.intValue==index,
                onClick = { navState.intValue = index },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        Icon(painter = painterResource(id = navItem.icon),
                            contentDescription =navItem.title)
                        Text(
                            text = navItem.title,
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.nunito_sans)),
                                fontWeight = if (navState.intValue == index) FontWeight.Bold else FontWeight.SemiBold,
                                fontSize = MaterialTheme.typography.titleSmall.fontSize
                            ), modifier = Modifier.padding(top = 2.dp)
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.inverseOnSurface,
                )
            )
        }
    }
}
