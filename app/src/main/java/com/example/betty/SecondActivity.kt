package com.example.betty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.betty.ui.theme.BettyTheme

data class Item(
    val imageResId: Int,
    val mainText: String,
    val secondaryText: String,
    val numberText: String
)

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BettyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White // Color de fondo gris claro
                ) {
                    // Lista de elementos para LazyColumn
                    val itemsList = listOf(
                        Item(R.drawable.inicio, "Texto Principal 1", "Texto Secundario 1", "12345"),
                        Item(R.drawable.inicio, "Texto Principal 2", "Texto Secundario 2", "67890"),
                        Item(R.drawable.inicio, "Texto Principal 3", "Texto Secundario 3", "11223"),
                        Item(R.drawable.inicio, "Texto Principal 4", "Texto Secundario 4", "44556")
                    )

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        items(itemsList) { item ->
                            ItemView(item = item)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ItemView(item: Item) {
    // Contenedor de cada elemento en la lista
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .border(1.dp, Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen
        Image(
            painter = painterResource(id = item.imageResId),
            contentDescription = "Imagen de ejemplo",
            modifier = Modifier
                .size(150.dp)
                .padding(bottom = 16.dp)
        )

        // Texto principal
        Text(
            text = item.mainText,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Texto secundario
        Text(
            text = item.secondaryText,
            style = TextStyle(
                fontSize = 18.sp,
                color = Color.Gray
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Número
        Text(
            text = item.numberText,
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )
        )
    }
}