package com.example.artspace_infomovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace_infomovil.ui.theme.ArtSpace_INFOMOVILTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpace_INFOMOVILTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SpaceApp()
                }
            }
        }
    }
}

@Composable
fun SpaceApp(
    modifier: Modifier = Modifier
) {
    var ident by remember { mutableStateOf(3) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        when(ident){
            0 ->{
                PintaImagen(painter = R.drawable.cuadro)
                Spacer(modifier = Modifier.height(48.dp))
                InfoImagen(
                    titulo = R.string.titulo,
                    artista = R.string.artista,
                    anio = R.string.anio
                )
            }
            1 ->{
                PintaImagen(painter = R.drawable.cuadro1)
                Spacer(modifier = Modifier.height(48.dp))
                InfoImagen(
                    titulo = R.string.titulo1,
                    artista = R.string.artista1,
                    anio = R.string.anio1
                )
            }
            2 ->{
                PintaImagen(painter = R.drawable.cuadro2)
                Spacer(modifier = Modifier.height(48.dp))
                InfoImagen(
                    titulo = R.string.titulo2,
                    artista = R.string.artista2,
                    anio = R.string.anio2
                )
            }
            else ->{
                PintaImagen(painter = R.drawable.cuadro3)
                Spacer(modifier = Modifier.height(48.dp))
                InfoImagen(
                    titulo = R.string.titulo3,
                    artista = R.string.artista3,
                    anio = R.string.anio3
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Bottom
        ){
            Button(onClick = { if (ident > 0) ident-- else ident = 3 }, modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)) {
                Text(
                    text = stringResource(R.string.Ant)
                )
            }
            Button(onClick = { if (ident < 3) ident++ else ident = 0 }, modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)) {
                Text(
                    text = stringResource(R.string.Sig)
                )
            }
        }
    }
}

@Composable
fun PintaImagen(
    painter : Int,
    modifier : Modifier = Modifier
){
    Image(
        painter = painterResource(painter),
        contentDescription  = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .aspectRatio(0.8F)
            .shadow(elevation = 12.dp, shape = RectangleShape)
            .border(24.dp, color = Color.White, shape = RectangleShape)
    )
}

@Composable
fun InfoImagen(
    titulo : Int,
    artista : Int,
    anio : Int,
    modifier : Modifier = Modifier
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F1FF)
        ),
        modifier = modifier
    ) {
        Text(
            text = stringResource(titulo),
            fontWeight = FontWeight.Light,
            fontSize = 22.sp,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp
            )
        )

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 8.dp,
                    bottom = 16.dp
                )
        ) {
            Text(
                text = stringResource(artista),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "(${ stringResource(anio) })",
                fontWeight = FontWeight.Light,
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpacePreview() {
    ArtSpace_INFOMOVILTheme {
        SpaceApp()
    }
}