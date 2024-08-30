package com.raja.jetpackcompose.splash

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.raja.hotelbooking.MainHomeNavigation.ui.MainHomeNavDesign
import com.raja.jetpackcompose.Home.ui.HomeComposeDesign
import com.raja.jetpackcompose.navigation.Root
import com.raja.jetpackcompose.navigation.Route


fun NavGraphBuilder.WelcomeNavGraph(navHostController: NavHostController) {
    navigation(startDestination = Route.SPLASHSCREEN.SplashView, route = Root.SPLASH){
        composable(Route.SPLASHSCREEN.SplashView){
            SplashScreenDesign()
        }

        composable(Route.HOMESCREEN.HomeView){
            HomeComposeDesign(rememberLazyListState())
        }

        composable(Route.MAINHOMENAVIGATION.MainHomeNavView){
            MainHomeNavDesign()
        }



    }
}