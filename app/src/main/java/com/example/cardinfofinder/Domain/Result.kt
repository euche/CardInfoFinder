package com.example.cardinfofinder.Domain


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("bank")
    val bank: String,
    @SerializedName("bin")
    val bin: String,
    @SerializedName("brand")
    val brand: String,
    @SerializedName("card_category")
    val cardCategory: String,
    @SerializedName("card_type")
    val cardType: String,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("country_name")
    val countryName: String
)