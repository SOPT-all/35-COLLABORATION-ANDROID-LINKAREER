package org.sopt.linkareer.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.core.designsystem.theme.Blue
import org.sopt.linkareer.core.designsystem.theme.Gray400

@Composable
fun HomeBannerPager(
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState { 4 }
    HorizontalPager(
        state = pagerState,
        modifier = modifier.padding(horizontal = 17.dp),
    ) {
        Box(
            modifier =
                Modifier
                    .size(width = 326.dp, height = 254.dp)
                    .background(Blue),
        )
    }
    HomeBannerPagerIndicator(pagerState)
}

@Composable
private fun HomeBannerPagerIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) Blue else Gray400
            val size = if (pagerState.currentPage == iteration) 8.dp else 6.dp
            Box(
                modifier =
                    Modifier
                        .padding(horizontal = 6.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(size),
            )
        }
    }
}
