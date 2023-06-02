package com.example.dessertclicker.data

import androidx.annotation.DrawableRes
import com.example.dessertclicker.data.Datasource.dessertList

data class DessertUiState(
    val currentDessertIndex: Int =0,
    val dessertSold: Int =0,
    val revenue: Int =0,
    val currentDessertPrice: Int= dessertList[currentDessertIndex].price,
    @DrawableRes val currentDessertImgId: Int= dessertList[currentDessertIndex].imageId
)