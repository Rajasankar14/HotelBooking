package com.raja.hotelbooking.MainHomeNavigation

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.raja.hotelbooking.calenderBooking.CalenderBookingComposeDesign
import com.raja.hotelbooking.favourite.FavouriteComposeDesign
import com.raja.hotelbooking.myBooking.MyBookingComposeDesign
import com.raja.hotelbooking.profile.ProfileComposeDesign
import com.raja.jetpackcompose.Home.ui.HomeComposeDesign
import com.raja.jetpackcompose.navigation.Route

@Composable
fun NavigationScreens(navHostController: NavHostController) {
   NavHost( navHostController,  Route.HOMESCREEN.HomeView){
       composable(Route.HOMESCREEN.HomeView) { HomeComposeDesign(rememberLazyListState()) }
       composable(Route.FAVNAV.FavNavView) { FavouriteComposeDesign() }
       composable(Route.CALNAV.CALNavView) {  CalenderBookingComposeDesign() }
       composable(Route.MYBOOKING.MyBookingNavView) { MyBookingComposeDesign() }
       composable(Route.PROFILENAV.ProfileNavView) { ProfileComposeDesign()}

   }

}