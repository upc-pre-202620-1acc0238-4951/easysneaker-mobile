package pe.edu.upc.easysneaker.features.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.easysneaker.core.theme.EasySneakerTheme
import pe.edu.upc.easysneaker.features.home.domain.Product

@Composable
fun ProductList() {


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
                        contentDescription = product.name,
                        modifier = Modifier.fillMaxWidth().height(200.dp)
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