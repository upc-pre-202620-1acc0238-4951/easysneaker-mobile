package pe.edu.upc.easysneaker.features.auth.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import pe.edu.upc.easysneaker.features.auth.presentation.login.LoginScreen
import pe.edu.upc.easysneaker.features.auth.presentation.register.RegisterScreen

@Serializable
object AuthNavGraphRoute

@Serializable
object LoginRoute

@Serializable
object RegisterRoute

fun NavGraphBuilder.authNavGraph(navController: NavController) {

    navigation<AuthNavGraphRoute>(startDestination = LoginRoute) {
        composable<LoginRoute> {
            LoginScreen {
                navController.navigate(RegisterRoute)
            }
        }
        composable<RegisterRoute> {
            RegisterScreen()
        }
    }
}