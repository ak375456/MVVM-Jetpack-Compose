package com.example.realviewmodel.store.data.repository

import arrow.core.Either
import com.example.realviewmodel.store.data.mapper.toNetworkError
import com.example.realviewmodel.store.data.remote.ProductsApi
import com.example.realviewmodel.store.domain.model.NetworkError
import com.example.realviewmodel.store.domain.model.ProductItem
import com.example.realviewmodel.store.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val productsApi: ProductsApi
): ProductsRepository {
    override suspend fun getProducts(): Either<NetworkError, List<ProductItem>> {
        return Either.catch {
            productsApi.getProducts()
        }.mapLeft { it.toNetworkError() }
    }
}