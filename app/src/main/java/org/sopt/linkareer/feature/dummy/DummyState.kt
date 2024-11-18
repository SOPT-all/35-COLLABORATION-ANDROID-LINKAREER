package org.sopt.linkareer.feature.dummy

import org.sopt.linkareer.core.state.UiState
import org.sopt.linkareer.domain.model.DummyEntity

data class DummyState(
    var followers: UiState<List<DummyEntity>> = UiState.Loading,
)
