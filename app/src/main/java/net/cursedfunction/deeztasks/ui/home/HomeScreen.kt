package net.cursedfunction.deeztaskz.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import net.cursedfunction.deeztaskz.ui.theme.DeezTaskzTheme

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen(
    screenState: HomeScreenState,
    onAddNewTaskAction: () -> Unit = {},
    onEditAction: (TaskItem) -> Unit = {},
    onDeleteAction: (TaskItem) -> Unit = {},
    onCompleteAction: (TaskItem) -> Unit = {}
) {
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var showBottomSheet by rememberSaveable { mutableStateOf(false) }
    var bottomSheetData: BottomSheetData? by remember { mutableStateOf(null) }

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
        HomeScreenBottomSheet(
            state = bottomSheetState,
            showBottomSheet = showBottomSheet,
            data = bottomSheetData,
            dismissBottomSheet = { taskItem ->
                taskItem?.let(onEditAction)
                bottomSheetData = null
                showBottomSheet = false
            }
        )
        
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

@PreviewLightDark
@Composable
private fun HomeScreenPreview() {
    DeezTaskzTheme {
        Surface {
            HomeScreen(
                screenState = HomeScreenState(
                    title = "DeezTaskz",
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