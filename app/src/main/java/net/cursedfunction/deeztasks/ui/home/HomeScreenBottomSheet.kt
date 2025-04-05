package net.cursedfunction.deeztaskz.ui.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope

internal data class BottomSheetData(
    val sheetType: Type,
    val taskItem: TaskItem
) {
    enum class Type(val value: String) {
        Add("Add Task"),
        Edit("Edit Task")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreenBottomSheet(
    state: SheetState,
    data: BottomSheetData?,
    showBottomSheet: Boolean = false,
    dismissBottomSheet: (TaskItem?) -> Unit = {},
) {
    // Early exit if the bottom sheet should not be shown
    if (!showBottomSheet || data == null) return

    val scope = rememberCoroutineScope()
}