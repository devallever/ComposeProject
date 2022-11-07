package app.allever.android.learning.project.compose.module.tianliao.module.voiceroom.viewmodel

import androidx.lifecycle.ViewModel
import app.allever.android.learning.project.compose.R
import app.allever.android.learning.project.compose.module.tianliao.module.voiceroom.data.VoiceRoomListItem

class VoiceRoomListViewModel : ViewModel() {
    val recommendList = mutableListOf<VoiceRoomListItem>()

    init {
        initRecommendListData()
    }

    private fun initRecommendListData() {
        for (i in 0..19) {
            val item = VoiceRoomListItem("Topic $i", R.drawable.avatar_me, "Nickname $i", "$i")
            val memberResList = mutableListOf<Int>()
            for (j in 0..3) {
                memberResList.add(R.drawable.avatar_me)
            }
            item.memberResList.addAll(memberResList)
            recommendList.add(item)
        }
    }
}