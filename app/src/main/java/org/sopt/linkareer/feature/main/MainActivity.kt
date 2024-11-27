package org.sopt.linkareer.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navigator = rememberMainNavigator()
            LINKareerAndroidTheme {
                MainScreen(navigator)
            }
        }
    }
}
