package com.example.editmatch21.ui.theme.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.editmatch21.R

@Composable
fun Header(
    screenName: String,
    modifier: Modifier,
    navigateToLogin: () -> Unit,
    navigateToProfile: () -> Unit,
    navigateToProjects: () -> Unit,
    navigateToWorks: () -> Unit,
    navigateToCarteira: () -> Unit

){
    var expanded = remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp) // Ajuste a altura conforme necessário
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { expanded.value = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_menu_24),
                    contentDescription = "menu"
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = screenName,
                color = Color.Black,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 1.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                onClick = { navigateToProfile() }
            ) {
                Icon(painter = painterResource(id = R.drawable.baseline_account_circle_24), contentDescription = "profile")
            }

            IconButton(
                onClick = { navigateToLogin() }
            ) {
                Icon(painter = painterResource(id = R.drawable.baseline_exit_to_app_24), contentDescription = "Sair")
            }
        }

        LinhaDivider(color = Color.Black, thickness = 1.dp, modifier = Modifier.fillMaxWidth())

        if(expanded.value) {
            Box(){
                DropdownMenu(
                    expanded = expanded.value,
                    onDismissRequest = { expanded.value = false }
                ) {
                    DropdownMenuItem(
                        text = { Text(text = "Projetos") }, 
                        onClick = { navigateToProjects() },
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_view_list_24), contentDescription = "Projetos " )}
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Trabalhos") },
                        onClick = { navigateToWorks() },
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_work_history_24), contentDescription = "Meus trabalhos andamento")}
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Carteira") },
                        onClick = { navigateToCarteira() },
                        leadingIcon = {Icon(painter = painterResource(id = R.drawable.baseline_wallet_24), contentDescription = "Carteira")
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Perfil") },
                        onClick = { navigateToProfile() },
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_account_circle_24), contentDescription = "profile") }

                    )
                    LinhaDivider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.fillMaxWidth())
                    DropdownMenuItem(
                        text = { Text(text = "Sair") },
                        onClick = { navigateToLogin() },
                        leadingIcon = {Icon(painter = painterResource(id = R.drawable.baseline_exit_to_app_24), contentDescription = "Sair")
                        }
                    )
                }
            }
        }
    }
}

