package net.cursedfunction.deeztasks.ui.home

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
            title = "DeezTasks"
        )
    }
}