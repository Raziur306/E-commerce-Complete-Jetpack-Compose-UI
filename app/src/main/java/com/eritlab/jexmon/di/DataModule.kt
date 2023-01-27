package com.eritlab.jexmon.di

import com.eritlab.jexmon.data.demo_db.DemoDB
import com.eritlab.jexmon.data.repository.ProductRepositoryImp
import com.eritlab.jexmon.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideProductRepository(demoDB: DemoDB): ProductRepository {
        return ProductRepositoryImp(demoDB)
    }

}