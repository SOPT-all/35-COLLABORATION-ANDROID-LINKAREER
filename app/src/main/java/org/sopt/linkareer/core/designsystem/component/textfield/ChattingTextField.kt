package org.sopt.linkareer.core.designsystem.component.textfield

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Blue
import org.sopt.linkareer.core.designsystem.theme.Gray300
import org.sopt.linkareer.core.designsystem.theme.Gray400
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme

@Composable
fun ChattingTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LinkareerBasicTextField(
        value = value,
        inputTextColor = Gray900,
        hintText = stringResource(R.string.chatting_textfield_hint),
        hintTextColor = Gray600,
        onValueChange = onValueChange,
        inputTextStyle = LINKareerTheme.typography.body13R11,
        hintTextStyle = LINKareerTheme.typography.body13R11,
        cursorBrush = SolidColor(Gray900),
        cornerRadius = 4.dp,
        borderColor = Gray300,
        borderWidth = Dp.Hairline,
        paddingHorizontal = 8.dp,
        paddingVertical = 8.dp,
        rightIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_messagesend_active_24),
                contentDescription = "",
                tint = if (value.isEmpty()) Gray400 else Blue,
                modifier =
                    Modifier
                        .padding(start = 12.dp),
            )
        },
        modifier = modifier,
    )
}
