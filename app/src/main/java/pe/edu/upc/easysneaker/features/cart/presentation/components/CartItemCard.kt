package pe.edu.upc.easysneaker.features.cart.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import pe.edu.upc.easysneaker.features.cart.domain.CartItem

@Composable
fun CartItemCard(cartItem: CartItem) {

    Column {
        Text(text = cartItem.name)
    }
}