package app.allever.android.learning.project.compose.module.wechat.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import app.allever.android.learning.project.compose.module.wechat.data.Chat
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun WeViewPager(list: List<Chat>, pagerState: PagerState, modifier: Modifier, onPageChanged:(Int) -> Unit): Modifier {
    //页面切换监听
    LaunchedEffect(pagerState) {
        // Collect from the pager state a snapshotFlow reading the currentPage
        snapshotFlow { pagerState.currentPage }.collect { page ->
            onPageChanged(page)
        }
    }

    //https://google.github.io/accompanist/pager/
    HorizontalPager(4, state = pagerState, modifier = modifier) { page ->
        when (page) {
            0 -> ChatList(list)
            1 -> {
                Box(modifier.fillMaxSize())
            }
            2 -> {
                Box(modifier.fillMaxSize())
            }
            3 -> {
                Box(modifier.fillMaxSize())
            }
        }
    }
    return modifier
}

