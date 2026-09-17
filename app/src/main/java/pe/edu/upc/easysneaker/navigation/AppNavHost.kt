package pe.edu.upc.easysneaker.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import pe.edu.upc.easysneaker.features.home.presentation.HomeRoute
import pe.edu.upc.easysneaker.features.home.presentation.homeNavGraph

@Composable
fun AppNavHost(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomAppBar {

            }
        }
    ) { paddingValues ->
        NavHost(
            navController,
            startDestination = HomeRoute,
            modifier = Modifier.padding(paddingValues)
        ) {
            homeNavGraph(navController)

        }
    }

}