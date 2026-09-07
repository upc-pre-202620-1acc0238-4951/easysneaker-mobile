package pe.edu.upc.easysneaker.features.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.easysneaker.core.theme.EasySneakerTheme
import pe.edu.upc.easysneaker.features.home.domain.Product

@Composable
fun ProductList() {

    val products = listOf(
        Product(
            id = 1,
            name = "Nike Air Motion",
            price = 122.64,
            rating = 4.9,
            imageUrl = "https://i.imgur.com/E8ZBAnC.png"
        ),
        Product(
            id = 2,
            name = "ASICS Velocity Pro",
            price = 106.64,
            rating = 4.8,
            imageUrl = "https://i.imgur.com/Uh1Jye7.png"
        ),
        Product(
            id = 3,
            name = "Adidas RunBoost X",
            price = 93.31,
            rating = 4.6,
            imageUrl = "https://i.imgur.com/1yfHnqw.png"
        )
    )
    LazyColumn {
        items(products) { product ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    AsyncImage(
                        model = product.imageUrl,
                        contentDescription = product.name
                    )
                    Text(product.name, fontWeight = FontWeight.Bold)
                    Text("${product.rating}")
                    Text("$ ${product.price}")
                }

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProductListPreview() {
    EasySneakerTheme {
        ProductList()
    }
}