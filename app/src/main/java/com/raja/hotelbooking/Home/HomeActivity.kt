package com.raja.jetpackcompose.Home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.raja.jetpackcompose.Categories.CategoriesComposeDesign
import com.raja.jetpackcompose.Home.ui.HomeComposeDesign
import com.raja.jetpackcompose.Home.ui.TabItem
import com.raja.jetpackcompose.Settings.SettingsComposeDesign


class HomeActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            AppTheme {
               // HomeScreenDesign()

                Scaffold(bottomBar = {
                    BottomAppBar {

                    }
                }) {

                }

            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreenDesign(){
    val homeTab = TabItem("Home", selectedTabIcon = Icons.Filled.Home, unSelectedTabIcon = Icons.Outlined.Home, 0)
    val alertTab = TabItem("Alerts", selectedTabIcon = Icons.Filled.Notifications, unSelectedTabIcon = Icons.Outlined.Notifications, 5)
    val categoriesTab = TabItem("Categories", selectedTabIcon = Icons.Filled.Category, unSelectedTabIcon = Icons.Outlined.Category, 0)
    val settingsTab = TabItem("Settings", selectedTabIcon = Icons.Filled.Settings, unSelectedTabIcon = Icons.Outlined.Settings, 0)
    val tabItemList = listOf(homeTab,categoriesTab,alertTab ,settingsTab)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        // Greeting("Android")
        val navController = rememberNavController()

        Scaffold (
            bottomBar = {
                TabView(tabItemList = tabItemList, navController = navController)
            }
        ) {
            NavHost(navController = navController, startDestination = homeTab.selectedTabTitle ){
                composable(homeTab.selectedTabTitle){
                    //HomeComposeDesign()
                }
                composable(categoriesTab.selectedTabTitle){
                    CategoriesComposeDesign(navController)
                }

                composable(alertTab.selectedTabTitle){

                }

                composable(settingsTab.selectedTabTitle){
                    SettingsComposeDesign(navController)
                }
            }
        }
    }
}

@Composable
fun TabView(tabItemList : List<TabItem>, navController: NavController){
    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar {
        tabItemList.forEachIndexed { index, tabItem ->
            NavigationBarItem(selected = selectedTabIndex == index,
                onClick = {
               selectedTabIndex = index
                navController.navigate(tabItem.selectedTabTitle)

            }, icon = {
                TabBarIconView(
                    isSelected = selectedTabIndex == index,
                    selectedIcon = tabItem.selectedTabIcon ,
                    unSelectedIcon = tabItem.unSelectedTabIcon,
                    badgeCount = tabItem.batchCount ,
                    tabTitle =  tabItem.selectedTabTitle
                )
                },
                label = {
                    Text(text = tabItem.selectedTabTitle)
                })
        }

    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabBarIconView(
    isSelected: Boolean,
    selectedIcon: ImageVector,
    unSelectedIcon : ImageVector,
    badgeCount : Int,
    tabTitle : String

){
    BadgedBox(badge = {
        if(badgeCount > 0)
          TabBarBadgeView(badgeCount)
    } ) {
         Icon(imageVector =
         if (isSelected)
             selectedIcon
         else
             unSelectedIcon, contentDescription = tabTitle)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabBarBadgeView(count: Int){
    Badge {
         Text(text = count.toString())
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Greeting("Android")
    }
}