package pe.edu.upc.easysneaker.features.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import pe.edu.upc.easysneaker.features.home.domain.Product

@Composable
fun ProductDetailScreen(
    modifier: Modifier = Modifier,
    product: Product,
    onBackClick: () -> Unit
) {
    Scaffold { paddingValues ->
        Column(modifier = modifier.padding(paddingValues)) {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.name



            )
            Text(text = product.name)

            Text(text = product.description)
        }

    }
}