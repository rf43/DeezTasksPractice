package net.cursedfunction.deeztasks.ui.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreenTopBar(
    title: String
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surfaceContainer),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    style = MaterialTheme.typography.titleLarge,
                    text = title
                )
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    imageVector = Icons.Filled.Face,
                    tint = MaterialTheme.colorScheme.tertiary,
                    contentDescription = null
                )
            }
        }
    )
}