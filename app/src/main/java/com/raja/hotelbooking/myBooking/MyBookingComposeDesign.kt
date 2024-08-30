package com.raja.hotelbooking.myBooking

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyBookingComposeDesign() {
    Scaffold (
        content = {
            Column (modifier = Modifier.padding(top = 60.dp)){

            }
        }
    )




}

@Preview
@Composable
fun MyBookingComposeDesignPreview(){
    MyBookingComposeDesign()
}