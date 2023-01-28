package com.eritlab.jexmon.presentation.screens.product_detail_screen

import com.eritlab.jexmon.domain.model.ProductModel

data class ProductDetailState(
    val isLoading: Boolean = false,
    val productDetail: ProductModel? = null,
    val errorMessage: String = ""
)