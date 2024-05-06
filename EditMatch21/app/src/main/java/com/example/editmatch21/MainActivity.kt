package com.example.editmatch21

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.editmatch21.ui.theme.EditMatch21Theme
import com.example.editmatch21.ui.theme.composables.LogoImage
import com.example.editmatch21.ui.theme.screens.LoginScreen
import com.example.editmatch21.ui.theme.screens.RegisterSelectScreen
import com.example.editmatch21.ui.theme.screens.creator.RegisterVideoCreatorScreen
import com.example.editmatch21.ui.theme.screens.editor.Carteira
import com.example.editmatch21.ui.theme.screens.editor.ProfileScreen
import com.example.editmatch21.ui.theme.screens.editor.ProjectsScreen
import com.example.editmatch21.ui.theme.screens.editor.RegisterVideoEditorScreen
import com.example.editmatch21.ui.theme.screens.editor.WorkScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EditMatch21Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {

        LogoImage(
            painter = painterResource(id = R.mipmap.logo),
            contentDescription = "Logo",
            width = 100.dp,
            height = 100.dp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EditMatch21Theme {
        Greeting("Android")
    }
}