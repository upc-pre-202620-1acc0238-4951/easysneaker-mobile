package pe.edu.upc.easysneaker.features.home.domain

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val rating: Double,
    val imageUrl: String
)