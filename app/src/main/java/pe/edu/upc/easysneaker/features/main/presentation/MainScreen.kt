package pe.edu.upc.easysneaker.features.main.presentation


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.easysneaker.features.cart.presentation.navigation.cartNavGraph
import pe.edu.upc.easysneaker.features.home.presentation.navigation.HomeNavGraphRoute
import pe.edu.upc.easysneaker.features.home.presentation.navigation.homeNavGraph


@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val mainNavController = rememberNavController()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            MainNavigationBar(mainNavController)
        }
    ) { paddingValues ->
        NavHost(
            navController = mainNavController,
            startDestination = HomeNavGraphRoute,
            modifier = modifier.padding(paddingValues)
        ) {
            homeNavGraph(mainNavController)
            cartNavGraph(mainNavController)
        }
    }

}

