package org.sopt.linkareer.core.designsystem.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Black
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme
import org.sopt.linkareer.core.designsystem.theme.Red
import org.sopt.linkareer.core.designsystem.theme.White

@Composable
fun LinkareerBasicTextField(
    value: String,
    hintText: String,
    onValueChange: (String) -> Unit,
    inputTextStyle: TextStyle,
    hintTextStyle: TextStyle,
    cursorBrush: Brush,
    cornerRadius: Dp,
    paddingVertical: Dp,
    paddingHorizontal: Dp,
    inputTextColor: Color = Black,
    hintTextColor: Color = Gray600,
    showHelperMessage: Boolean = false,
    helperMessage: String = "",
    singleLine: Boolean = true,
    onDoneAction: () -> Unit? = {},
    onSearchAction: () -> Unit? = {},
    modifier: Modifier = Modifier,
    leftIcon: Int? = null,
    leftIconColor: Color = Gray900,
    imeAction: ImeAction = ImeAction.Done,
    rightIcon: @Composable () -> Unit = {},
) {
    Column {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = inputTextStyle.copy(color = inputTextColor),
            cursorBrush = cursorBrush,
            keyboardOptions = KeyboardOptions(imeAction = imeAction),
            keyboardActions =
            KeyboardActions(
                onDone = { onDoneAction() },
                onSearch = { onSearchAction() },
            ),
            modifier = modifier,
            decorationBox = { innerTextField ->
                Row(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(cornerRadius))
                        .background(White)
                        .padding(
                            vertical = paddingVertical,
                            horizontal = paddingHorizontal,
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    leftIcon?.let {
                        Icon(
                            painter = painterResource(id = it),
                            contentDescription = "",
                            tint = leftIconColor,
                            modifier =
                            Modifier
                                .padding(end = 5.dp),
                        )
                    }
                    Box(
                        modifier =
                        Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically),
                    ) {
                        if (value.isEmpty()) {
                            Text(
                                text = hintText,
                                style = hintTextStyle,
                                color = hintTextColor,
                            )
                        }
                        innerTextField()
                    }
                    rightIcon()
                }
            },
        )

        Text(
            text = if (showHelperMessage) helperMessage else "",
            style = LINKareerTheme.typography.label5M8,
            color = Red,
            modifier =
            Modifier
                .padding(top = 4.dp),
        )

    }
}

@Preview(showBackground = false)
@Composable
fun LinkareerBasicTextFieldPreview() {
    LINKareerAndroidTheme {
        LinkareerBasicTextField(
            value = "",
            hintText = "hint",
            onValueChange = {},
            inputTextStyle = LINKareerTheme.typography.label4M10,
            hintTextStyle = LINKareerTheme.typography.label4M10,
            cursorBrush = SolidColor(Black),
            cornerRadius = 5.dp,
            paddingHorizontal = 5.dp,
            paddingVertical = 5.dp,
            leftIcon = R.drawable.ic_search_24,
            rightIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_messagesend_inactive_24),
                    contentDescription = "",
                )
            },
            showHelperMessage = true,
            helperMessage = "helper",
        )
    }
}
