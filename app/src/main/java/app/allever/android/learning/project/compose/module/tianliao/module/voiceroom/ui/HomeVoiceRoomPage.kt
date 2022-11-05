package app.allever.android.learning.project.compose.module.tianliao.module.voiceroom.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import app.allever.android.learning.project.compose.module.tianliao.module.common.ui.TabLayout
import app.allever.android.learning.project.compose.module.tianliao.module.voiceroom.viewmodel.HomeVoiceRoomViewModel

/**
 * 主页聊天室
 */

@Composable
fun HomeVoiceRoomPage() {
    Column(Modifier.fillMaxSize()) {
        val viewModel: HomeVoiceRoomViewModel = viewModel()
        //TopBar
        val data = listOf("推荐", "关注", "最新", "广场")
        TabLayout(data, viewModel.selectTab) {
            viewModel.selectTab = it
        }
        //ViewPager
        Box(Modifier.weight(1f)) {

        }
    }
}