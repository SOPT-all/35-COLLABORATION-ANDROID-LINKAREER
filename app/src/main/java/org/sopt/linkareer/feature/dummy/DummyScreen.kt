package org.sopt.linkareer.feature.dummy

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
    LazyColumn {
        items(dummyList.size) { index ->
            Text(
                text = dummyList[index].firstName,
            )
        }
    }
}
