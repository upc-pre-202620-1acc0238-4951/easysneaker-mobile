package pe.edu.upc.easysneaker.features.home.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import pe.edu.upc.easysneaker.features.home.presentation.productdetail.ProductDetailScreen
import pe.edu.upc.easysneaker.features.home.presentation.home.HomeScreen


@Serializable
data object HomeRoute

@Serializable
data class ProductDetailRoute(val id: Int)

fun NavGraphBuilder.homeNavGraph(navController: NavController) {


    composable<HomeRoute> {

        HomeScreen { product ->
            navController.navigate(ProductDetailRoute(product.id))
        }

    }

    composable<ProductDetailRoute> { backStackEntry ->
        val route = backStackEntry.toRoute<ProductDetailRoute>()
        ProductDetailScreen(id = route.id) {
            navController.popBackStack()
        }

    }
}