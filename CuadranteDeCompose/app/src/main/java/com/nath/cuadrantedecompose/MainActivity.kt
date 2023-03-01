package com.nath.cuadrantedecompose

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nath.cuadrantedecompose.ui.theme.CuadranteDeComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuadranteDeComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Quadrants()
                }
            }
        }
    }
}

@Composable
fun Quadrants(){
    Column(){
        Row(Modifier.weight(1f)){
            Column(Modifier.weight(1f)){
                DataBox(textOne = stringResource(R.string.themeOne_txt),
                    textTwo = stringResource(R.string.textOne_txt),
                    backgroundColor = Color.Green,
                    modifier = Modifier.weight(1f)
                )
            }
            Column(Modifier.weight(1f)){
                DataBox(textOne = stringResource(R.string.themeTwo_txt),
                    textTwo = stringResource(R.string.textTwo_txt),
                    backgroundColor = Color.Yellow,
                    modifier = Modifier.weight(1f)
                )
            }

        }
        Row(Modifier.weight(1f)) {
            Column(Modifier.weight(1f)){
                DataBox(
                    textOne = stringResource(R.string.themeThree_txt),
                    textTwo = stringResource(R.string.textThree_txt),
                    backgroundColor = Color.Cyan,
                    modifier = Modifier.weight(1f)
                )
            }
            Column(Modifier.weight(1f)){
                DataBox(
                    textOne = stringResource(R.string.themeFour_txt),
                    textTwo = stringResource(R.string.textFour_txt),
                    backgroundColor = Color.LightGray,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun DataBox (textOne: String, textTwo: String, backgroundColor: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize().
        background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = textOne,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = textTwo,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CuadranteDeComposeTheme {
        Quadrants()
    }
}