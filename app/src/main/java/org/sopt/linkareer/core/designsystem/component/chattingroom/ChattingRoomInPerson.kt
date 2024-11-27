package org.sopt.linkareer.core.designsystem.component.chattingroom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.component.chip.CommunityNameChip
import org.sopt.linkareer.core.designsystem.component.text.TextWithIcon
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme
import org.sopt.linkareer.core.extension.noRippleClickable

@Composable
fun ChattingRoomInPerson(
    image: Int,
    categories: List<String?>,
    company: String,
    chattingTitle: String,
    participationPerson: Int,
    onClick: () -> Unit,
    isInPersonConversation: Boolean = true,
) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .noRippleClickable { onClick() }
                .border(
                    border = BorderStroke(width = 1.dp, color = LINKareerTheme.colors.gray300),
                    shape = RoundedCornerShape(size = 8.dp),
                )
                .background(color = LINKareerTheme.colors.gray100, shape = RoundedCornerShape(size = 8.dp))
                .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier =
                Modifier
                    .background(
                        color = LINKareerTheme.colors.white,
                        shape = RoundedCornerShape(size = 4.dp),
                    )
                    .padding(horizontal = 12.dp)
                    .height(70.dp)
                    .aspectRatio(1f),
        )
        Spacer(Modifier.width(12.dp))
        Column(
            modifier =
                Modifier
                    .weight(1f),
        ) {
            CategoryChips(categories = categories)
            Text(
                text = company,
                style = LINKareerTheme.typography.body11M10,
                color = LINKareerTheme.colors.gray600,
            )
            Text(
                text = chattingTitle,
                modifier = Modifier.padding(bottom = 4.dp),
                maxLines = 1,
                minLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = LINKareerTheme.typography.body3B13,
                color = LINKareerTheme.colors.gray900,
            )
            Row(
                modifier = Modifier.height(IntrinsicSize.Min),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(R.string.chatting_room_in_preson, participationPerson),
                    style = LINKareerTheme.typography.label5M8,
                    color = LINKareerTheme.colors.gray600,
                )
                VerticalDivider(
                    modifier =
                        Modifier
                            .padding(horizontal = 6.dp)
                            .fillMaxHeight(),
                    thickness = 1.dp,
                    color = LINKareerTheme.colors.gray300,
                )
                if (isInPersonConversation) {
                    TextWithIcon(text = stringResource(R.string.chatting_room_in_preson_conversation))
                }
            }
        }
    }
}

@Composable
fun CategoryChips(categories: List<String?>) {
    Row(
        modifier = Modifier.padding(bottom = 4.dp),
        horizontalArrangement = Arrangement.Absolute.spacedBy(4.dp),
    ) {
        categories.filterNotNull().forEach { category ->
            CommunityNameChip(category)
        }
    }
}

@Preview
@Composable
fun ChattingRoomInPersonPreview() {
    LINKareerAndroidTheme {
        ChattingRoomInPerson(
            image = R.drawable.img_hotofficial_lalasweet,
            categories = listOf("취업", "면접", "대기업"),
            company = "삼성전자",
            chattingTitle = "2024년 신입사원 면접 준비방",
            participationPerson = 25,
            isInPersonConversation = true,
            onClick = { },
        )
    }
}
