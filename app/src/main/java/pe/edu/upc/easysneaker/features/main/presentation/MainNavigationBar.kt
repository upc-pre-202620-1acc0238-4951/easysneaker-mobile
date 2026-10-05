package pe.edu.upc.easysneaker.features.main.presentation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController


@Composable
fun MainNavigationBar(
    navController: NavHostController
) {

    val selectedIndex = rememberSaveable {
        mutableIntStateOf(0)
    }
    NavigationBar {
        NavigationItem.tabs.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedIndex.intValue == index,
                onClick = {
                    selectedIndex.intValue = index

                    navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(item.title)
                }
            )
        }
    }
}