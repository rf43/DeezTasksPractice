package net.cursedfunction.deeztasks.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreenRoute(
    viewModel: HomeScreenViewModel
) {
    Surface {
        HomeScreen()
    }
}

@Composable
private fun HomeScreen() {
    Column {
        Text(text = "Home Screen")
    }
}