package pe.edu.upc.easysneaker.features.home.infrastructure.repository

import pe.edu.upc.easysneaker.features.home.domain.Product
import pe.edu.upc.easysneaker.features.home.domain.ProductRepository
import pe.edu.upc.easysneaker.features.home.infrastructure.local.ProductDao
import pe.edu.upc.easysneaker.features.home.infrastructure.local.ProductEntity
import pe.edu.upc.easysneaker.features.home.infrastructure.remote.ProductService
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val service: ProductService,
    private val dao: ProductDao
) : ProductRepository {
    override suspend fun getProducts(): List<Product> {

        try {
            val response = service.getProducts()
            if (response.isSuccessful) {
                response.body()?.let { productsResponseDto ->
                    val entities = productsResponseDto.products.map { dto ->
                        ProductEntity(
                            id = dto.id,
                            name = dto.name,
                            price = dto.price,
                            rating = dto.rating,
                            image = dto.image,
                            description = dto.description
                        )
                    }.toList()
                    dao.insertProducts(entities)
                }
            }

        } catch (e: Exception) {

        }
        return dao.fetchAllProducts().map { entity ->
            Product(
                id = entity.id,
                name = entity.name,
                price = entity.price,
                rating = entity.rating,
                imageUrl = entity.image,
                description = entity.description
            )
        }

    }

    override suspend fun getProductById(id: Int): Product? {

        try {
            val response = service.getProductById(id)

            if (response.isSuccessful) {
                response.body()?.let { dto ->
                    val entity = ProductEntity(
                        id = dto.id,
                        name = dto.name,
                        price = dto.price,
                        rating = dto.rating,
                        image = dto.image,
                        description = dto.description
                    )
                    dao.insertProduct(entity)
                }
            }
        } catch (e: Exception) {

        }
        val entity = dao.fetchProductById(id)
        entity?.let {
            return Product(
                id = it.id,
                name = it.name,
                price = it.price,
                rating = it.rating,
                imageUrl = it.image,
                description = it.description
            )
        }
        return null
    }

    override suspend fun toggleFavoriteProduct(id: Int) {
        TODO("Not yet implemented")
    }
}