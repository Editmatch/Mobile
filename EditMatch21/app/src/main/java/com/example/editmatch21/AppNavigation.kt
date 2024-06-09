package com.example.editmatch21

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.editmatch21.ui.theme.screens.LoginScreen
import com.example.editmatch21.ui.theme.screens.RegisterSelectScreen
import com.example.editmatch21.ui.theme.screens.creator.ClientProjectsScreen
import com.example.editmatch21.ui.theme.screens.creator.CriadorViewModel
import com.example.editmatch21.ui.theme.screens.creator.EditorsScreen
import com.example.editmatch21.ui.theme.screens.creator.RegisterVideoCreatorScreen
import com.example.editmatch21.ui.theme.screens.creator.SendProjectScreen
import com.example.editmatch21.ui.theme.screens.editor.Carteira
import com.example.editmatch21.ui.theme.screens.editor.EditorViewModel
import com.example.editmatch21.ui.theme.screens.editor.ProfileScreen
import com.example.editmatch21.ui.theme.screens.editor.ProjectDetailsScreen
import com.example.editmatch21.ui.theme.screens.editor.ProjectsScreen
import com.example.editmatch21.ui.theme.screens.editor.RegisterVideoEditorScreen
import com.example.editmatch21.ui.theme.screens.editor.WorkScreen

@Composable
fun AppNavigation(){
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
            val editorViewModel = remember { EditorViewModel() }
            // Tela de cadastro de criador de vídeo
            RegisterVideoCreatorScreen(
                navigateToLogin = {
                    navController.navigate("login")
                },
                criadorViewModel = remember { CriadorViewModel() }
            )
        }

        composable("registerVideoEditor") {
            // Tela de cadastro de editor de vídeo
            RegisterVideoEditorScreen(
                navigateToLogin = {
                    navController.navigate("login")
                },
                editorViewModel = remember { EditorViewModel() }
            )
        }

        composable("projects") {
            ClientProjectsScreen(
                navigateToEditors = { navController.navigate("editores")},
                navigateToLogin = { navController.navigate("login") },
                navigateToSend = { navController.navigate("sendProject") },
                navigateToDetails = { projectName ->
                    navController.navigate("projectdetails/$projectName")
                }
            )
        }

        composable(
            "sendProject"
        ){
            SendProjectScreen(
                projectName = "blabla",
                navigateToEditProfile = { navController.navigate("profile") },
                navigateToLogin = { navController.navigate("login") },
                navigateToProjects = { navController.navigate("projects") },
                navigateToWorks = { /*TODO*/ }) {
            }
        }

        composable(
            "projectdetails/{projectName}",
            arguments = listOf(navArgument("projectName") { type = NavType.StringType })
        ){backStackEntry ->
            val projectName = backStackEntry.arguments?.getString("projectName") ?: ""

            ProjectDetailsScreen(
                projectName = projectName,
                navigateToEditProfile = { navController.navigate("profile") },
                navigateToLogin = { navController.navigate("login") },
                navigateToProjects = {navController.navigate("projects")},
                navigateToWorks = {navController.navigate("works")},
                navigateToCarteira = {navController.navigate("carteira")}
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

        composable("editores"){
            EditorsScreen(
                navigateToEditors = { navController.navigate("editores") },
                navigateToDetails = {},
                navigateToLogin = {navController.navigate("login")},
                navigateToSend = {navController.navigate("sendProject")},
            )
        }

        composable("carteira"){
            Carteira(
                navigateToEditProfile = { navController.navigate("profile") },
                navigateToLogin = { navController.navigate("login") },
                navigateToProjects = {navController.navigate("projects")},
                navigateToWorks = {navController.navigate("works")},
                navigateToCarteira = {navController.navigate("carteira")}
            )
        }
    }
}