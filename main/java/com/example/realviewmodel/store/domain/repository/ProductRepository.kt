package com.example.realviewmodel.store.domain.repository

import arrow.core.Either
import com.example.realviewmodel.store.domain.model.NetworkError
import com.example.realviewmodel.store.domain.model.ProductItem

interface ProductsRepository {
    suspend fun getProducts(): Either<NetworkError,List<ProductItem>>
}