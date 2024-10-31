package com.example.realviewmodel.di

import com.example.realviewmodel.store.data.repository.ProductsRepositoryImpl
import com.example.realviewmodel.store.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindProductsRepository(impl: ProductsRepositoryImpl): ProductsRepository
}