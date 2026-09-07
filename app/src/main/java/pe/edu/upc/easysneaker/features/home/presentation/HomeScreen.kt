package pe.edu.upc.easysneaker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.easysneaker.core.theme.EasySneakerTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {

        ProductList()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    EasySneakerTheme(dynamicColor = false) {
        HomeScreen()
    }
}