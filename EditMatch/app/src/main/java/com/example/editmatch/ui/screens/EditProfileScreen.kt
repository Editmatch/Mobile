package com.example.editmatch.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.editmatch.R

@Composable
fun EditProfileScreen() {
    var username = remember { mutableStateOf("Nome de Usuário") }
    var bio = remember { mutableStateOf("Bio do usuário") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        ProfileHeader()

        Spacer(modifier = Modifier.height(32.dp))

        // Formulário de edição
        EditProfileForm(username = username.value, bio = bio.value) { newName, newBio ->
            username.value = newName
            bio.value = newBio
        }

        Spacer(modifier = Modifier.height(16.dp))

    }
}

@Composable
fun ProfileHeader() {
    Spacer(modifier = Modifier.width(16.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.mipmap.perfil),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(94.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(30.dp))

        Column {
            Text(
                text = "Fernando Silva",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            )

            Spacer(modifier = Modifier.size(15.dp))
            Text(
                text = "Sou um editor com experiências em vídeos curtos ",
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.fillMaxWidth()
            )
        }
        Divider(
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun EditProfileForm(
    username: String,
    bio: String,
    onUpdateProfile: (String, String) -> Unit
) {
    var newUsername = remember { mutableStateOf(username) }
    var newBio = remember { mutableStateOf(bio) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Campo de edição de nome
        OutlinedTextField(
            value = newUsername.value,
            onValueChange = { newUsername.value = it },
            label = { Text("Nome") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        // Campo de edição de bio
        OutlinedTextField(
            value = newBio.value,
            onValueChange = { newBio.value = it },
            label = { Text("Bio") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        // Atualizar perfil quando o botão de salvar for clicado
        Button(
            onClick = { onUpdateProfile(newUsername.value, newBio.value) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Salvar")
        }
    }
}