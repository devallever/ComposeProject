package app.allever.android.learning.project.compose.module.wechat.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import app.allever.android.lib.core.helper.CoroutineHelper
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomePage(lifecycleOwner: LifecycleOwner, viewModel: WeViewModel) {
    //纵向
    Column {
        //顶部ViewPager
        val pagerState = rememberPagerState(0)
        WeViewPager(viewModel.chats, pagerState = pagerState, Modifier.weight(1f)) {
            viewModel.selectedTab = it
        }
        //底部导航栏
        BottomBar(viewModel.selectedTab) {
            viewModel.selectedTab = it
            lifecycleOwner.lifecycleScope.launch {
                pagerState.scrollToPage(it)

            }
        }
    }
}