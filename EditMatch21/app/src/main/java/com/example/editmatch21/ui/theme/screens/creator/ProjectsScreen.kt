package com.example.editmatch21.ui.theme.screens.creator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.editmatch21.ui.theme.composables.LinhaDivider
import com.example.editmatch21.ui.theme.composables.CardToProject
import com.example.editmatch21.ui.theme.composables.HeaderToCreator
import com.example.editmatch21.ui.theme.viewmodels.OrderViewModel

@Composable
fun ClientProjectsScreen(
    navigateToEditors: () -> Unit,
    navigateToLogin: () -> Unit,
    navigateToDetails: (Any?) -> Unit,
    navigateToSend: () -> Unit,
) {
    val viewModel: OrderViewModel = viewModel()

    viewModel.getOrders()

    val orders by viewModel.orders.observeAsState(initial = emptyList())

    val navController = rememberNavController()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Header
            HeaderToCreator("Projetos",
                navigateToLogin = {navigateToLogin()},
                navigateToProjects = { },
                navigateToEditors = { navigateToEditors() },
                navigateToSend = { navigateToSend() }
            )

            Spacer(modifier = Modifier.height(16.dp))

            orders.forEach { order ->
                CardToProject(navController, order.title, navigateToDetails)
                LinhaDivider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}
