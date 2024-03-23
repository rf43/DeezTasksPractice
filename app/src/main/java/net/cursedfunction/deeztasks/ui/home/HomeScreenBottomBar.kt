package net.cursedfunction.deeztasks.ui.home

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
internal fun HomeScreenBottomBar(
    onAddNewTaskAction: () -> Unit = {}
) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        actions = {
            // This is where we would put the actions for the bottom app bar
            // these actions will be used to navigate to different screens
        },
        floatingActionButton = {
            HomeScreenFloatingActionButton(
                onAddNewTaskAction = onAddNewTaskAction
            )
        }
    )
}