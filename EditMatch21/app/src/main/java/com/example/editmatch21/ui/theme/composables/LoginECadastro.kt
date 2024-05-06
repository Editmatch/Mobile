package com.example.editmatch21.ui.theme.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TextoDescritivo(
    texto:String
){
    Text(
        text = texto,
        color = Color.Black,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}
@Composable
fun InfoInput(
    value: String,
    onValueChange: (String) -> Unit,
    textoLabel: String,
    textoPlaceholder: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(textoLabel) },
        placeholder = { Text(textoPlaceholder) },
        textStyle = TextStyle(color = Color.Black)
    )
}

@Composable
fun Redirecionamento(
    onClick: () -> Unit,
    textoPergunta: String,
    textoAction: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = textoPergunta,
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp
            ),
        )

        TextButton(
            onClick = { onClick() }
        ) {
            Text(textoAction, textDecoration = TextDecoration.Underline)
        }
    }
}

@Composable
fun ButtonLoginCadastro(
    onClick: () -> Unit,
    texto:String
) {
    Button(
        onClick = { onClick() },
        modifier = Modifier.width(275.dp)
    ) {
        Text(texto)
    }
}



