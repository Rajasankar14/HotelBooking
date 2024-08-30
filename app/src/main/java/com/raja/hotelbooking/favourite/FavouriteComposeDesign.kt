package com.raja.hotelbooking.favourite

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.raja.jetpackcompose.Home.ui.MostPopularHotels
import com.raja.jetpackcompose.Home.ui.MostPopularItem
import com.raja.jetpackcompose.R

@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FavouriteComposeDesign() {

    Scaffold(
        content = {
        Column() {
            LazyColumn() {
                items(getMostPopularHotels()){
                    favouriteHotelList ->
                    MostPopularItem(mostPopularHotels = favouriteHotelList)
                }
            }
        }
    })
}

fun getMostPopularHotels(): List<MostPopularHotels> {
    return listOf(
        MostPopularHotels("Ibis budget Melbourne CBD", R.drawable.hotel1,"$345","Australia","4.8(12.6k)","3 Beds","2 Baths","4 Guests", "","",false),
        MostPopularHotels("Radisson Flagstaff Gardens Melbourne", R.drawable.hotel2,"$400","Australia","3.5(23.1k)","1 Bed","1 Baths","2 Guests", "","",false),
        MostPopularHotels("Pegasus Apart'Hotel", R.drawable.hotel3,"$345","Australia","2.8(6k)","2 Beds","2 Baths","4 Guests", "","",false),
        MostPopularHotels("Atlantis Hotels, Melbourne", R.drawable.mountain,"$509","Australia","4.0(45.1k)","2 Beds","2 Baths","4 Guests", "","",false),

        )
}

@Preview(showBackground = true)
@Composable
fun FavouriteScreenDesignPreview(){
FavouriteComposeDesign()

}