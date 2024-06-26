package mw.ezypay.ezypay.common.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EzyPayText(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black,
    textSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    padding: Dp = 8.dp
) {
    Text(
        text = text,
        color = textColor,
        fontSize = textSize,
        fontWeight = fontWeight,
        modifier = modifier
            .padding(padding)
    )
}
