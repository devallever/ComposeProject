package app.allever.android.learning.project.compose.module.wechat.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import app.allever.android.learning.project.compose.module.wechat.ui.main.HomePage
import app.allever.android.learning.project.compose.ui.theme.ComposeProjectTheme


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