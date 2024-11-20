package org.sopt.linkareer.feature.dummy

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.linkareer.core.designsystem.LINKareerTheme
import org.sopt.linkareer.core.state.UiState
import org.sopt.linkareer.domain.model.DummyEntity

@Composable
fun DummyScreen(
    viewModel: DummyViewModel = hiltViewModel(),
) {
    val lifecycleOwner = LocalLifecycleOwner.current

    val state by viewModel.state.collectAsStateWithLifecycle(lifecycleOwner = lifecycleOwner)

    LaunchedEffect(key1 = true) {
        viewModel.getDummyList(2)
    }

    when (state.followers) {
        is UiState.Empty -> {}
        is UiState.Loading -> {}
        is UiState.Failure -> {}
        is UiState.Success -> {
            ShowList(dummyList = (state.followers as UiState.Success<List<DummyEntity>>).data)
        }
    }
}

@Composable
fun ShowList(
    dummyList: List<DummyEntity>,
) {
    Column {
        LazyColumn {
            items(dummyList.size) { index ->
                Text(
                    text = dummyList[index].firstName,
                )
            }
        }

        Text(
            text =
                "국가는 농수산물의 수급균형과 유통구조의 개선에 노력하여 가격안정을 도모함으로써 농·어민의 이익을 보호한다. 공무원은 국민전체에 대한 봉사자이며, 국민에 대하여 책임을 진다.\n" +
                    "\n" +
                    "대한민국은 국제평화의 유지에 노력하고 침략적 전쟁을 부인한다. 교육의 자주성·전문성·정치적 중립성 및 대학의 자율성은 법률이 정하는 바에 의하여 보장된다.",
            color = LINKareerTheme.colors.blue,
            style = LINKareerTheme.typography.title4B15,
        )
        Text(
            text =
                "국가는 농수산물의 수급균형과 유통구조의 개선에 노력하여 가격안정을 도모함으로써 농·어민의 이익을 보호한다. 공무원은 국민전체에 대한 봉사자이며, 국민에 대하여 책임을 진다.\n" +
                    "\n" +
                    "대한민국은 국제평화의 유지에 노력하고 침략적 전쟁을 부인한다. 교육의 자주성·전문성·정치적 중립성 및 대학의 자율성은 법률이 정하는 바에 의하여 보장된다.",
            color = LINKareerTheme.colors.yellow,
            style = LINKareerTheme.typography.body4B12,
        )
    }
}
