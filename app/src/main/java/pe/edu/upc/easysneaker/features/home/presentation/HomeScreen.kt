package pe.edu.upc.easysneaker.features.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import pe.edu.upc.easysneaker.core.theme.EasySneakerTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
) {
    val products = viewModel.uiState.collectAsState().value.products

    Column(modifier = modifier.fillMaxSize()) {

        ProductList(products = products)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    EasySneakerTheme(dynamicColor = false) {
        HomeScreen()
    }
}