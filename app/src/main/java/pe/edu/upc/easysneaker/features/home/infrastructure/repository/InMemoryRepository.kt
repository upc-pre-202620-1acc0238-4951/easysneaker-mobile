package pe.edu.upc.easysneaker.features.home.infrastructure.repository

import kotlinx.coroutines.delay
import pe.edu.upc.easysneaker.features.home.domain.Product
import pe.edu.upc.easysneaker.features.home.domain.ProductRepository
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

class InMemoryRepository @Inject constructor() : ProductRepository {

    val products = listOf(
        Product(
            id = 1,
            name = "Nike Air Motion",
            price = 122.64,
            rating = 4.9,
            imageUrl = "https://i.imgur.com/E8ZBAnC.png",
            description = "Experience the ultimate in comfort and performance with the Nike Air Motion. Designed for runners, this shoe features responsive cushioning and a lightweight design that will keep you moving with ease."
        ),
        Product(
            id = 2,
            name = "ASICS Velocity Pro",
            price = 106.64,
            rating = 4.8,
            imageUrl = "https://i.imgur.com/Uh1Jye7.png",
            description = "Experience the ultimate in comfort and performance with the Nike Air Motion. Designed for runners, this shoe features responsive cushioning and a lightweight design that will keep you moving with ease."

        ),
        Product(
            id = 3,
            name = "Adidas RunBoost X",
            price = 93.31,
            rating = 4.6,
            imageUrl = "https://i.imgur.com/1yfHnqw.png",
            description = "Experience the ultimate in comfort and performance with the Nike Air Motion. Designed for runners, this shoe features responsive cushioning and a lightweight design that will keep you moving with ease."
        )
    )

    override suspend fun getProducts(): List<Product> {

        delay(2000.milliseconds) // Simulate network delay
        return products
    }

    override suspend fun getProductById(id: Int): Product? {
        delay(1000.milliseconds)
        return products.find { it.id == id }
    }
}