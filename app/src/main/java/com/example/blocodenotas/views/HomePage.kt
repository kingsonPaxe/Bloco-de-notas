package com.example.blocodenotas.views

import AnotacoesItem
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.blocodenotas.R
import com.example.blocodenotas.model.Anotacoes
import com.example.blocodenotas.ui.theme.ShapeFloatingActionButton
import com.example.blocodenotas.ui.theme.blue
import com.example.blocodenotas.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomePage(
    navController: NavController
){
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
                onClick = {
                    navController.navigate("InsertInfo")
                },
                containerColor = Color.Blue,
                contentColor = Color.White,
                shape = ShapeFloatingActionButton.large
            ) {
                Icon(Icons.Filled.Add, "Floating action button.")
            }
        }


    ) {paddingValues ->
        // Aqui onde vamos configurar a Lista de anotacoes...
        val listaAnotacoes: MutableList<Anotacoes> = mutableListOf(
            Anotacoes(
                Titulo = "O que é Kotlin?",
                descricao = "Kotlin é uma linguagem de programação moderna e concisa."
            ),
            Anotacoes(
                Titulo = "O que é a vida?",
                descricao = "A vida é o que acontece enquanto fazemos planos."
            ),
            Anotacoes(
                Titulo = "Nota 3",
                descricao = "Descrição da nota 3."
            ),

            Anotacoes(
                Titulo = "Nota 3",
                descricao = "Descrição da nota 3."
            ),

            Anotacoes(
                Titulo = "Nota 3",
                descricao = "Descrição da nota 3."
            ),

            Anotacoes(
                Titulo = "Nota 3",
                descricao = "Descrição da nota 3."
            ),

            )

        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ){
            itemsIndexed(listaAnotacoes){
                    position, _ ->
                AnotacoesItem(position,listaAnotacoes)
            }
        }
    }
}