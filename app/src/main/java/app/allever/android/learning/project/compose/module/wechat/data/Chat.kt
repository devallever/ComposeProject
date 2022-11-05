package app.allever.android.learning.project.compose.module.wechat.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


data class Chat(val friend: User, var msgList: MutableList<Msg>)

data class Msg(val from: User, val text: String, val time: String) {
    var read: Boolean by mutableStateOf(true)
}