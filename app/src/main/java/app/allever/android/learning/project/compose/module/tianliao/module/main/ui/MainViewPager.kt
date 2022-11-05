package app.allever.android.learning.project.compose.module.tianliao.module.main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainViewPager(
    pagerState: PagerState,
    modifier: Modifier,
    onPageChanged: (Int) -> Unit
): Modifier {
    //页面切换监听
    LaunchedEffect(pagerState) {
        // Collect from the pager state a snapshotFlow reading the currentPage
        snapshotFlow { pagerState.currentPage }.collect { page ->
            onPageChanged(page)
        }
    }

    HorizontalPager(count = 4, modifier, pagerState) { page ->
        when (page) {
            0 -> {
                Box(Modifier.fillMaxSize()) {
                    Text("聊群")
                }
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

    return modifier
}