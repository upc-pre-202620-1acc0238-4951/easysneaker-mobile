package pe.edu.upc.easysneaker.features.home.infrastructure

import kotlinx.coroutines.delay
import pe.edu.upc.easysneaker.features.home.domain.Product
import pe.edu.upc.easysneaker.features.home.domain.ProductRepository
import kotlin.time.Duration.Companion.milliseconds

class InMemoryRepository: ProductRepository {

    val products = listOf(
        Product(
            id = 1,
            name = "Nike Air Motion",
            price = 122.64,
            rating = 4.9,
            imageUrl = "https://i.imgur.com/E8ZBAnC.png"
        ),
        Product(
            id = 2,
            name = "ASICS Velocity Pro",
            price = 106.64,
            rating = 4.8,
            imageUrl = "https://i.imgur.com/Uh1Jye7.png"
        ),
        Product(
            id = 3,
            name = "Adidas RunBoost X",
            price = 93.31,
            rating = 4.6,
            imageUrl = "https://i.imgur.com/1yfHnqw.png"
        )
    )
    override suspend fun getProducts(): List<Product> {

        delay(2000.milliseconds) // Simulate network delay
        return products
    }
}