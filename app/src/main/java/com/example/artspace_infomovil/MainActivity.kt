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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        Image(
            painter = painterResource(R.drawable.cuadro),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .shadow(5.dp)
                .border(BorderStroke(20.dp, Color.White))
                .size(290.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Spacer(
            modifier = Modifier.height(30.dp)
        )
        Text(
            text = stringResource(R.string.name)
        )
        Text(
            text = stringResource(R.string.num)
        )

    }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ){
        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .weight(1f)
            .padding(horizontal = 8.dp)) {
            Text(
                text = stringResource(R.string.Ant)
            )
        }
        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .weight(1f)
            .padding(horizontal = 8.dp)) {
            Text(
                text = stringResource(R.string.Sig)
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