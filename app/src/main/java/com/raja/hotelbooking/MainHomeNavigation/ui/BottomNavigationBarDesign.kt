package com.raja.hotelbooking.MainHomeNavigation.ui

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.raja.hotelbooking.MainHomeNavigation.nav.NavItem
import com.raja.hotelbooking.calenderBooking.CalenderBookingComposeDesign
import com.raja.hotelbooking.favourite.FavouriteComposeDesign
import com.raja.hotelbooking.myBooking.MyBookingComposeDesign
import com.raja.hotelbooking.profile.ProfileComposeDesign
import com.raja.jetpackcompose.Home.ui.HomeComposeDesign
import com.raja.jetpackcompose.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBarDesign(navHostController: NavHostController) {

    /* To Add Bottom Nav item as List */
    val navItems = listOf(NavItem.Home, NavItem.Fav, NavItem.Calender, NavItem.Chat, NavItem.Profile)

    /* To Remember Page state when we scrolls*/
    val pagerState = rememberPagerState(initialPage = 0)

    /*To remember and scroll to selected or navigated page  */
    val coroutineScope = rememberCoroutineScope()


    var lazyListState = rememberLazyListState()

    var isBarVisible by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(key1 = lazyListState.canScrollBackward) {
        snapshotFlow {
            lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == lazyListState.layoutInfo.totalItemsCount - 1
        }.collect { isAtEnd ->
            //isBarVisible = isAtEnd ||lazyListState.firstVisibleItemScrollOffset == 0
            isBarVisible = lazyListState.firstVisibleItemScrollOffset == 0
        }
        
    }

    remember {
        mutableStateOf(TextFieldValue(""))
    }

    val context = LocalContext.current

    // Handle back button press
    BackHandler {
        if (pagerState.currentPage != 0) {
            coroutineScope.launch {
                pagerState.scrollToPage(0)
            }
        } else {
            ActivityCompat.finishAffinity(context as Activity)
        }
    }

    Scaffold(
        topBar = {
            AnimatedVisibility(visible = isBarVisible) {
            TopAppBar(title = {

                Row(
                    modifier = Modifier.offset(x = (-16).dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AnimatedVisibility(
                        visible = (navItems[pagerState.currentPage].title.equals(
                            "Holiday Plan"
                        ))
                    ) {
                        Icon(
                            painter = painterResource(id = R.mipmap.ic_launcher),
                            contentDescription = "looo",
                            tint = Color.Unspecified,
                            modifier = Modifier.height(30.dp)
                        )
                    }

                    Text(
                        text = navItems[pagerState.currentPage].title,
                        modifier = Modifier
                            .padding(start = 2.dp),
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                    )
                }

            }, modifier = Modifier.clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)),
                backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                actions = {
                    AnimatedVisibility(visible = true) {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "close",
                                tint = MaterialTheme.colorScheme.primary
                            )

                        }
                    }
                    IconButton(onClick = { /* Handle search action */ }) {
                        Icon(
                            imageVector = Icons.Default.NotificationsNone,
                            contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {


                    }) {
                        Box(
                            modifier = Modifier
                                .size(48.dp) // Set the size of the circle
                                .background(
                                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f), // Set the circle color and transparency
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center // Center the icon inside the circle
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Home Menu",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }

                    }

                })
        }
        },
        bottomBar = {
         //   AnimatedVisibility(visible = isBarVisible) {

                NavigationBar(
                    modifier = Modifier
                        .wrapContentHeight()
                        .height(70.dp)
                        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
                        .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                ) {

                    navItems.forEachIndexed { index, item ->
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    imageVector = item.imageVector,
                                    contentDescription = item.title
                                )
                            },
                            selected = pagerState.currentPage == index,
                            onClick = {

                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            }
                        )
                    }

                }
         //   }
        },
    ) { innerPadding ->
        HorizontalPager(
            count = navItems.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) { item ->
                    when (navItems[item]) {
                        NavItem.Home -> HomeComposeDesign(lazyListState)
                        NavItem.Fav ->{
                            FavouriteComposeDesign()
                            isBarVisible = true
                        }
                        NavItem.Calender ->{
                            CalenderBookingComposeDesign()
                        }
                        NavItem.Chat -> {
                        MyBookingComposeDesign()
                        }
                        NavItem.Profile ->{
                        ProfileComposeDesign()
                        }
                    }





        }
    }
}

@Preview
@Composable
fun BottomNavigationBarDesignPreview() {
    BottomNavigationBarDesign(navHostController = rememberNavController())
}