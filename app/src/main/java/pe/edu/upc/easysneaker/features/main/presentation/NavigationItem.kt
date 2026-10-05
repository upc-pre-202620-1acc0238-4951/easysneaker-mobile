package pe.edu.upc.easysneaker.features.main.presentation

import androidx.compose.ui.graphics.vector.ImageVector
import pe.edu.upc.easysneaker.core.designsystem.icon.home
import pe.edu.upc.easysneaker.core.designsystem.icon.shoppingCart
import pe.edu.upc.easysneaker.features.cart.presentation.navigation.CartNavGraphRoute
import pe.edu.upc.easysneaker.features.home.presentation.navigation.HomeNavGraphRoute

sealed class NavigationItem(
    val route: Any,
    val icon: ImageVector,
    val title: String
) {
    data object Home : NavigationItem(HomeNavGraphRoute, home, "Home")
    data object Cart : NavigationItem(CartNavGraphRoute, shoppingCart, "Cart")

    companion object {
        val tabs: List<NavigationItem> = listOf(
            Home,
            Cart
        )
    }
}