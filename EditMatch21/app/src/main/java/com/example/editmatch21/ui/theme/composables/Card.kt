package com.example.editmatch21.ui.theme.composables

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import coil.compose.rememberImagePainter
import com.example.editmatch21.R
@Composable
fun CardToProject(
    navController: NavController,
    videoName: String,
    navigateToDetails: (Any) -> Unit
) {
    Surface(
        color = Color.White,
        tonalElevation = 6.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .height(100.dp)
            .clickable {
                navigateToDetails(videoName)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_video_settings_24),
                contentDescription = "Video",
                modifier = Modifier.size(90.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = videoName,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Start,
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun CardToCarteira() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
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
                        color = Color(80, 80, 80),
                        fontSize = 19.sp
                    )

                    Text(
                        text = "R$ " + "1500.0034,00", // o numero será substituido pelo valor do banco de dados
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

@Composable
fun CardEditor(
    navController: NavController,
    editorId: Int,
    editorName: String,
    editorFoto: String?,
    navigateToProfileEditorScreen: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navigateToProfileEditorScreen(editorId)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = if (editorFoto.isNullOrEmpty()) painterResource(id = R.drawable.baseline_account_circle_24) else rememberImagePainter(editorFoto),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = editorName,
                fontSize = 18.sp,
                color = Color.Black
            )
        }
    }
}



