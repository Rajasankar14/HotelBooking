package com.raja.hotelbooking.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TopCustomActionBar(screenTitle: String, navHostController: NavHostController, pagerState: PagerState) {
    val coroutineScope = rememberCoroutineScope()
    Box(modifier = Modifier
        .height(60.dp)
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.secondaryContainer),
        contentAlignment = Alignment.CenterStart) {
        Row(
            modifier = Modifier.padding(8.dp),) {
            Image(
                imageVector = Icons.Default.Menu,
                contentDescription = "Location Icon",
                modifier = Modifier
                    .size(30.dp)
                    .wrapContentWidth()
                    .clickable {
                        //navHostController.popBackStack()
                        /*coroutineScope.launch {
                            pagerState.animateScrollToPage(0)
                        }*/
                    },
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = screenTitle, modifier = Modifier.align(Alignment.CenterVertically), color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }

    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun TopActionBarPreview(){
    TopCustomActionBar(screenTitle = "Screen Name", navHostController = rememberNavController(), pagerState = rememberPagerState(initialPage = 0) )
}