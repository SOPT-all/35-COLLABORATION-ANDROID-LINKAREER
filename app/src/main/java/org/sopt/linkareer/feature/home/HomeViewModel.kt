package org.sopt.linkareer.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.linkareer.R
import org.sopt.linkareer.core.state.UiState
import org.sopt.linkareer.domain.model.BannerEntity
import org.sopt.linkareer.domain.model.OfficialEntity
import org.sopt.linkareer.domain.repository.HomeRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
) : ViewModel() {
    var homeState: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
        private set

    fun getPosts(category: String) {
        viewModelScope.launch {
            homeRepository.getPosts(category)
                .onSuccess { posts ->
                    homeState.update {
                        it.copy(
                            postList = UiState.Success(posts),
                        )
                    }
                }
        }
    }
}

fun getOfficialList(): List<OfficialEntity> =
    listOf(
        OfficialEntity(
            id = 1,
            imageUrl = "https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-before-qa1.png",
            title = "[LG CNS][인턴_학사] 2025년 동계 DX Core 인턴 어쩌구 ..",
            companyName = "LG CNS",
            tag = "정규직 1차 면접 프리패스",
            views = 20481,
            comments = 342,
            dDay = "D-7",
            isBookmarked = true,
        ),
        OfficialEntity(
            id = 2,
            imageUrl = "https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-before-qa1.png",
            title = "[LG CNS][인턴_학사] 2025년 동계 DX Core 인턴 어쩌구 ..",
            companyName = "LG CNS",
            tag = "정규직 1차 면접 프리패스",
            views = 20481,
            comments = 342,
            dDay = "D-7",
            isBookmarked = true,
        ),
        OfficialEntity(
            id = 3,
            imageUrl = "https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-before-qa1.png",
            title = "[LG CNS][인턴_학사] 2025년 동계 DX Core 인턴 어쩌구 ..",
            companyName = "LG CNS",
            tag = "정규직 1차 면접 프리패스",
            views = 20481,
            comments = 342,
            dDay = "D-7",
            isBookmarked = true,
        ),
        OfficialEntity(
            id = 4,
            imageUrl = "https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-before-qa1.png",
            title = "[LG CNS][인턴_학사] 2025년 동계 DX Core 인턴 어쩌구 ..",
            companyName = "LG CNS",
            tag = "정규직 1차 면접 프리패스",
            views = 20481,
            comments = 342,
            dDay = "D-7",
            isBookmarked = true,
        ),
        OfficialEntity(
            id = 5,
            imageUrl = "https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-before-qa1.png",
            title = "[LG CNS][인턴_학사] 2025년 동계 DX Core 인턴 어쩌구 ..",
            companyName = "LG CNS",
            tag = "정규직 1차 면접 프리패스",
            views = 20481,
            comments = 342,
            dDay = "D-7",
            isBookmarked = true,
        ),
        OfficialEntity(
            id = 6,
            imageUrl = "https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-before-qa1.png",
            title = "[LG CNS][인턴_학사] 2025년 동계 DX Core 인턴 어쩌구 ..",
            companyName = "LG CNS",
            tag = "정규직 1차 면접 프리패스",
            views = 20481,
            comments = 342,
            dDay = "D-7",
            isBookmarked = true,
        ),
    )

fun getBannerList(): List<BannerEntity> =
    listOf(
        BannerEntity(
            bannerImage = R.drawable.img_mainbanner_1,
            title = "SYNC 아카데미 6기 모집 (~11/18(월) 오전 11시 부터 모집 시작",
            companyName = "SAP Korea",
            tag = "1차 서류 프리패스",
            views = 2814,
            comments = 0,
            dDay = "D-14",
            isBookmarked = false,
        ),
        BannerEntity(
            bannerImage = R.drawable.img_mainbanner_2,
            title = "2025년 Sunny School 4기 모집",
            companyName = "행복나눔재단",
            tag = "활동기간 연구실 제공",
            views = 9894,
            comments = 16,
            dDay = "D-10",
            isBookmarked = false,
        ),
        BannerEntity(
            bannerImage = R.drawable.img_mainbanner_3,
            title = "제3회 대한민국 디지털 인재 양성 프로젝트 IT;s DGB, iM Challenger",
            companyName = "IT;s DGB, IM Challenger",
            tag = "수상자 미국 글로벌 기업 견학",
            views = 344,
            comments = 0,
            dDay = "D-38",
            isBookmarked = false,
        ),
        BannerEntity(
            bannerImage = R.drawable.img_mainbanner_4,
            title = "2024년 하반기 SK하이닉스 청년 Hy-Five 12기 모집 (~12/19)",
            companyName = "SK하이닉스 청년 Hy-Five",
            tag = "정규직 채용 연계",
            views = 9007,
            comments = 2,
            dDay = "D-35",
            isBookmarked = false,
        ),
    )
