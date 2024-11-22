package org.sopt.linkareer.core.designsystem.component.textfield

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme

@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hintText: String,
    modifier: Modifier = Modifier,
) {
    LinkareerBasicTextField(
        value = value,
        inputTextColor = Gray900,
        hintText = hintText,
        hintTextColor = Gray600,
        onValueChange = onValueChange,
        inputTextStyle = LINKareerTheme.typography.body13R11,
        hintTextStyle = LINKareerTheme.typography.body8M13,
        cursorBrush = SolidColor(Gray900),
        cornerRadius = 5.dp,
        paddingHorizontal = 5.dp,
        paddingVertical = 5.dp,
        leftIcon = R.drawable.ic_search_24,
        modifier = modifier,
    )
}

@Preview(showBackground = false)
@Composable
fun SearchTextFieldPreview() {
    LINKareerAndroidTheme {
        SearchTextField(
            value = "",
            onValueChange = {},
            hintText = "hint",
        )
    }
}
