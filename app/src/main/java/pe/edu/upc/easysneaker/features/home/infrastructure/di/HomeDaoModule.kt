package pe.edu.upc.easysneaker.features.home.infrastructure.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.edu.upc.easysneaker.features.home.infrastructure.local.AppDatabase
import pe.edu.upc.easysneaker.features.home.infrastructure.local.ProductDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeDaoModule {



    @Provides
    @Singleton
    fun provideProductDao(database: AppDatabase): ProductDao {
        return database.productDao()
    }
}