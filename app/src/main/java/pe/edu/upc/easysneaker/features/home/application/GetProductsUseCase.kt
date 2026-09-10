package pe.edu.upc.easysneaker.features.home.application

import pe.edu.upc.easysneaker.features.home.domain.Product
import pe.edu.upc.easysneaker.features.home.domain.ProductRepository
import pe.edu.upc.easysneaker.features.home.infrastructure.repository.ProductRepositoryImpl

class GetProductsUseCase(
    private val productRepository: ProductRepository = ProductRepositoryImpl()
) {
    suspend operator fun invoke(): List<Product> = productRepository.getProducts()
}