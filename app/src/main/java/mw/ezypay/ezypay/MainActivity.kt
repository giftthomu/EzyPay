package mw.ezypay.ezypay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import mw.ezypay.ezypay.navigation.NavGraph
import mw.ezypay.ezypay.ui.theme.EzyPayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EzyPayTheme {
             NavGraph()
            }
        }
    }
}
