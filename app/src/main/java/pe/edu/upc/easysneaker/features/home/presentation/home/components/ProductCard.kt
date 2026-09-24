package pe.edu.upc.easysneaker.features.home.presentation.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.easysneaker.core.designsystem.icon.favorite
import pe.edu.upc.easysneaker.core.designsystem.icon.favoriteOutlined
import pe.edu.upc.easysneaker.features.home.domain.Product

@Composable
fun ProductCard(
    product: Product,
    onToggleFavorite: () -> Unit,
    onProductClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = onProductClick
    ) {
        Box {
            Column(modifier = Modifier.padding(8.dp)) {

                AsyncImage(
                    model = product.imageUrl,
                    contentDescription = product.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Text(product.name, fontWeight = FontWeight.Bold)
                Text("${product.rating}")
                Text("$ ${product.price}")
            }

            IconButton(
                onClick = onToggleFavorite,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = if (product.isFavorite) favorite else favoriteOutlined,
                    contentDescription = "favorite"
                )
            }

        }

    }
}