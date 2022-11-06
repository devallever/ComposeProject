package app.allever.android.learning.project.compose.module.tianliao.module.voiceroom.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import app.allever.android.learning.project.compose.R
import app.allever.android.learning.project.compose.module.tianliao.module.common.ui.ViewPager
import app.allever.android.learning.project.compose.module.tianliao.module.voiceroom.viewmodel.HomeVoiceRoomViewModel
import app.allever.android.lib.core.ext.toast
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VoiceRoomRecommendListPage(lifecycleOwner: LifecycleOwner) {

    //嵌套滚动,不知在哪个版本
    //Modifier.nestedScroll(ConsumeFlingNestedScrollConnection(true, false), null)
    Column() {
        Banner(lifecycleOwner)

        val list = listOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            Modifier
                .weight(1f)
                .padding(top = 10.dp),
            contentPadding = PaddingValues(10.dp, 0.dp, 10.dp, 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            itemsIndexed(list) { index, item ->
                Box(
                    Modifier
                        .background(color = Color.Gray, shape = RoundedCornerShape(10.dp))
                        .height(160.dp)
                        .clickable {
                            toast(index.toString())
                        }

                ) {
                    Text(text = "hello", Modifier.fillMaxSize())
                }
            }
        }
    }


}

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalPagerApi::class)
@Composable
private fun Banner(lifecycleOwner: LifecycleOwner) {
    val viewModel: HomeVoiceRoomViewModel = viewModel()
    Box(
        Modifier
            .fillMaxWidth()
            .height(88.dp)
            .padding(horizontal = 10.dp)
            .background(color = Color(0x80FF0000), shape = RoundedCornerShape(10.dp))
    ) {

        ViewPager(
            count = 3,
            pagerState = rememberPagerState(),
            modifier = Modifier.fillMaxSize(),
            onPageChanged = {
                viewModel.bannerSelectIndex = it
            }) { page ->
            Image(
                painter = painterResource(R.drawable.avatar_me),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp))
            )
        }

        Row(Modifier.align(Alignment.BottomCenter)) {
            val boxModifier = Modifier
                .height(10.dp)
                .width(38.dp)
                .padding(4.dp)
            Box(
                boxModifier
                    .background(color = if (viewModel.bannerSelectIndex == 0) Color.White else Color.Gray)
            ) {

            }
            Box(
                boxModifier.background(color = if (viewModel.bannerSelectIndex == 1) Color.White else Color.Gray)
            ) {

            }
            Box(
                boxModifier
                    .background(color = if (viewModel.bannerSelectIndex == 2) Color.White else Color.Gray)
            ) {

            }
        }

    }
}