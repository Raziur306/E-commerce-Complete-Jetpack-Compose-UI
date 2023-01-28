package com.eritlab.jexmon.domain.use_case.get_product

import com.eritlab.jexmon.domain.model.ProductModel
import com.eritlab.jexmon.domain.repository.ProductRepository
import com.eritlab.jexmon.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    operator fun invoke(): Flow<Resource<List<ProductModel>>> = flow {
        try {
            emit(Resource.Loading())
            val products = repository.getProduct()?.map { it }
            emit(Resource.Success(data = products))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}