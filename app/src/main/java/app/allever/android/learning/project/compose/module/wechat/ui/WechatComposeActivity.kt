package app.allever.android.learning.project.compose.module.wechat.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import app.allever.android.learning.project.compose.ui.theme.ComposeProjectTheme

class WechatComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: WeViewModel = viewModel()
            ComposeProjectTheme {
                //纵向
                Column {
                    Box(Modifier.weight(1f))
                    //底部导航栏
                    BottomBar(viewModel.selectedTab) {
                        viewModel.selectedTab = it
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