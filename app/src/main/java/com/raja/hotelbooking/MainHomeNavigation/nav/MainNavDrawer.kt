/*
package com.raja.hotelbooking.MainHomeNavigation.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.raja.hotelbooking.calenderBooking.CalenderBookingComposeDesign
import com.raja.hotelbooking.favourite.FavouriteComposeDesign
import com.raja.hotelbooking.myBooking.MyBookingComposeDesign
import com.raja.hotelbooking.profile.ProfileComposeDesign
import com.raja.jetpackcompose.Home.ui.HomeComposeDesign
import com.raja.jetpackcompose.navigation.Root
import com.raja.jetpackcompose.navigation.Route

fun NavGraphBuilder.MainNavDrawer(navHostController: NavHostController){

    navigation(startDestination = Route.HOMESCREEN.HomeView, route = Root.MAIN_NAV_GRAPH){
        composable(Route.HOMESCREEN.HomeView){ HomeComposeDesign() }
        composable(Route.FAVNAV.FavNavView) { FavouriteComposeDesign(navHostController) }
        composable(Route.CALNAV.CALNavView) { CalenderBookingComposeDesign(navHostController = navHostController) }
        composable(Route.MYBOOKING.MyBookingNavView) { MyBookingComposeDesign(navHostController = navHostController) }
        composable(Route.PROFILENAV.ProfileNavView) { ProfileComposeDesign(navHostController = navHostController) }

    }

}
*/
