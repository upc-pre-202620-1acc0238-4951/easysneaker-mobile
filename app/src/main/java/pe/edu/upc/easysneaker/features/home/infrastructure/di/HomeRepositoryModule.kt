package pe.edu.upc.easysneaker.features.home.infrastructure.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import pe.edu.upc.easysneaker.features.home.domain.ProductRepository
import pe.edu.upc.easysneaker.features.home.infrastructure.repository.InMemoryRepository
import pe.edu.upc.easysneaker.features.home.infrastructure.repository.ProductRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
interface HomeRepositoryModule {

    @Binds
    fun provideProductRepository(impl: InMemoryRepository): ProductRepository
}