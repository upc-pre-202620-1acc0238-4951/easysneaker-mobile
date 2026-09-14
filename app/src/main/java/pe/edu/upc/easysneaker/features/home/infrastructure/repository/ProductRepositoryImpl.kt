package pe.edu.upc.easysneaker.features.home.infrastructure.repository

import pe.edu.upc.easysneaker.features.home.domain.Product
import pe.edu.upc.easysneaker.features.home.domain.ProductRepository
import pe.edu.upc.easysneaker.features.home.infrastructure.remote.ProductService
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val service: ProductService) : ProductRepository {
    override suspend fun getProducts(): List<Product> {
        val response = service.getProducts()

        if (response.isSuccessful) {
            response.body()?.let { productsResponseDto ->
                return productsResponseDto.products.map { dto ->
                    Product(
                        id = dto.id,
                        name = dto.name,
                        price = dto.price,
                        rating = dto.rating,
                        imageUrl = dto.image,
                        description = dto.description
                    )
                }.toList()
            }
        }
        return emptyList()
    }
}