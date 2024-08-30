package com.raja.hotelbooking.calenderBooking

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CalenderBookingComposeDesign() {
    Scaffold (
        content = {
            Column (modifier = Modifier.padding(top = 60.dp)){

            }
        }
    )
}

@Preview
@Composable
fun CalenderBookingComposeDesignPreView(){
    CalenderBookingComposeDesign()
}