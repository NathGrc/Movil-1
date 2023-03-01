package com.nath.administradordetareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nath.administradordetareas.ui.theme.AdministradorDeTareasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdministradorDeTareasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Content(messageOne = stringResource(R.string.taskCompleted_txt), messageTwo = stringResource(
                        R.string.nice_txt)
                    )
                }
            }
        }
    }
}

@Composable
fun Content(messageOne: String, messageTwo: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_task_completed)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = messageOne,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top =24.dp, bottom=8.dp)
        )
        Text(
            text = messageTwo,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AdministradorDeTareasTheme {
        Content(messageOne = stringResource(R.string.taskCompleted_txt), messageTwo = stringResource(
                    R.string.nice_txt)
                )
    }
}