package com.nath.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nath.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtComposeImg()
                }
            }
        }
    }
}

private fun getImg(id:Int):Int{
    val imgResource = when (id){
        1->R.drawable.amigos
        2->R.drawable.cheve
        3->R.drawable.danny_jr
        4->R.drawable.familia
        5->R.drawable.juan
        6->R.drawable.kari
        else->R.drawable.mami
    }
    return  imgResource
}

private fun getTxt(id:Int):Int{
    val txtResource = when (id){
        1->R.string.Amigos
        2->R.string.Cheve
        3->R.string.Danny
        4->R.string.Familia
        5->R.string.Juan
        6->R.string.Kari
        else->R.string.Mami
    }
    return txtResource
}

private fun getTitu(id: Int):Int{
    val tituloResource= when (id){
        1->R.string.AmigosDesc
        2->R.string.CheveDesc
        3->R.string.DannyDesc
        4->R.string.FamiliaDesc
        5->R.string.JuanDesc
        6->R.string.KariDesc
        else->R.string.MamiDesc
    }
    return tituloResource
}

//
@Composable
fun ArtComposeImg(modifier: Modifier=Modifier){
    // RECORDAR EN QUE IMAGEN VA
    var img by remember { mutableStateOf(value = 1) }
    //OCUPAMOS LA IMAGEN, EL TITULO Y EL TEXTO CON EL ID NUMERICO
    var imgResource = getImg(img)
    var txtResource = getTxt(img)
    var tituloResource = getTitu(img)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = imgResource),
                contentDescription =null
            )
        }
        Spacer(
            modifier = Modifier.height(60.dp)
        )
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                stringResource(id = tituloResource)
            )
        }
        Spacer(
            modifier = Modifier.height(5.dp)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                stringResource(id = txtResource),
                textAlign = TextAlign.Center)
        }
        Spacer(
            modifier = Modifier.height(25.dp)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                // SI ES MENOR A 7 Y MAYOR A 0 RESTA 1
                if (img>0 || img<8){
                    img--
                }
                // SI ES MENOR A 0 PONE LA IMAGEN 7
                if(img<0){
                    img=7
                }
            }) {
                Text(
                    text = "Previous"
                )
            }
            Button(
                onClick = {
                if (img>0 || img<7){
                    img++
                }
                // MAYOR A 7 REGRESA A 1
                if(img>=7){
                    img=1
                }
            }) {
                Text(
                    text = "Next"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtComposeImg()
    }
}