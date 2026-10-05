package pe.edu.upc.easysneaker.features.auth.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import pe.edu.upc.easysneaker.features.auth.presentation.login.LoginScreen
import pe.edu.upc.easysneaker.features.auth.presentation.register.RegisterScreen
import pe.edu.upc.easysneaker.features.home.presentation.navigation.HomeNavGraphRoute
import pe.edu.upc.easysneaker.features.main.presentation.MainNavGraphRoute

@Serializable
object AuthNavGraphRoute

@Serializable
object LoginRoute

@Serializable
object RegisterRoute

fun NavGraphBuilder.authNavGraph(navController: NavController) {

    navigation<AuthNavGraphRoute>(startDestination = LoginRoute) {
        composable<LoginRoute> {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(MainNavGraphRoute) {
                        popUpTo(LoginRoute) {
                            inclusive = true
                        }
                    }
                }
            ) {
                navController.navigate(RegisterRoute)
            }
        }
        composable<RegisterRoute> {
            RegisterScreen()
        }
    }
}