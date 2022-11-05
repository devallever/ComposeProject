package app.allever.android.learning.project.compose.module.tianliao.module.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import app.allever.android.learning.project.compose.module.tianliao.module.main.ui.MainPage
import app.allever.android.learning.project.compose.module.tianliao.module.main.viewmodel.TLMainViewModel
import app.allever.android.learning.project.compose.ui.theme.ComposeProjectTheme
import com.google.accompanist.pager.ExperimentalPagerApi

class TLMainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeProjectTheme {
                val viewModel: TLMainViewModel = viewModel()
                MainPage(this)
            }
        }
    }
}