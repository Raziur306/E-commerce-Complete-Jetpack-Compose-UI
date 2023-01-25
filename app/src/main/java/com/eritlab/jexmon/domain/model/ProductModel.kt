package com.eritlab.jexmon.domain.model

import androidx.compose.ui.graphics.Color

data class ProductModel(
    val id: Int,
    val title: String,
    val images: List<Int>,
    val colors: List<Color>,
    val rating: Double,
    val price: Double,
    val isFavourite: Boolean,
    val isPopular: Boolean,
    val description: String
)