package app.allever.android.learning.project.compose.module.tianliao.module.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import app.allever.android.learning.project.compose.module.tianliao.module.main.viewmodel.TLMainViewModel
import app.allever.android.lib.core.ext.toast
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainPage(lifecycleOwner: LifecycleOwner) {
    Column() {
        val viewModel: TLMainViewModel = viewModel()
        //顶部ViewPager
        val pagerState = rememberPagerState(0)
        MainViewPager(pagerState, Modifier.weight(1f)) {
            viewModel.bottomSelectedIndex = it
        }
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