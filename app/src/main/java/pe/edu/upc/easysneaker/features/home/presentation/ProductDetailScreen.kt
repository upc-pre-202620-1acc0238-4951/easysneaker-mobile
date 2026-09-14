package pe.edu.upc.easysneaker.features.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil3.compose.AsyncImage

@Composable
fun ProductDetailScreen(
    modifier: Modifier = Modifier,
    id: Int,
    viewModel: ProductDetailViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val uiState = viewModel.uiState.collectAsState().value

    LaunchedEffect(id) {
        viewModel.loadProduct(id)
    }

    Scaffold { paddingValues ->
        when (uiState) {
            is ProductDetailUiState.Loading -> {
                CircularProgressIndicator()
            }

            is ProductDetailUiState.Success -> {
                Column(modifier = modifier.padding(paddingValues)) {
                    AsyncImage(
                        model = uiState.product.imageUrl,
                        contentDescription = uiState.product.name
                    )
                    Text(text = uiState.product.name)
                    Text(text = uiState.product.description)
                }
            }

            is ProductDetailUiState.Error -> {
                Text(text = uiState.message)
            }

        }
    }
}