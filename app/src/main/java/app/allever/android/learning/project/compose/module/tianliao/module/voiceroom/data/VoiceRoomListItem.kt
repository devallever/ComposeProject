package app.allever.android.learning.project.compose.module.tianliao.module.voiceroom.data

data class VoiceRoomListItem(
    val topic: String,
    val avatarRes: Int,
    val nickname: String,
    val hot: String,
) {
    val avatar: String = ""
    val id: String = ""
    val memberList = mutableListOf<String>()
    val memberResList = mutableListOf<Int>()
}