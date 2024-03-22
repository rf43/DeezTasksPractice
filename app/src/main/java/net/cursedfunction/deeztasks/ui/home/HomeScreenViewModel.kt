package net.cursedfunction.deeztasks.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class TaskItem(
    val id: Int,
    val title: String = "",
    val description: String = "",
    val isCompleted: Boolean = false
)

data class HomeScreenState(
    val title: String = "",
    val taskItems: List<TaskItem> = emptyList()
)

class HomeScreenViewModel : ViewModel() {
    private val _homeScreenState = MutableStateFlow(HomeScreenState())
    val homeScreenState: StateFlow<HomeScreenState>
        get() = _homeScreenState

    init {
        _homeScreenState.value = HomeScreenState(
            title = "DeezTasks",
            taskItems = createTaskItems()
        )
    }

    private fun createTaskItems(): List<TaskItem> {
        val taskItems = mutableListOf<TaskItem>()
        for (i in 0..40) {
            taskItems.add(
                TaskItem(
                    id = i,
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
                    isCompleted = i % 2 == 0
                )
            )
        }
        return taskItems
    }

    fun addNewTask() {
        Log.d("RF43", "addNewTask")
    }

    fun editTask(taskItem: TaskItem) {
        Log.d("RF43", "editTask: $taskItem")
    }

    fun deleteTask(taskItem: TaskItem) {
        Log.d("RF43", "deleteTask: $taskItem")
    }

    fun completeTask(taskItem: TaskItem) {
        Log.d("RF43", "completeTask: $taskItem")
    }
}