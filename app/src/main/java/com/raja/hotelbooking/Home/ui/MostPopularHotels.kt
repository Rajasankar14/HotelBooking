package com.raja.jetpackcompose.Home.ui

data class MostPopularHotels(
    var placeName : String,
    var placeImage: Int,
    var amount : String,
    var location : String,
    var rating : String,
    var beds : String,
    var baths  : String,
    var guests : String,
    var highlights : String,
    var description : String,
    var fav : Boolean
    ) {
}