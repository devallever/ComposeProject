package app.allever.android.learning.project.compose.module.tianliao.module.main.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TLMainViewModel : ViewModel() {
    var bottomSelectedIndex by mutableStateOf(0)
}