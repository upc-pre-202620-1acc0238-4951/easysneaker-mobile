package pe.edu.upc.easysneaker

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.easysneaker.core.theme.EasySneakerTheme

@Composable
fun ProductList() {

    val products = listOf(
        "Product 1",
        "Product 2",
        "Product 3",
        "Product 4",
        "Product 5"
    )
    LazyColumn {
        items(products) { product ->
            Card(modifier = Modifier.padding(8.dp)) {
                Text(product)
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