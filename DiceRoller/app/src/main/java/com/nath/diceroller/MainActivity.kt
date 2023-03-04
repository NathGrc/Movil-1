package com.nath.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nath.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DiceRollerApp()
                }

            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp(){
    DiceWithButtonAndImage(
        modifier = Modifier.fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier){
    var d1 by remember { mutableStateOf(1)}
    val imageResourced1 = when(d1){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    var d2 by remember { mutableStateOf(3)}
    val imageResourced2 = when(d2){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(){
            Image(
                painter = painterResource(imageResourced1),
                contentDescription = d1.toString()
            )
            Image(
                painter = painterResource(imageResourced2),
                contentDescription = d2.toString()
            )
        }
        Spacer(
            modifier = Modifier.height((16.dp))
        )
        Button(
            onClick = {
                d1 = (1..6).random();
                d2 = (1..6).random()
            }
        ) {
            Text(stringResource(R.string.roll))
        }
    }
}
