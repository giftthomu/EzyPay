package mw.ezypay.ezypay.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EzyPayTextField(
    label: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    labelColor: Color = Color.Gray,
    textColor: Color = Color.Black,
    cursorColor: Color = Color.Blue,
    shape: RoundedCornerShape = RoundedCornerShape(8.dp),
) {
    val textState = remember { mutableStateOf(TextFieldValue()) }

    OutlinedTextField(
        value = textState.value,
        onValueChange = { textState.value = it },
       // label = { Text(label, color = labelColor) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedTextColor = textColor,
            cursorColor = cursorColor,
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Gray
        ),
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor, shape)
            .padding(8.dp),
        shape = shape
    )
}
