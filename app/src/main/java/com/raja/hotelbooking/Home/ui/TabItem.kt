package com.raja.jetpackcompose.Home.ui

import androidx.compose.ui.graphics.vector.ImageVector


data class TabItem(
    var selectedTabTitle: String,
    var selectedTabIcon : ImageVector,
    var unSelectedTabIcon : ImageVector,
    var batchCount : Int
)
