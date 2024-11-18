package org.sopt.linkareer.feature.dummy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.linkareer.core.state.UiState
import org.sopt.linkareer.domain.repository.DummyRepository
import javax.inject.Inject

@HiltViewModel
class DummyViewModel @Inject constructor(
    private val dummyRepository: DummyRepository,
) : ViewModel() {
    var state: MutableStateFlow<DummyState> =
        MutableStateFlow(DummyState())
        private set

    fun getDummyList(page: Int) {
        viewModelScope.launch {
            dummyRepository.getDummyUserList(page = page)
                .onSuccess { response ->
                    state.update {
                        it.copy(
                            followers = UiState.Success(response),
                        )
                    }
                }
        }
    }
}
