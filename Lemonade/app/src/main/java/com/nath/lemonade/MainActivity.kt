package com.nath.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nath.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}


@Composable
fun LemonApp(modifier: Modifier = Modifier){
    var num by remember { mutableStateOf(1) }
    var cont by remember {mutableStateOf(0)}
    var rand = (2..4).random()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when(num){
            1 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(
                        text = stringResource(id = R.string.textOne_txt),
                        fontSize = 18.sp
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = stringResource(id = R.string.lemonTree_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .border(
                                BorderStroke(2.dp, Color(105, 205, 216)), shape = RoundedCornerShape(4.dp)
                            )
                            .clickable { num = 2 }
                    )
                }
            }
            2 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(
                        text = stringResource(id = R.string.textTwo_txt),
                        fontSize = 18.sp
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = stringResource(id = R.string.lemon_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .border(
                                BorderStroke(2.dp, Color(105, 205, 216)), shape = RoundedCornerShape(4.dp)
                            )
                            .clickable {
                                if (cont == rand) {
                                    num = 3
                                    cont = 0
                                    rand = (2..4).random()
                                } else {
                                    cont++
                                }
                            }
                    )
                }
            }
            3 ->{
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(
                        text = stringResource(id = R.string.textThree_txt),
                        fontSize = 18.sp
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = stringResource(id = R.string.glass_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .border(
                                BorderStroke(2.dp, Color(105, 205, 216)), shape = RoundedCornerShape(4.dp)
                            )
                            .clickable { num = 4 }
                    )
                }
            }
            4 ->{
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(
                        text = stringResource(id = R.string.textFour_txt),
                        fontSize = 18.sp
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = stringResource(id = R.string.empty_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .border(
                                BorderStroke(2.dp, Color(105, 205, 216)), shape = RoundedCornerShape(4.dp)
                            )
                            .clickable { num = 1 }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}