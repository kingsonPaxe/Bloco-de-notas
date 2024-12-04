package com.example.blocodenotas.views

import AnotacoesItem
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.blocodenotas.ui.theme.ShapeFloatingActionButton
import com.example.blocodenotas.ui.theme.white
import com.example.blocodenotas.viewModel.HomePageViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomePage(
    viewModel: HomePageViewModel = hiltViewModel(),
    adicionarNotacao: () -> Unit
) {
    val anotacoes = viewModel.anotacoes.collectAsStateWithLifecycle().value

    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(

                title = {
                    Text(
                        "Bloco de notas", fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = white
                    )

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue, // Cor de fundo azul
                    titleContentColor = Color.White // Cor do título
                )

            ) // Fim do TopAppBar
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = adicionarNotacao,
                containerColor = Color.Blue,
                contentColor = Color.White,
                shape = ShapeFloatingActionButton.large
            ) {
                Icon(Icons.Filled.Add, "Floating action button.")
            }
        }


    ) { paddingValues ->
        // Aqui onde vamos configurar a Lista de anotacoes...
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            items(anotacoes) { anotacao ->
                    AnotacoesItem(
                        anotacao = anotacao,
                        eliminar = { viewModel.eliminarAnotacao(it) }
                    )
            }
        }
    }
}