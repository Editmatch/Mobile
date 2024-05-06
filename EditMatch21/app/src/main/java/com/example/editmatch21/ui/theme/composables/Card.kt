package com.example.editmatch21.ui.theme.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.editmatch21.R

@Composable
fun CardEditor(

){

}

@Composable
fun CardToProject(
    navController: NavController,
    videoName:String,
    navigateToDetails: (String) -> Unit
) {
    Surface(
        color = Color.White,
        tonalElevation = 6.dp,
        shape = RoundedCornerShape(8.dp), // Borda redonda com raio de 8.dp
        modifier = Modifier
            .size(width = 375.dp, height = 100.dp)
            .padding(3.dp)
            .clickable { navigateToDetails(videoName) }
    ) {
        Row {
            Column {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_video_settings_24),
                    contentDescription = "Video",
                    modifier = Modifier.size(90.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Text(
                    text = videoName,
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
fun CardToCarteira() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Surface(
            color = Color.White,
            tonalElevation = 6.dp,
            shape = RoundedCornerShape(8.dp), // Borda redonda com raio de 8.dp
            modifier = Modifier
                .size(width = 275.dp, height = 100.dp)
                .padding(4.dp)
                .border(1.dp, color = Color(80, 80, 80), shape = RoundedCornerShape(8.dp))
                .clip(RoundedCornerShape(8.dp))

        ) {
            Row {

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(), // Para garantir que a Column ocupe a largura máxima
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(1.dp)
                    ) {

                    Text(
                        text = "Saldo atual:",
                        modifier = Modifier.padding(3.dp),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        color = Color(80,80,80),
                        fontSize = 19.sp
                    )

                    Text(
                        text = "R$ " + "1500.0034,00" , // o numero será substituido pelo valor do banco de dados
                        modifier = Modifier.padding(15.dp),
                        fontSize = 29.sp,
                        textAlign = TextAlign.Center,
                        color = Color(31, 184, 31, 255),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }

}

