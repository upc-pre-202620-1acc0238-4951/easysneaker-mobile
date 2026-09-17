package pe.edu.upc.easysneaker.features.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil3.compose.AsyncImage
import pe.edu.upc.easysneaker.core.arrowBack

@OptIn(ExperimentalMaterial3Api::class)
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

    Scaffold(topBar = {
        TopAppBar(title = { }, navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(imageVector = arrowBack, contentDescription = "back")
            }
        })
    }) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (uiState) {
                is ProductDetailUiState.Loading -> {
                    CircularProgressIndicator()
                }

                is ProductDetailUiState.Success -> {
                    Column(modifier = Modifier.fillMaxSize()) {
                        AsyncImage(
                            model = uiState.product.imageUrl,
                            contentDescription = uiState.product.name,
                            modifier = Modifier
                                .fillMaxHeight(0.25f)
                                .fillMaxWidth()
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
}