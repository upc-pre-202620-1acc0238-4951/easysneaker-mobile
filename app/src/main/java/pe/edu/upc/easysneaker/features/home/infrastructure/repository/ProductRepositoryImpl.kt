package pe.edu.upc.easysneaker.features.home.infrastructure.repository

import pe.edu.upc.easysneaker.features.home.domain.Product
import pe.edu.upc.easysneaker.features.home.domain.ProductRepository
import pe.edu.upc.easysneaker.features.home.infrastructure.remote.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductRepositoryImpl(
    private val service: ProductService =
        Retrofit.Builder().baseUrl("https://sneakerapi-y3ub.onrender.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ProductService::class.java)

) : ProductRepository {
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
                        imageUrl = dto.image
                    )
                }.toList()
            }
        }
        return emptyList()
    }
}