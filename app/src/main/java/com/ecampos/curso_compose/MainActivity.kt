package com.ecampos.curso_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecampos.curso_compose.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    GreetingImage(
                        message = stringResource(R.string.jetpack_compose_tutorial),
                        resume = stringResource(R.string.jetpack_compose_is_a_modern_toolkit),
                        body = stringResource(R.string.msj_body)
                    )

                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, body: String, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(start= 16.dp, top = 16.dp)

    ) {
        Text(
            text = message,
            fontSize = 24.sp,
            textAlign = TextAlign.Justify
        )
        Text(
            text = from,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(top = 16.dp)

        )
        Text(
            text = body,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(top = 16.dp)

        )
    }
}

@Composable
fun GreetingImage(message: String, resume: String, body: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column (modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
        GreetingText(
            message = message,
            from = resume,
            body=body,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage(
            message = stringResource(R.string.jetpack_compose_tutorial),
            resume = stringResource(R.string.jetpack_compose_is_a_modern_toolkit),
            body = stringResource(R.string.msj_body)
        )
    }
}
