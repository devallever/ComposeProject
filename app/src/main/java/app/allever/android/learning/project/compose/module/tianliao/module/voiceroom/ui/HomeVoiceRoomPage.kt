package app.allever.android.learning.project.compose.module.tianliao.module.voiceroom.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import app.allever.android.learning.project.compose.R
import app.allever.android.learning.project.compose.module.tianliao.module.common.ui.TabLayout
import app.allever.android.learning.project.compose.module.tianliao.module.common.ui.ViewPager
import app.allever.android.learning.project.compose.module.tianliao.module.voiceroom.viewmodel.HomeVoiceRoomViewModel
import app.allever.android.lib.core.ext.toast
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

/**
 * 主页聊天室
 */

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeVoiceRoomPage(lifecycleOwner: LifecycleOwner) {
    Column(Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(0)
        val viewModel: HomeVoiceRoomViewModel = viewModel()
        val data = listOf("推荐", "关注")
        Box {
            //TopBar
            TabLayout(data, viewModel.selectTab) {
                viewModel.selectTab = it
                lifecycleOwner.lifecycleScope.launch {
                    pagerState.scrollToPage(it)
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(horizontal = 4.dp)
            ) {
                Box(
                    Modifier
                        .size(48.dp)
                        .clickable {
                            toast("搜索")
                        }) {
                    Icon(
                        painterResource(R.drawable.ic_search),
                        "搜索",
                        Modifier
                            .size(48.dp)
                            .padding(13.dp),
                        tint = Color.Black,

                        )
                }

                Box(
                    Modifier
                        .size(48.dp)
                        .clickable {
                            toast("开播")
                        }) {
                    Icon(
                        painterResource(R.drawable.ic_living),
                        "开播",
                        Modifier
                            .size(48.dp)
                            .padding(13.dp),
                        tint = Color.Black,

                        )
                }
            }
        }

        //ViewPager
        ViewPager(
            data.size,
            ViewPager.Horizontal,
            pagerState,
            Modifier.weight(1f),
            onPageChanged = {
                viewModel.selectTab = it
            }) { page ->

            when (page) {
                0 -> VoiceRoomRecommendListPage(lifecycleOwner)
                1 -> Text(data[page])
            }
        }
    }
}