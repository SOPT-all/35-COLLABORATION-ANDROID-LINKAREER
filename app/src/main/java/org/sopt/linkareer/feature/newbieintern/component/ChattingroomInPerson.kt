package org.sopt.linkareer.feature.newbieintern.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import coil3.compose.AsyncImage
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.component.chip.CommunityNameChip
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme

@Composable
fun ChattingRoomInPerson(
    image: Int,
    categories: List<String?>,
    company: String,
    chattingTitle: String,
    participationPerson: Int,
    isInPersonConversation: Boolean = true,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(331 / 94f)
            .clickable { onClick() }
            .border(
                border = BorderStroke(width = 1.dp, color = LINKareerTheme.colors.gray300),
                shape = RoundedCornerShape(size = 8.dp)
            )
            .background(color = LINKareerTheme.colors.gray100, shape = RoundedCornerShape(size = 8.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier = Modifier
                .background(color = LINKareerTheme.colors.white)
                .padding(horizontal = 12.dp)
        )
        Spacer(Modifier.width(12.dp))
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            CategoryChips(categories = categories)
            Text(
                text = company,
                style = LINKareerTheme.typography.body11M10,
                color = LINKareerTheme.colors.gray600
            )
            Text(
                text = chattingTitle,
                modifier = Modifier.padding(bottom = 4.dp),
                maxLines = 1,
                minLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = LINKareerTheme.typography.body3B13,
                color = LINKareerTheme.colors.gray900
            )
            Row(
                modifier = Modifier
                    .aspectRatio(119 / 12f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.chatting_room_in_preson, participationPerson),
                    style = LINKareerTheme.typography.label5M8,
                    color = LINKareerTheme.colors.gray600
                )
                VerticalDivider(
                    thickness = 1.dp,
                    color = LINKareerTheme.colors.gray300,
                    modifier = Modifier
                        .padding(horizontal = 6.dp)
                        .aspectRatio(1 / 12f)
                )
                if (isInPersonConversation) {
                    InPersonBadge()
                }
            }
        }
    }
}

@Composable
fun CategoryChips(categories: List<String?>) {
    Row(
        modifier = Modifier.padding(bottom = 4.dp),
        horizontalArrangement = Arrangement.Absolute.spacedBy(6.dp)
    ) {
        categories.filterNotNull().forEach { category ->
            CommunityNameChip(category)
        }
    }
}

@Composable
fun InPersonBadge() {
    Row {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_checkbadge_home_inperson_12),
            contentDescription = null,
        )
        Text(
            text = stringResource(R.string.chatting_room_in_preson_conversation),
            modifier = Modifier.padding(start = 2.dp),
            style = LINKareerTheme.typography.label5M8,
            color = LINKareerTheme.colors.blue
        )
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
