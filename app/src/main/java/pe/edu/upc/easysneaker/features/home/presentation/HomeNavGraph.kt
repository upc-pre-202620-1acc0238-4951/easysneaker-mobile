package pe.edu.upc.easysneaker.features.home.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.homeNavGraph(navController: NavController) {


    composable(route = "home") {

        HomeScreen()

    }

    composable(route = "product_detail") {


    }
}