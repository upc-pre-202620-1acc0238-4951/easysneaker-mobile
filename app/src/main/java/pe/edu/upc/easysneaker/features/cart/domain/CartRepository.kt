package pe.edu.upc.easysneaker.features.cart.domain

import pe.edu.upc.easysneaker.features.cart.infrastructure.remote.CartDto

interface CartRepository {

    suspend fun getCart(): Result<Cart>
}