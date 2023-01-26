package com.eritlab.jexmon.presentation.screens.dashboard_screen

import com.eritlab.jexmon.domain.model.ProductModel

data class ProductState(
    val isLoading: Boolean = false,
    val product: List<ProductModel>? = null,
    val errorMessage: String = ""
)
