package com.example.blocodenotas.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blocodenotas.ui.theme.ShapeEditText
import com.example.blocodenotas.ui.theme.black
import com.example.blocodenotas.ui.theme.blue
import com.example.blocodenotas.ui.theme.light_blue
import com.example.blocodenotas.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaDeTexto(
    value: String,
    onvalueChenge: (String) -> Unit,
    modifier: Modifier,
    label: String,
    maxLines: Int,
    keybordType: KeyboardType,
){
    OutlinedTextField(
        value = value,
        onValueChange = onvalueChenge,
        modifier,
        label = {
            Text(text = label)
        },
        maxLines = maxLines,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = blue,
            focusedBorderColor = light_blue,
            containerColor = white,
            focusedLabelColor = light_blue,
            focusedTextColor = black,

        ),
        shape = ShapeEditText.small,
        keyboardOptions = KeyboardOptions(
            keyboardType = keybordType
        )
    )

}
@Preview
@Composable
fun CaixaDeTextoPreviez(){
    var  tituloTarefa = ""
    CaixaDeTexto(
        value = tituloTarefa,
        onvalueChenge ={
            tituloTarefa = it // basicamente e o texto que esta sendo digitado na caixa de texto
        },
        modifier = Modifier.fillMaxWidth().padding(20.dp,20.dp,0.dp),
        label = "Titulo",
        maxLines = 1,
        keybordType = KeyboardType.Text,
    )
}