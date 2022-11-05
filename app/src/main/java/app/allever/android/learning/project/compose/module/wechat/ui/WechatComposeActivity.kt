package app.allever.android.learning.project.compose.module.wechat.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import app.allever.android.learning.project.compose.module.wechat.data.Chat
import app.allever.android.learning.project.compose.ui.theme.ComposeProjectTheme
import app.allever.android.lib.core.ext.toast
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
class WechatComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: WeViewModel = viewModel()
            ComposeProjectTheme {
                //纵向
                Column {
                    val pagerState = rememberPagerState(0)
                    WeViewPager(viewModel.chats, pagerState = pagerState, Modifier.weight(1f)) {
                        viewModel.selectedTab = it
                    }
                    //底部导航栏
                    BottomBar(viewModel.selectedTab) {
                        viewModel.selectedTab = it
                        lifecycleScope.launch {
                            pagerState.scrollToPage(it)
                        }
                    }
                }
            }
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, WechatComposeActivity::class.java)
            context.startActivity(intent)
        }
    }
}

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

