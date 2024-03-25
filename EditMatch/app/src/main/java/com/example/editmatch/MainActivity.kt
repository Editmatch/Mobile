package com.example.editmatch
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.editmatch.ui.theme.EditMatchTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.editmatch.ui.screens.EditProfileScreen
import com.example.editmatch.ui.screens.HomeScreen
import com.example.editmatch.ui.screens.LoginScreen
import com.example.editmatch.ui.screens.ProfileScreen
import com.example.editmatch.ui.screens.ProjectDetailsScreen
import com.example.editmatch.ui.screens.RegisterAdditionalInfoScreen
import com.example.editmatch.ui.screens.RegisterContentCreatorScreen
import com.example.editmatch.ui.screens.RegisterSelectScreen
import com.example.editmatch.ui.screens.RegisterVideoEditorScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EditMatchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login"){
                        composable("login") {
                            // Aqui está onde você adiciona o LoginScreen
                            LoginScreen(
                                navigateToRegister = {
                                    navController.navigate("registerSelect")
                                },
                                navigateToHome = {
                                    navController.navigate("home")
                                }
                            )
                        }

                        composable("registerSelect") {
                            // Tela de seleção de registro
                            RegisterSelectScreen(
                                navigateToContentCreator = {
                                    navController.navigate("registerContentCreator")
                                },
                                navigateToVideoEditor = {
                                    navController.navigate("registerVideoEditor")
                                }
                            )
                        }

                        composable("registerContentCreator") {
                            // Tela de cadastro de criador de vídeo
                            RegisterContentCreatorScreen(
                                navigateToLogin = {
                                    navController.navigate("login")
                                }
                            )
                        }

                        composable("registerVideoEditor") {
                            // Tela de cadastro de editor de vídeo
                            RegisterVideoEditorScreen(
                                navigateToLogin = {
                                    navController.navigate("login")
                                },
                                navigateToAdditionalInfo = {
                                    navController.navigate("additionalInfo")
                                }
                            )
                        }

                        composable("additionalInfo") {
                            // Segunda tela de cadastro com informações adicionais
                            RegisterAdditionalInfoScreen(
                                navigateToLogin = {
                                    navController.navigate("login")
                                }
                            )
                        }

                        composable("home") {
                            HomeScreen(
                                navigateToProjects = {
                                    navController.navigate("projects")
                                },
                                navigateToProfile = {
                                    navController.navigate("profile")
                                }
                            ){

                            }
                        }

                        composable("profile") {
                            // Tela de perfil
                            // Adicionar a tela de perfil ProfileScreen
                            ProfileScreen(
                                navigateToEditProfile = {
                                    // Navegar para a tela de edição do perfil
                                    navController.navigate("editProfile")
                                }
                            )
                        }
                        composable("editProfile") {
                            // Tela de edição de perfil
                            EditProfileScreen()
                        }

                        composable("projects") {
                            // Aqui você navega para a tela ProjectDetailsScreen
                            ProjectDetailsScreen("")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EditMatchTheme {
        MainActivity()
    }
}