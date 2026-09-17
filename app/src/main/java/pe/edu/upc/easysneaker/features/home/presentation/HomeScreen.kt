package pe.edu.upc.easysneaker.features.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import pe.edu.upc.easysneaker.core.designsystem.theme.EasySneakerTheme
import pe.edu.upc.easysneaker.features.home.domain.Product

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onProductClick: (Product) -> Unit
) {
    val state = viewModel.uiState.collectAsState().value

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when {
            state.products.isNotEmpty() -> {
                ProductList(
                    products = state.products,
                    onProductClick = onProductClick
                )
            }

            state.isLoading -> {
                CircularProgressIndicator()
            }

            else -> {
                Text(text = "No products found")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    EasySneakerTheme(dynamicColor = false) {
        HomeScreen {}
    }
}