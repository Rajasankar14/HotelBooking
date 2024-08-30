package com.raja.hotelbooking.MainHomeNavigation.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import com.raja.jetpackcompose.navigation.Route

sealed class NavItem {

    object Home:
            Item(title = "Holiday Plan", imageVector = Icons.Default.Home, path = Route.HOMESCREEN.HomeView)

    object Fav:
        Item(title = "Favourite", imageVector = Icons.Default.Favorite, path = Route.FAVNAV.FavNavView)

    object Calender:
        Item(title = "Calender Booking", imageVector = Icons.Default.CalendarMonth, path = Route.CALNAV.CALNavView)


    object Chat:
        Item(title = "My Bookings", imageVector = Icons.Default.History, path = Route.MYBOOKING.MyBookingNavView)


    object Profile:
        Item(title = "Profile", imageVector = Icons.Default.Person, path = Route.PROFILENAV.ProfileNavView)
}