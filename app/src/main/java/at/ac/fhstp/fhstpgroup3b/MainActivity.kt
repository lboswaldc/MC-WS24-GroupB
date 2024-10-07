package at.ac.fhstp.fhstpgroup3b

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import at.ac.fhstp.fhstpgroup3b.ui.MainApp
import at.ac.fhstp.fhstpgroup3b.ui.theme.FHSTPGroup3BTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FHSTPGroup3BTheme {
                MainApp()
            }
        }
    }
}

fun updateText(changedText: String) {
    println(changedText)
}

@Preview(showBackground = true)
@Composable
fun TextPreview() {
    Text("Hi there")
}

@Preview(showBackground = true)
@Composable
fun ColumnDemo() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color.Blue)
        ) {
            Text("Blue")
        }
        Box(
            Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color.Yellow)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color.Red)
        )
        Row(Modifier.fillMaxWidth(0.5f)) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .background(Color.Green)
                    .weight(1f)
            )
            Box(
                Modifier
                    .fillMaxHeight()
                    .background(Color.Magenta)
                    .weight(6f)
            )
            Box(
                Modifier
                    .fillMaxHeight()
                    .background(Color.Gray)
                    .weight(1f)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Exercise1() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Red)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.White)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Red)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.White)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Red)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Exercise2() {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.Red)
                    .weight(1f)
            )
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .weight(1f)
            )
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.Red)
                    .weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.Red)
                    .weight(1f)
            )
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .weight(1f)
            )
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.Red)
                    .weight(1f)
            )
        }
    }
}