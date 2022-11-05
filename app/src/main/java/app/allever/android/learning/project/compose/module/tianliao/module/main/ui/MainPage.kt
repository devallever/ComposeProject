package app.allever.android.learning.project.compose.module.tianliao.module.main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import app.allever.android.learning.project.compose.module.tianliao.module.common.ui.ViewPager
import app.allever.android.learning.project.compose.module.tianliao.module.main.viewmodel.TLMainViewModel
import app.allever.android.learning.project.compose.module.tianliao.module.voiceroom.ui.HomeVoiceRoomPage
import app.allever.android.lib.core.ext.toast
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainPage(lifecycleOwner: LifecycleOwner) {
    Column() {
        val viewModel: TLMainViewModel = viewModel()
        //顶部ViewPager
        val pagerState = rememberPagerState(0)
        MainViewPager(lifecycleOwner, pagerState, viewModel, Modifier.weight(1f))
        //底部导航栏
        MainBottomBar(viewModel.bottomSelectedIndex) {
            toast(it.toString())
            viewModel.bottomSelectedIndex = it
            lifecycleOwner.lifecycleScope.launch {
                pagerState.scrollToPage(it)
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun MainViewPager(
    lifecycleOwner: LifecycleOwner,
    pagerState: PagerState,
    viewModel: TLMainViewModel,
    modifier: Modifier?
) {
    ViewPager(4, ViewPager.Horizontal, pagerState, modifier ?: Modifier, onPageChanged = {
        viewModel.bottomSelectedIndex = it
    }) { page ->
        when (page) {
            0 -> {
                HomeVoiceRoomPage(lifecycleOwner)
            }
            1 -> {
                Box(Modifier.fillMaxSize()) {
                    Text("聊圈")
                }
            }
            2 -> {
                Box(Modifier.fillMaxSize()) {
                    Text("聊信")
                }
            }
            3 -> {
                Box(Modifier.fillMaxSize()) {
                    Text("我的")
                }
            }
        }
    }
}