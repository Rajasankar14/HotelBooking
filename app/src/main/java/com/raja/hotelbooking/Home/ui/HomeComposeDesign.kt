package com.raja.jetpackcompose.Home.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BedroomBaby
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.LocalBar
import androidx.compose.material.icons.filled.LocalParking
import androidx.compose.material.icons.filled.Park
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raja.jetpackcompose.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeComposeDesign(lazyListState: LazyListState) {
    Scaffold(content ={
        LazyColumn(modifier = Modifier
            .background(MaterialTheme.colorScheme.onSecondary)
            .fillMaxWidth()
            .fillMaxSize()
            .wrapContentHeight(),
            state = lazyListState
            //contentPadding = PaddingValues(bottom = 30.dp)
        ) {
            /*item {
                SearchCustomBar()
            }*/
            item {
                CategoryDesign()
            }
            item {
                MostPopularHeading()
            }

            items(getMostPopularHotels()) { popularHotelList ->
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)) {
                    MostPopularItem(mostPopularHotels = popularHotelList)
                }
            }


        }

    })
}



fun getSampleCategories(): List<CategoryList> {
    return listOf(CategoryList("Mountain", R.drawable.mountain),
        CategoryList("Beach", R.drawable.beach),
        CategoryList("Island", R.drawable.island),
        CategoryList("Trecking", R.drawable.trecking)
    )
}

fun getMostPopularHotels(): List<MostPopularHotels> {
    return listOf(
        MostPopularHotels("Ibis budget Melbourne CBD", R.drawable.hotel1,"$345","Australia","4.8(12.6k)","3 Beds","2 Baths","4 Guests", "","",false),
        MostPopularHotels("Radisson Flagstaff Gardens Melbourne", R.drawable.hotel2,"$400","Australia","3.5(23.1k)","1 Bed","1 Baths","2 Guests", "","",false),
        MostPopularHotels("Pegasus Apart'Hotel", R.drawable.hotel3,"$345","Australia","2.8(6k)","2 Beds","2 Baths","4 Guests", "","",false),
        MostPopularHotels("Atlantis Hotels, Melbourne", R.drawable.mountain,"$509","Australia","4.0(45.1k)","2 Beds","2 Baths","4 Guests", "","",false),
        MostPopularHotels("West Apart'Hotel", R.drawable.hotel1,"$645","Australia","5.8(6k)","2 Beds","2 Baths","4 Guests", "","",false),
        MostPopularHotels("Lemon Tree Hotels, Melbourne", R.drawable.hotel2,"$409","Australia","4.5(45.1k)","4 Beds","2 Baths","4 Guests", "","",false),

        )
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchCustomBar() {
    val textState = remember {
        mutableStateOf(TextFieldValue(""))
    }
    TextField(
        value = textState.value,
        onValueChange =
        {
                value -> textState.value = value
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
        leadingIcon = {
            Icon(imageVector =  Icons.Default.Search, contentDescription ="" )

        },
        trailingIcon = {
            if(textState.value != TextFieldValue("")){
                IconButton(onClick = { textState.value = TextFieldValue("") }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "" )
                }
            }
        },
        placeholder = {
            Text(text = "Where Do you want to Go?")
        },
        singleLine = true,
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )

    )

}

@Composable
fun MostPopularHeading(){
    val bgColor = Color(0xFFE0E0E0)
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(MaterialTheme.colorScheme.inverseOnSurface)
        // Internal padding
    ) {
        Text(
            text = "Most Popular",
            modifier = Modifier
                .padding(start = 16.dp, top = 12.dp, bottom = 8.dp)
                .background(MaterialTheme.colorScheme.inverseOnSurface),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium ,
            fontSize = 16.sp

        )
    }
}


@Composable
fun CategoryDesign(){
    Box(modifier = Modifier
        .padding(start = 12.dp, top = 16.dp, bottom = 12.dp, end = 12.dp)
        .clip(
            RoundedCornerShape(16.dp)
        )
        .background(MaterialTheme.colorScheme.secondaryContainer)
        .wrapContentHeight()
        .fillMaxWidth()){

        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(start = 4.dp, end = 4.dp) // Use fillMaxSize to occupy available space
            // Internal padding
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp), // Padding below "Categories" text
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Categories", color = Color.Black, fontSize = 18.sp,modifier = Modifier.padding(8.dp), fontWeight = FontWeight.Bold)
                Text(text = "See All", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold,  style = MaterialTheme.typography.headlineMedium ,fontSize = 16.sp,modifier = Modifier
                    .padding(8.dp))


            }

            LazyRow(contentPadding = PaddingValues(horizontal = 1.dp),
                horizontalArrangement = Arrangement.spacedBy(1.dp)){
                items(getSampleCategories()){
                        category ->
                    CategoryItem(category)

                }
            }

        }
    }

}


@Composable
fun CategoryItem(categoryList: CategoryList){
    Box(modifier = Modifier
        .height(150.dp)
        .width(100.dp)
        .padding(2.dp)
    ){

        Column(modifier = Modifier.wrapContentHeight()) {
            Image(painter = painterResource(id = categoryList.drawable ), contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(110.dp)
                    .width(100.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.CenterHorizontally))

            Text(text = categoryList.categoryName, color = Color.Black, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(4.dp),
                fontSize = 14.sp,
                style = MaterialTheme.typography.headlineSmall ,
                textAlign = TextAlign.Center // Optional: padding around the text
            )
        }

    }
}

@Composable
fun MostPopularListDesign(){
    Column(
        modifier =
        Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        LazyColumn( ){
            items(getMostPopularHotels()){
                    popularHotelList ->
                MostPopularItem(mostPopularHotels =popularHotelList)
            }

        }

    }
}

@Composable
fun MostPopularItem(mostPopularHotels: MostPopularHotels){
var  isFavorite by remember { mutableStateOf(false) }

    Column(
        modifier =
        Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .wrapContentHeight()
            .fillMaxWidth()
    ) {


        Box(
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = mostPopularHotels.placeImage),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(180.dp)
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))

            )

            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Location Icon",
                modifier = Modifier
                    .padding(8.dp)
                    .size(40.dp)
                    .wrapContentWidth()
                    .align(Alignment.TopEnd)
                    .clickable { isFavorite = !isFavorite }, // Toggle favorite status on click
                tint = if (isFavorite) Color.Red else Color.Gray

            )

        }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = mostPopularHotels.placeName,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineLarge ,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = mostPopularHotels.rating,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.headlineMedium ,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                )
            }


                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, top = 6.dp, bottom = 6.dp)
                    , horizontalArrangement = Arrangement.SpaceBetween) {

                    Column(modifier = Modifier
                        .wrapContentHeight()
                    ) {

                        Row (modifier = Modifier
                            .wrapContentWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween) {
                           /* Row(modifier = Modifier
                                .wrapContentHeight()
                                .wrapContentWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    imageVector = Icons.Filled.LocationOn,
                                    contentDescription = "Location Icon",
                                    modifier = Modifier
                                        .size(15.dp)
                                        .wrapContentWidth(),
                                    colorFilter = ColorFilter.tint(Color.Gray)
                                )

                                Text(
                                    text = mostPopularHotels.location,
                                    color = Color.Gray,
                                    fontSize = 12.sp,
                                    style = MaterialTheme.typography.bodyMedium ,
                                    modifier = Modifier
                                        .wrapContentWidth(),
                                    fontWeight = FontWeight.Medium,

                                    )

                                 Spacer(modifier = Modifier.width(8.dp))
                                Image(
                                    imageVector = Icons.Filled.Star,
                                    contentDescription = "Location Icon",
                                    modifier = Modifier
                                        .size(15.dp)
                                        .wrapContentWidth(),
                                    colorFilter = ColorFilter.tint(Color.Gray)
                                )
                                Text(
                                    text = mostPopularHotels.rating,
                                    fontSize = 12.sp,
                                    style = MaterialTheme.typography.bodyMedium ,
                                    modifier = Modifier
                                        .wrapContentWidth()
                                        .padding(start = 4.dp),
                                    color = Color.Gray,
                                    fontWeight = FontWeight.Medium,
                                    textAlign = TextAlign.End
                                )
                            }*/


                        }


                        Row (modifier = Modifier
                            .wrapContentWidth()
                            .height(30.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(MaterialTheme.colorScheme.secondaryContainer),
                            verticalAlignment = Alignment.CenterVertically,) {

                            Spacer(modifier = Modifier.width(8.dp))
                            Image(
                                imageVector = Icons.Default.LocalParking,
                                contentDescription = "Location Icon",
                                modifier = Modifier
                                    .size(14.dp)
                                    .wrapContentWidth(),
                                colorFilter = ColorFilter.tint(Color.Gray)
                            )

                            Text(
                                text = "|",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                style = MaterialTheme.typography.bodyMedium ,
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .padding(start = 4.dp),
                                fontWeight = FontWeight.Medium,
                            )

                            Spacer(modifier = Modifier.width(8.dp))
                            Image(
                                imageVector = Icons.Default.Restaurant,
                                contentDescription = " Icon",
                                modifier = Modifier
                                    .size(14.dp)
                                    .wrapContentWidth(),
                                colorFilter = ColorFilter.tint(Color.Gray)
                            )
                            Text(
                                text = "|",
                                fontSize = 12.sp,
                                color = Color.Gray,
                                style = MaterialTheme.typography.bodyMedium ,
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .padding(start = 4.dp),
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.End
                            )
                            Spacer(modifier = Modifier.width(8.dp))

                            Image(
                                imageVector = Icons.Default.Group,
                                contentDescription = "Location Icon",
                                modifier = Modifier
                                    .size(14.dp)
                                    .wrapContentWidth(),
                                colorFilter = ColorFilter.tint(Color.Gray)
                            )
                            Text(
                                text = "|",
                                fontSize = 12.sp,
                                color = Color.Gray,
                                style = MaterialTheme.typography.bodyMedium ,
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .padding(start = 4.dp),
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.End
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Image(
                                imageVector = Icons.Default.BedroomBaby,
                                contentDescription = "Location Icon",
                                modifier = Modifier
                                    .size(14.dp)
                                    .wrapContentWidth(),
                                colorFilter = ColorFilter.tint(Color.Gray)
                            )
                            Text(
                                text = "|",
                                fontSize = 12.sp,
                                color = Color.Gray,
                                style = MaterialTheme.typography.bodyMedium ,
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .padding(start = 4.dp, end = 4.dp),
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.End
                            )

                            Image(
                                imageVector = Icons.Default.Park,
                                contentDescription = "Location Icon",
                                modifier = Modifier
                                    .size(14.dp)
                                    .wrapContentWidth(),
                                colorFilter = ColorFilter.tint(Color.Gray)
                            )


                            Text(
                                text = "|",
                                fontSize = 12.sp,
                                color = Color.Gray,
                                style = MaterialTheme.typography.bodyMedium ,
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .padding(start = 4.dp),
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.End
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Image(
                                imageVector = Icons.Default.LocalBar,
                                contentDescription = "Location Icon",
                                modifier = Modifier
                                    .size(14.dp)
                                    .wrapContentWidth(),
                                colorFilter = ColorFilter.tint(Color.Gray)
                            )
                            Spacer(modifier = Modifier.width(8.dp))



                        }


                    }

                    /*Button(onClick = {}, modifier = Modifier.height(40.dp).align(Alignment.CenterVertically) ) {
                        Text(text = "view more", style = MaterialTheme.typography.bodyMedium, fontSize = 14.sp )
                    }*/
                    Text(
                        text = mostPopularHotels.amount,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.headlineMedium ,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(end = 8.dp)

                    )

                }




    }
}

@Preview(showBackground = true)
@Composable
fun HomeComposeDesignPreview(){
    HomeComposeDesign(lazyListState = rememberLazyListState())

}
