package app.allever.android.learning.project.compose.module.wechat.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import app.allever.android.learning.project.compose.ui.theme.ComposeProjectTheme

class WechatComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {

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