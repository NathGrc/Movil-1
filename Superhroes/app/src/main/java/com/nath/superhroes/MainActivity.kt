package com.nath.superhroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nath.superhroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                HeroesApp()
            }
        }
    }
}


@Composable
fun HeroesApp(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar()
        }
    ){
        val heroes = HeroesRepository.heroes
        HeroesList(heroes = heroes,Modifier.padding(it))
    }
}

@Composable
fun TopAppBar(modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .size(56.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "HeroesApp",
            style = MaterialTheme.typography.h1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeroesAppPreview(){
    SuperheroesTheme {
        HeroesApp()
    }
}