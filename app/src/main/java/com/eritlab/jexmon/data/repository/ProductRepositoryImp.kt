package com.eritlab.jexmon.data.repository

import com.eritlab.jexmon.data.demo_db.DemoDB
import com.eritlab.jexmon.domain.model.ProductModel
import com.eritlab.jexmon.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImp @Inject constructor(
    private val demoDB: DemoDB
) : ProductRepository {
    override suspend fun getProduct(): List<ProductModel> {
        return demoDB.getProduct()
    }

    override suspend fun getProductDetail(id: Int): ProductModel {
        return demoDB.getProduct()[id-1]
    }
}