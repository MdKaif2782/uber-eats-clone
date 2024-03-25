package com.example.ubereatsclone.Screens.MainScreen

import com.example.ubereatsclone.R

data class NavItem(var title: String, val icon: Int,var label:Int)


fun getNavItems(): List<NavItem> {
    return listOf(
        NavItem("Home", icon = R.drawable.ic_home,label =0),
        NavItem("Browse", icon = R.drawable.ic_browse,label = 0),
        NavItem("Basket", icon = R.drawable.ic_basket,label = 0),
        NavItem("Profile", icon = R.drawable.ic_profile,label = 0),

    )
}
