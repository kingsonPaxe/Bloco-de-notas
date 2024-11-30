package com.example.blocodenotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blocodenotas.ui.theme.BlocoDeNotasTheme
import com.example.blocodenotas.views.HomePage
import com.example.blocodenotas.views.InsertInfo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlocoDeNotasTheme {
                Surface (color = MaterialTheme.colorScheme.background){  }
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "HomePage"){
                    composable(route = "HomePage") {
                        HomePage(navController)
                    }

                    composable(route = "InsertInfo") {
                        InsertInfo(navController)
                    }

                }

            }
        }
    }
}
