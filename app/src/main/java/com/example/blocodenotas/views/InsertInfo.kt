package com.example.blocodenotas.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.blocodenotas.componentes.CaixaDeTexto
import com.example.blocodenotas.componentes.botao
import com.example.blocodenotas.ui.theme.white


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsertInfo(
    navController: NavController
){

    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Anotações",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue, // Cor de fundo azul
                    titleContentColor = Color.White // Cor do título
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp) // Padding adicional
                .verticalScroll(rememberScrollState()) // Permitir scroll vertical
        ) {
            var tituloTarefa by remember { mutableStateOf("") }
            var descricaoTarefa by remember { mutableStateOf("") }

            CaixaDeTexto(
                value = tituloTarefa,
                onvalueChenge = { tituloTarefa = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                label = "Título",
                maxLines = 1,
                keybordType = KeyboardType.Text
            )

            CaixaDeTexto(
                value = descricaoTarefa,
                onvalueChenge = { descricaoTarefa = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(bottom = 20.dp),
                label = "Descrição",
                maxLines = 5,
                keybordType = KeyboardType.Text
            )

            botao(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(50.dp),
                texto = "Salvar"

                )
        }
    }



}