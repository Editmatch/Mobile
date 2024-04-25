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
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "login") {

                        composable("login") {
                            // Aqui está onde você adiciona o LoginScreen
                            LoginScreen(
                                navigateToRegister = {
                                    navController.navigate("registerSelect")
                                },
                                navigateToProject = {
                                    navController.navigate("projects")
                                }
                            )
                        }

                        composable("registerSelect") {
                            // Tela de seleção de registro
                            RegisterSelectScreen(
                                navigateToVideoCreator = {
                                    navController.navigate("registerVideoCreator")
                                },
                                navigateToVideoEditor = {
                                    navController.navigate("registerVideoEditor")
                                }
                            )
                        }

                        composable("registerVideoCreator") {
                            // Tela de cadastro de criador de vídeo
                            RegisterVideoCreatorScreen(
                                navigateToLogin = {
                                    navController.navigate("login")
                                }
                            )
                        }

                        composable("registerVideoEditor") {
                            // Tela de cadastro de editor de vídeo
                            RegisterVideoEditorScreen {
                                navController.navigate("login")
                            }
                        }

                        composable("projects") {
                            ProjectsScreen(
                                navigateToProfile = { navController.navigate("profile") },
                                navigateToDetails = {},
                                navigateToLogin = { navController.navigate("login") },
                                navigateToWorks = {navController.navigate("works")},
                                navigateToCarteira = {navController.navigate("carteira")},
                                navigateToProjects = {}
                            )
                        }

                        composable("profile") {
                            ProfileScreen(
                                navigateToEditProfile = { /*TODO*/ },
                                navigateToLogin = { navController.navigate("login") },
                                navigateToProjects = {navController.navigate("projects")},
                                navigateToWorks = {navController.navigate("works")},
                                navigateToCarteira = {navController.navigate("carteira")}
                            )
                        }

                        composable("works"){
                            WorkScreen(
                                navigateToProfile = { navController.navigate("profile") },
                                navigateToDetails = {},
                                navigateToLogin = { navController.navigate("login") },
                                navigateToProjects = {navController.navigate("projects")},
                                navigateToWorks = {navController.navigate("works")},
                                navigateToCarteira = {navController.navigate("carteira")}
                            )
                        }

                        composable("carteira"){

                        }
                    }
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