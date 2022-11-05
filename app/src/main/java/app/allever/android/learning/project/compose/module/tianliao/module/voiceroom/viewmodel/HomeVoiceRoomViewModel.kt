package app.allever.android.learning.project.compose.module.tianliao.module.voiceroom.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeVoiceRoomViewModel : ViewModel() {
    var selectTab by mutableStateOf(0)
}