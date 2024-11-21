package org.sopt.linkareer.feature.chatroom.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.Blue
import org.sopt.linkareer.core.designsystem.Blue100
import org.sopt.linkareer.core.designsystem.Gray200
import org.sopt.linkareer.core.designsystem.Gray500
import org.sopt.linkareer.core.designsystem.Gray900
import org.sopt.linkareer.core.designsystem.defaultLINKareerTypography

@Composable
fun OtherUserChatProfile(
    nickName: String,
    isChecked: Boolean,
    jobCategory: String,
    imageUrl: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            //model = imageUrl, 추후 , Async 이미지로 변경
            painter = painterResource(R.drawable.img_newbie_personalitypass),
            contentDescription = stringResource(R.string.chatroom_profile_image_contentDescription),
            modifier = Modifier
                .size(27.dp)
                .clip(CircleShape),
            //error = painterResource(R.drawable.ic_checklist_person_24)
        )
        Text(
            text = nickName,
            style = defaultLINKareerTypography.body5B11,
            color = Gray900,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .padding(start = 3.dp, end = 8.dp)
        )
        if (isChecked) {
            Image(
                painter = painterResource(R.drawable.ic_checkbadge_home_inperson_16),
                contentDescription = stringResource(R.string.chatroom_check_contentDescription),
                modifier = Modifier.padding(end = 2.dp)
            )
        }
        ChatJobChip(
            job = jobCategory,
            textColor = if (isChecked) Blue else Gray200,
            backGroundColor = if (isChecked) Blue100 else Gray500
        )
    }
}