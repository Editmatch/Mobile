package com.example.editmatch21.ui.theme.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.editmatch21.R

@Composable
fun CardToProject(videoName:String, duracao:String) {
    Surface(
        color = Color.White,
        tonalElevation = 6.dp,
        shape = RoundedCornerShape(8.dp), // Borda redonda com raio de 8.dp
        modifier = Modifier
            .size(width = 375.dp, height = 100.dp)
            .padding(3.dp)
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
                Spacer(modifier = Modifier.weight(1f))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Duração: "+duracao+"min",
                        modifier = Modifier.padding(15.dp),
                        fontSize = 12.sp,
                        textAlign = TextAlign.End,
                    )
                }

            }
        }
    }
}

