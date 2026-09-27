package pe.edu.upc.easysneaker.features.home.infrastructure.repository

import pe.edu.upc.easysneaker.features.home.domain.Product
import pe.edu.upc.easysneaker.features.home.domain.ProductRepository
import pe.edu.upc.easysneaker.features.home.infrastructure.local.ProductDao
import pe.edu.upc.easysneaker.features.home.infrastructure.local.ProductEntityAssembler
import pe.edu.upc.easysneaker.features.home.infrastructure.remote.ProductDtoAssembler
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
                    val entities = ProductDtoAssembler.toEntityList(productsResponseDto.products)
                    dao.insertProducts(entities)
                }
            }

        } catch (e: Exception) {

        }
        val entities = dao.fetchAllProducts()
        return ProductEntityAssembler.toDomainList(entities)
    }

    override suspend fun getProductById(id: Int): Product? {

        try {
            val response = service.getProductById(id)

            if (response.isSuccessful) {
                response.body()?.let { dto ->
                    val entity = ProductDtoAssembler.toEntity(dto)
                    dao.insertProduct(entity)
                }
            }
        } catch (e: Exception) {

        }
        val entity = dao.fetchProductById(id)
        return ProductEntityAssembler.toDomainFromEntity(entity)
    }

    override suspend fun toggleFavoriteProduct(id: Int) {
        TODO("Not yet implemented")
    }
}