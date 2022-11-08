package app.allever.android.learning.project.compose.module.tianliao.module.voiceroom.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import app.allever.android.learning.project.compose.R
import app.allever.android.learning.project.compose.module.tianliao.module.common.ui.ViewPager
import app.allever.android.learning.project.compose.module.tianliao.module.voiceroom.viewmodel.HomeVoiceRoomViewModel
import app.allever.android.learning.project.compose.module.tianliao.module.voiceroom.viewmodel.VoiceRoomListViewModel
import app.allever.android.lib.core.ext.toast
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VoiceRoomRecommendListPage(lifecycleOwner: LifecycleOwner) {

    val viewModel: VoiceRoomListViewModel = viewModel()
    //嵌套滚动,不知在哪个版本
    //Modifier.nestedScroll(ConsumeFlingNestedScrollConnection(true, false), null)
    Column() {
        Banner(lifecycleOwner)

        LazyVerticalGrid(
            GridCells.Fixed(2),
            Modifier
                .weight(1f)
                .padding(top = 10.dp),
            contentPadding = PaddingValues(10.dp, 0.dp, 10.dp, 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            itemsIndexed(viewModel.recommendList) { index, item ->
                Box(
                    Modifier
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .height(155.dp)
                        .clickable {
                            toast(index.toString())
                        }

                ) {
                    //背景
//                    Image(
//                        painterResource(item.avatarRes),
//                        contentDescription = "",
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .blur(1.dp, BlurredEdgeTreatment.Unbounded)
//                            .clip(RoundedCornerShape(10.dp)), contentScale = ContentScale.Crop
//                    )


                    //话题
                    Text(
                        text = item.topic,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                            .align(Alignment.TopStart),
                        fontSize = 17.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                    //底部
                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(10.dp)
                    ) {


                        //头像
                        Image(
                            painterResource(item.avatarRes),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(42.dp)
                                .clip(CircleShape)
                        )

                        //加载网络图片
//                        AsyncImage(
//                            model = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic_source%2F81%2Ff8%2Fc2%2F81f8c2d8bea55c7b77ba0c4446f2e6a1.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1670503104&t=7dec4bfe2fb8646de9f063bc6aa92e0d",
//                            contentDescription = "",
//                            contentScale = ContentScale.Crop,
//                            modifier = Modifier
//                                .size(42.dp)
//                                .clip(CircleShape)
//                        )


                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = item.nickname,
                                fontSize = 12.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(horizontal = 4.dp)
                            )

                            Box(modifier = Modifier.padding(4.dp)) {

                                Row() {
                                    LazyRow() {
                                        itemsIndexed(item.memberResList) { index, resItem ->
                                            Image(
                                                painterResource(resItem),
                                                contentDescription = "",
                                                modifier = Modifier
                                                    .size(18.dp)
                                                    .clip(CircleShape)
                                                    .padding(0.dp, 0.dp, 0.dp, 0.dp),
                                                contentScale = ContentScale.Crop
                                            )
                                        }
                                    }

                                    Row(
                                        modifier = Modifier
                                            .height(15.dp)
                                            .width(50.dp)
                                            .background(
                                                color = Color(0x80000000),
                                                shape = RoundedCornerShape(45.dp)
                                            )
                                            .align(Alignment.CenterVertically),
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        Image(
                                            painterResource(R.drawable.ic_fire),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .width(9.dp)
                                                .height(9.dp)
                                                .align(Alignment.CenterVertically)
                                        )

                                        Text(
                                            item.hot,
                                            color = Color.White,
                                            fontSize = 9.sp,
                                            modifier = Modifier
                                                .align(Alignment.CenterVertically)
                                                .padding(horizontal = 2.dp)
                                        )
                                    }
                                }

                            }
                        }

                    }
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