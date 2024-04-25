package com.example.editmatch21.ui.theme.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp

@Composable
fun LogoImage(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    width: Dp,
    height: Dp
) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier.width(width).height(height),
        contentScale = contentScale
    )
}


// EXEMPLO de como utilizar essa função
/*
val painter: Painter = rememberImagePainter("url_da_imagem")

ResizableImage(
    painter = painter,
    contentDescription = "Descrição da imagem",
    width = 100.dp,
    height = 100.dp
)
*/

