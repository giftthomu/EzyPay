package mw.ezypay.ezypay.screens.aunthetication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mw.ezyPay.R
import mw.ezypay.ezypay.common.UiHelper


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(navController: NavController) {
    var identifier by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground), // Replace with your logo resource
            contentDescription = "App Logo",
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "One account", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Many possibilities", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(24.dp))

        UiHelper.EzyPayTextField(
            value = identifier,
            onValueChange = { identifier = it },
            label = "E-mail address or phone number",
            leadingIcon = if (identifier.contains("@")) Icons.Filled.Email else Icons.Filled.Phone,
            keyboardType = if (identifier.contains("@")) KeyboardType.Email else KeyboardType.Phone
            )

        Spacer(modifier = Modifier.height(16.dp))

        UiHelper.EzyPayTextField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            leadingIcon = Icons.Filled.Lock,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { rememberMe = it }
                )
                Text("Remember me")
            }
            TextButton(onClick = { /* Handle forgot password */ }) {
                Text(text = "Forgot password?", color = Color.Red)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        UiHelper.EzyPayButton(
            onClick = { /* Handle sign in */ },
            text = "Sign in"
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { /* Handle Google sign in */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground), // Replace with your Google logo resource
                    contentDescription = "Google Logo",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Sign in with Google", color = Color.Black)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { /* Handle sign up */ }) {
            Text("Not a member yet? Sign up")
        }
    }
}

@Composable
@Preview
fun PreviewLogin() {

}