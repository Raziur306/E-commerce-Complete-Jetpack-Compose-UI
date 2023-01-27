package com.eritlab.jexmon.domain.repository

import com.eritlab.jexmon.domain.model.ProductModel

interface ProductRepository {
    suspend fun getProduct(): List<ProductModel>? = null
    suspend fun getProductDetail(id: Int): ProductModel? = null
}