package net.cursedfunction.deeztasks.ui.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
internal fun HomeScreenFloatingActionButton(
    onAddNewTaskAction: () -> Unit = {}
) {
    FloatingActionButton(
        onClick = onAddNewTaskAction,
        containerColor = MaterialTheme.colorScheme.primary,
        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            tint = MaterialTheme.colorScheme.onPrimary,
            contentDescription = "Add new task"
        )
    }
}