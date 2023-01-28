package com.eritlab.jexmon.domain.use_case.get_product_detail

import com.eritlab.jexmon.domain.model.ProductModel
import com.eritlab.jexmon.domain.repository.ProductRepository
import com.eritlab.jexmon.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductDetailUseCase @Inject constructor(private val repository: ProductRepository) {
    operator fun invoke(productId: Int): Flow<Resource<ProductModel>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getProductDetail(productId)
            emit(Resource.Success(data = data))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }

}