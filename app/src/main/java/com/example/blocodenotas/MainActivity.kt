package com.example.blocodenotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blocodenotas.ui.theme.BlocoDeNotasTheme
import com.example.blocodenotas.views.HomePage
import com.example.blocodenotas.views.InsertInfo
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            BlocoDeNotasTheme {

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "HomePage") {

                    composable(route = "HomePage") {
                        HomePage(
                            adicionarNotacao = {
                                navController.navigate("InsertInfo")
                            }
                        )
                    }

                    composable(route = "InsertInfo") {
                        InsertInfo()
                    }
                }
            }
        }
    }
}

