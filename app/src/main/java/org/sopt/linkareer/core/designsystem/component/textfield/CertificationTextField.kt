package org.sopt.linkareer.core.designsystem.component.textfield

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme

@Composable
fun CertificationTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hintText: String,
    helperMessage: String,
    showHelperMessage: Boolean = false,
    modifier: Modifier = Modifier,
) {
    LinkareerBasicTextField(
        value = value,
        inputTextColor = Gray900,
        hintText = hintText,
        hintTextColor = Gray600,
        onValueChange = onValueChange,
        inputTextStyle = LINKareerTheme.typography.body13R11,
        hintTextStyle = LINKareerTheme.typography.body13R11,
        showHelperMessage = showHelperMessage,
        helperMessage = helperMessage,
        cursorBrush = SolidColor(Gray900),
        cornerRadius = 4.dp,
        paddingHorizontal = 9.dp,
        paddingVertical = 10.dp,
        modifier = modifier,
    )
}