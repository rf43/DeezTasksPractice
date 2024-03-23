package net.cursedfunction.deeztasks.ui.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import net.cursedfunction.deeztasks.R
import net.cursedfunction.deeztasks.ui.theme.DeezTasksTheme

@Composable
fun HomeScreenRoute(
    viewModel: HomeScreenViewModel
) {
    Surface {
        HomeScreen(
            screenState = viewModel.homeScreenState.collectAsState().value,
            onAddNewTaskAction = viewModel::addNewTask,
            onEditAction = viewModel::editTask,
            onDeleteAction = viewModel::deleteTask,
            onCompleteAction = viewModel::completeTask
        )
    }
}

@Composable
private fun HomeScreen(
    screenState: HomeScreenState,
    onAddNewTaskAction: () -> Unit = {},
    onEditAction: (TaskItem) -> Unit = {},
    onDeleteAction: (TaskItem) -> Unit = {},
    onCompleteAction: (TaskItem) -> Unit = {}
) {
    Scaffold(
        topBar = {
            HomeScreenTopBar(
                title = screenState.title
            )
        },
        bottomBar = {
            HomeScreenBottomBar(
                onAddNewTaskAction = onAddNewTaskAction
            )
        }
    ) { innerPadding ->
        HomeScreenContent(
            modifier = Modifier
                .padding(innerPadding)
                .background(color = MaterialTheme.colorScheme.surface),
            screenState = screenState,
            onEditAction = onEditAction,
            onDeleteAction = onDeleteAction,
            onCompleteAction = onCompleteAction
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreenTopBar(
    title: String
) {
    TopAppBar(
        colors = topAppBarColors(containerColor = MaterialTheme.colorScheme.surfaceContainer),
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

@Composable
private fun HomeScreenBottomBar(
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

@Composable
private fun HomeScreenFloatingActionButton(
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

@Composable
private fun HomeScreenContent(
    modifier: Modifier = Modifier,
    screenState: HomeScreenState,
    onEditAction: (TaskItem) -> Unit = {},
    onDeleteAction: (TaskItem) -> Unit = {},
    onCompleteAction: (TaskItem) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val listState = rememberLazyListState()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = listState,
        ) {
            items(screenState.taskItems.size) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                        disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    onClick = {
                        // TODO: Handle card click
                        // I like the idea of expanding the card to show more detail
                        // Maybe we want to expand the card to show the detail?
                        // If we expand the card, we will need to make it stand out
                        // visually from the other cards. This could be done by
                        // slightly increasing the elevation of the card and changing
                        // the background color. Also, maybe squaring the corners of
                        // the card a bit. We could also animate the expansion of the
                        // card to make it more visually appealing.
                        Log.d("RF43", "Card $index clicked")
                    }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 16.dp)
                            .padding(start = 16.dp, end = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f),
                        ) {
                            Text(
                                style = MaterialTheme.typography.titleSmall,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                text = "${screenState.taskItems[index].title}: $index"
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                text = "${screenState.taskItems[index].description}: $index"
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Row(
                            horizontalArrangement = Arrangement.End
                        ) {
                            IconButton(
                                onClick = { onEditAction(screenState.taskItems[index]) }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_pencil),
                                    contentDescription = null
                                )
                            }
                            IconButton(
                                onClick = { onDeleteAction(screenState.taskItems[index]) }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_trash),
                                    contentDescription = null
                                )
                            }
                            IconButton(
                                onClick = { onCompleteAction(screenState.taskItems[index]) }
                            ) {
                                Icon(
                                    painter = painterResource(
                                        id = if (screenState.taskItems[index].isCompleted) {
                                            R.drawable.ic_check_circle
                                        } else {
                                            R.drawable.ic_check_circle_filled
                                        }
                                    ),
                                    contentDescription = null
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun HomeScreenPreview() {
    DeezTasksTheme {
        Surface {
            HomeScreen(
                screenState = HomeScreenState(
                    title = "DeezTasks",
                    taskItems = listOf(
                        TaskItem(
                            id = 1,
                            title = "Task",
                            description = "This is a task with a long description so that it " +
                                    "overflows and gets ellipsized. This is a task with a long " +
                                    "description so that it overflows and gets ellipsized. This " +
                                    "is a task with a long description so that it overflows and " +
                                    "gets ellipsized. This is a task with a long description so " +
                                    "that it overflows and gets ellipsized. This is a task with " +
                                    "a long description so that it overflows and gets " +
                                    "ellipsized. This is a task with a long description so that " +
                                    "it overflows and gets ellipsized. This is a task with a " +
                                    "long description so that it overflows and gets ellipsized.",
                            isCompleted = false
                        ),
                        TaskItem(
                            id = 2,
                            title = "Task",
                            description = "This is another task",
                            isCompleted = true
                        ),
                        TaskItem(
                            id = 3,
                            title = "Task",
                            description = "This is yet another task",
                            isCompleted = false
                        ),
                        TaskItem(
                            id = 1,
                            title = "Task",
                            description = "This is a task",
                            isCompleted = false
                        ),
                        TaskItem(
                            id = 2,
                            title = "Task",
                            description = "This is another task",
                            isCompleted = true
                        ),
                        TaskItem(
                            id = 3,
                            title = "Task",
                            description = "This is yet another task",
                            isCompleted = false
                        ),
                        TaskItem(
                            id = 1,
                            title = "Task",
                            description = "This is a task",
                            isCompleted = false
                        ),
                        TaskItem(
                            id = 2,
                            title = "Task",
                            description = "This is another task",
                            isCompleted = true
                        ),
                        TaskItem(
                            id = 3,
                            title = "Task",
                            description = "This is yet another task",
                            isCompleted = false
                        ),
                        TaskItem(
                            id = 1,
                            title = "Task",
                            description = "This is a task",
                            isCompleted = false
                        ),
                        TaskItem(
                            id = 2,
                            title = "Task",
                            description = "This is another task",
                            isCompleted = true
                        ),
                        TaskItem(
                            id = 3,
                            title = "Task",
                            description = "This is yet another task",
                            isCompleted = false
                        )
                    )
                )
            )
        }
    }
}