package pe.edu.upc.easysneaker.features.home.infrastructure.remote

data class ProductDto(
    val id: Int,
    val name: String,
    val price: Double,
    val rating: Double,
    val currency: String,
    val description: String,
    val image: String
)
