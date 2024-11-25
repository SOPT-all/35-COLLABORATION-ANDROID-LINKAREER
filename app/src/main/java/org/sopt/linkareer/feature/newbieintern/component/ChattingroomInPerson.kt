package org.sopt.linkareer.feature.newbieintern.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme

@Composable
fun ChattingRoomInPerson(
    image : AsyncImagePainter,
    // Todo : 칩 or 칩 컨텐츠
    company : String,
    chattingTitle : String,
    participationPerson : Int,
    inPersonConversationIsBoolean: Boolean,
    onClick : () -> Unit
){
    Row(){
      AsyncImage(
          model = image,
          contentDescription = null
      )
      Column {

      }
    }
}