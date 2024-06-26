package mw.ezypay.ezypay.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object UiHelper {

    @Composable
    fun EzyPayTextField(
        value: String,
        onValueChange: (String) -> Unit,
        label: String,
        leadingIcon: ImageVector? = null,
        keyboardType: KeyboardType = KeyboardType.Text,
        visualTransformation: VisualTransformation = VisualTransformation.None,
        modifier: Modifier = Modifier
    ) {

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            leadingIcon = leadingIcon?.let { { Icon(it, contentDescription = null) } },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = visualTransformation,
            modifier = modifier.fillMaxWidth()
        )
    }

    @Composable
    fun EzyPayButton(
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        text: String,
        backgroundColor: Color = MaterialTheme.colorScheme.primary,
        contentColor: Color = Color.White,

    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroundColor,
                contentColor = contentColor
            ),
            modifier = modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text(text)
        }
    }

    @Composable
    fun ProgressIndicator(
        progress: Float,
        modifier: Modifier = Modifier,
        backgroundColor: Color = Color.Gray,
        progressColor: Color = Color.Blue,
        strokeWidth: Float = 4f
    ) {
        Canvas(modifier = modifier.size(50.dp)) {
            drawCircle(
                color = backgroundColor,
                radius = size.minDimension / 2,
                style = Stroke(width = strokeWidth)
            )

            drawArc(
                color = progressColor,
                startAngle = -90f,
                sweepAngle = 360 * progress,
                useCenter = false,
                style = Stroke(width = strokeWidth)
            )
        }
    }


}