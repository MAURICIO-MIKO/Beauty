package com.example.betty

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.betty.ui.theme.BettyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BettyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White // Color de fondo blanco
                ) {
                    Greeting(
                        name = "Mauricio",
                        onButtonClick = {
                            // Navegar a SecondActivity cuando se haga clic en el botón
                            startActivity(Intent(this, SecondActivity::class.java))
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, onButtonClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.icono21),
            contentDescription = "Icono de ejemplo",
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 16.dp) // Cambiado el padding aquí para separar el texto del botón
        )

        Text(
            text = "¡Hola $name!",
            style = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFD4AF37), // Color dorado
                letterSpacing = 1.5.sp
            ),
            modifier = Modifier.padding(bottom = 16.dp) // Separar el texto del botón
        )

        Button(
            onClick = onButtonClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD4AF37) // Color amarillo dorado
            ),
            modifier = Modifier
                .fillMaxWidth() // Hace que el botón ocupe todo el ancho disponible
                .padding(horizontal = 16.dp) // Añade un padding horizontal para evitar que el botón toque los bordes
        ) {
            Text(
                text = "ACCEDER",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold, // Hace que el texto del botón esté en negrita
                    color = Color.White
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BettyTheme {
        Greeting(name = "Mauricio", onButtonClick = {})
    }
}