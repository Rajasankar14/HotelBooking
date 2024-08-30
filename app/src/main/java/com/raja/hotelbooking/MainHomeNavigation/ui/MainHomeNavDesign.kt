package com.raja.hotelbooking.MainHomeNavigation.ui

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.raja.hotelbooking.MainHomeNavigation.NavigationScreens


@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainHomeNavDesign() {

   val navController = rememberNavController()

    rememberPagerState(initialPage = 0)

    Scaffold (
        bottomBar = {
            BottomNavigationBarDesign(navController)
        }
    ) {
        /*It helps to navigate to screen when selecting bottom bar Item*/
        NavigationScreens(navHostController = navController)

    }



}

@Preview
@Composable
fun MainHomeNavDesignPreview(){
    MainHomeNavDesign()
}