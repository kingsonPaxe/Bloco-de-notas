import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.blocodenotas.R
import com.example.blocodenotas.model.Anotacoes

@Composable

fun AnotacoesItem(
    position: Int,
    listaAnotacoes: MutableList<Anotacoes>
){

    // Recuperando Todas as propriedades
    val tituloAnotacoes = listaAnotacoes[position].Titulo
    val descricaoAnotacoes = listaAnotacoes[position].descricao

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {
            val(txtTitulo, txtDescricao, btDeletar) = createRefs()

            // Titulo...


            Text(
                text = tituloAnotacoes.toString(),
                fontSize = 16.sp,
//                color = Color.Gray,
                modifier = Modifier.constrainAs(txtTitulo){
                    top.linkTo(parent.top, margin = 10.dp) // Colocando o meu texto no topo
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            // Descricao...
            Text(
                text = descricaoAnotacoes.toString(),
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.constrainAs(txtDescricao){
                    top.linkTo(txtTitulo.bottom, margin = 10.dp) // Colocando o meu texto no topo
                    start.linkTo(parent.start, margin = 10.dp)
                }


            )
            IconButton(
                onClick = {},
                modifier = Modifier.constrainAs(btDeletar){
                    top.linkTo(txtTitulo.top, margin = 10.dp) // Colocando o meu texto no topo
                    start.linkTo(txtDescricao.start, margin = 300.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            ) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete), contentDescription = null)
            }
        }


    }
}