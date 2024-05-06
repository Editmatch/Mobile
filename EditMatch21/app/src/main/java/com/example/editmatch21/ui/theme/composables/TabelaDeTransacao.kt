package com.example.editmatch21.ui.theme.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Tabela(valores: List<List<String>>) {

    Spacer(modifier = Modifier.height(16.dp))

    Box(
        modifier = Modifier
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ){

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Movimentações na sua carteira")

            Spacer(modifier = Modifier.height(20.dp))

            // Cabeçalho da tabela
            Row {
                Text(text = "Data", modifier = Modifier.weight(1f))
                Text(text = "Transação", modifier = Modifier.weight(1f))
                Text(text = "Valor", modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold)
            }

            // Linhas da tabela
            valores.forEach { linha ->
                Row {
                    linha.forEach { valor ->
                        Text(text = valor, modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

// Exemplo de uso em outra tela:
@Composable
fun OutraTela() {
    val valores = remember {
        listOf(
            listOf("Valor 1", "Valor 2", "Valor 3"),
            listOf("Outro Valor 1", "Outro Valor 2", "Outro Valor 3")
        )
    }

    Tabela(valores = valores)
}