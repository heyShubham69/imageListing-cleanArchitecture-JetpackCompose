package com.example.imagelisting.data

data class itemData(
    val Response: String,
    val Search: List<SearchItem>,
    val totalResults: String
)
data class SearchItem(
    val Poster: String,
    val Title: String,
    val Type: String,
    val Year: String,
    val imdbID: String
)