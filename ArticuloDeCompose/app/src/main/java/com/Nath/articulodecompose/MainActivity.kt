package com.Nath.articulodecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.Nath.articulodecompose.ui.theme.ArticuloDeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticuloDeComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
Content(title = stringResource(R.string.title_txt),
    paragraphOne = stringResource(R.string.paragraphOne_txt),
    paragraphTwo = stringResource(R.string.paragraphTwo_txt))

                }
            }
        }
    }
}

@Composable
fun Content(title: String, paragraphOne: String, paragraphTwo: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)

    Column(){
        Image( painter = image,
            contentDescription = null
        )

        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = paragraphOne,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = paragraphTwo,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArticuloDeComposeTheme {
        Content(title = stringResource(R.string.title_txt),
            paragraphOne = stringResource(R.string.paragraphOne_txt),
            paragraphTwo = stringResource(R.string.paragraphTwo_txt)
                    )
    }
}