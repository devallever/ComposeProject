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


class WechatComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: WeViewModel = viewModel()
            ComposeProjectTheme {
                HomePage(this, viewModel)
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