package com.example.editmatch21

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.editmatch21.ui.theme.screens.LoginScreen
import com.example.editmatch21.ui.theme.screens.RegisterSelectScreen
import com.example.editmatch21.ui.theme.screens.creator.ClientProjectsScreen
import com.example.editmatch21.ui.theme.screens.creator.ContratarEditor
import com.example.editmatch21.ui.theme.screens.creator.EditorsScreen
import com.example.editmatch21.ui.theme.screens.creator.ProfileEditorScreen
import com.example.editmatch21.ui.theme.screens.creator.ProjectDetailsClientScreen
import com.example.editmatch21.ui.theme.screens.creator.RegisterVideoCreatorScreen
import com.example.editmatch21.ui.theme.screens.creator.SendProjectScreen
import com.example.editmatch21.ui.theme.screens.editor.Carteira
import com.example.editmatch21.ui.theme.screens.editor.ProfileScreen
import com.example.editmatch21.ui.theme.screens.editor.ProjectDetailsScreen
import com.example.editmatch21.ui.theme.screens.editor.RegisterVideoEditorScreen
import com.example.editmatch21.ui.theme.screens.editor.WorkScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
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
            RegisterSelectScreen(
                navigateToVideoCreator = {
                    navController.navigate("registerVideoCreator")
                },
                navigateToVideoEditor = {
                    navController.navigate("registerVideoEditor")
                }
            )
        }


        composable("projects") {
            ClientProjectsScreen(
                navigateToEditors = { navController.navigate("editores") },
                navigateToLogin = { navController.navigate("login") },
                navigateToSend = { navController.navigate("sendProject") },
                navigateToDetails = { projectName ->
                    navController.navigate("projectClientDetails/$projectName")
                }
            )
        }

        composable(
            "sendProject"
        ) {
            SendProjectScreen(
                screenName = "blabla",
                navigateToLogin = { navController.navigate("login") },
                navigateToSend = { navController.navigate("sendProject") },
                navigateToEditors = { navController.navigate("editores") },
                navigateToProjects = { navController.navigate("projects") }
            )
        }

        composable("projectClientDetails/{projectName}",
            arguments = listOf(navArgument("projectName") { type = NavType.StringType })
        ){
            backStackEntry ->
            val projectName = backStackEntry.arguments?.getString("projectName") ?: ""
            ProjectDetailsClientScreen(
                projectName = projectName,
                navigateToLogin = { navController.navigate("login") },
                navigateToSend = { navController.navigate("sendProject") },
                navigateToEditors = { navController.navigate("editores") },
                navigateToProjects = { navController.navigate("projects") }
            )
        }

        composable(
            "projectdetails/{projectName}",
            arguments = listOf(navArgument("projectName") { type = NavType.StringType })
        ) { backStackEntry ->
            val projectName = backStackEntry.arguments?.getString("projectName") ?: ""

            ProjectDetailsScreen(
                projectName = projectName,
                navigateToEditProfile = { navController.navigate("profile") },
                navigateToLogin = { navController.navigate("login") },
                navigateToProjects = { navController.navigate("projects") },
                navigateToWorks = { navController.navigate("works") },
                navigateToCarteira = { navController.navigate("carteira") }
            )
        }

        composable("profile") {
            ProfileScreen(
                navigateToEditProfile = { /*TODO*/ },
                navigateToLogin = { navController.navigate("login") },
                navigateToProjects = { navController.navigate("projects") },
                navigateToWorks = { navController.navigate("works") },
                navigateToCarteira = { navController.navigate("carteira") }
            )
        }

        composable("works") {
            WorkScreen(
                navigateToProfile = { navController.navigate("profile") },
                navigateToDetails = {},
                navigateToLogin = { navController.navigate("login") },
                navigateToProjects = { navController.navigate("projects") },
                navigateToWorks = { navController.navigate("works") },
                navigateToCarteira = { navController.navigate("carteira") }
            )
        }

        composable("editores") {
            EditorsScreen(
                navigateToProjects = { navController.navigate("projects") },
                navigateToEditors = { navController.navigate("editores") },
                navigateToDetails = {},
                navigateToLogin = { navController.navigate("login") },
                navigateToSend = { navController.navigate("sendProject") },
                navigateToProfileEditorScreen = { editorId ->
                    navController.navigate("profileEditor/$editorId")
                }
            )
        }


        composable("profileEditor/{editorId}") { backStackEntry ->
            val editorId =
                backStackEntry.arguments?.getString("editorId")?.toInt() ?: return@composable
            ProfileEditorScreen(
                editorId = editorId,
                navigateToLogin = { navController.navigate("login") },
                navigateToProjects = { navController.navigate("projects") },
                navigateToEditors = { navController.navigate("editores") },
                navigateToSend =  { navController.navigate("sendProject") },
                navigateToHirePage = {  navController.navigate("contratar")}
            )
        }

        composable("contratar")
        {
            ContratarEditor(
                screenName = "Contratar editor",
                navigateToLogin = { navController.navigate("login") },
                navigateToSend = { navController.navigate("sendProject") },
                navigateToEditors = { navController.navigate("editores") },
                navigateToProjects = { navController.navigate("projects") },
                navigateToHirePage = { navController.navigate("contratar") }
            )
        }

        composable("carteira") {
            Carteira(
                navigateToEditProfile = { navController.navigate("profile") },
                navigateToLogin = { navController.navigate("login") },
                navigateToProjects = { navController.navigate("projects") },
                navigateToWorks = { navController.navigate("works") },
                navigateToCarteira = { navController.navigate("carteira") }
            )
        }

        composable("registerVideoCreator") {
            RegisterVideoCreatorScreen(
                navigateToLogin = { navController.navigate("login") }
            )
        }

        composable("registerVideoEditor") {
            RegisterVideoEditorScreen(
                navigateToLogin = { navController.navigate("login") }
            )
        }
    }
}