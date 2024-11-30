package com.example.blocodenotas.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)


// Estou configurando o Shape para o meu EditText
val ShapeEditText = Shapes(
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(20.dp),
    large = RoundedCornerShape(30.dp),
)

val ShapeFloatingActionButton = Shapes(
    small = RoundedCornerShape(30.dp),
    medium = RoundedCornerShape(50.dp),
    large = RoundedCornerShape(100.dp)
)