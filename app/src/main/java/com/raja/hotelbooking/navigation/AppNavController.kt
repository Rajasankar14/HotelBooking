package com.raja.jetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.raja.jetpackcompose.splash.WelcomeNavGraph

@Composable
fun AppNavController(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Root.SPLASH , route = Root.APP){
        WelcomeNavGraph(navHostController)
      //  MainNavDrawer(navHostController)

    }
}