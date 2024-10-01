package at.ac.fhstp.fhstpgroup3b

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import at.ac.fhstp.fhstpgroup3b.ui.theme.FHSTPGroup3BTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FHSTPGroup3BTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar() }
                ) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) {
                        Greeting(
                            name = "World",
                            modifier = Modifier.padding(innerPadding)
                        )
                        Calculation()
                    }
                }
            }
        }
    }
}

fun updateText(changedText: String) {
    println(changedText)
}

@Composable
fun BottomNavigationBar() {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "Home")},
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = false, onClick = { },
            icon = { Icon(imageVector = Icons.AutoMirrored.Default.List, contentDescription = "Overview")},
            label = { Text("Overview") }
        )
    }
}


@Composable
fun Calculation() {
    var inputText1 by remember { mutableStateOf("") }
    var inputText2 by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(inputText1, { changedText -> inputText1 = changedText },
            label = { Text("Number 1") }
        )
        OutlinedTextField(inputText2, { changedText -> inputText2 = changedText },
            label = { Text("Number 2") }
        )
        Button(onClick = {
            // Here we are in an event handler, it is ok to perform side effects
            val num1 = inputText1.toDoubleOrNull() ?: 0.0
            val num2 = inputText2.toDoubleOrNull() ?: 0.0
            val sum = num1 + num2
            resultText = "Result: $sum"
        }) {
            Text("Calculate!")
        }
        Text(resultText)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val number = 25
    Column {
        Text(
            text = "Hello $name! $number",
            modifier = modifier
        )
        Text(text = stringResource(R.string.greeting))
        Box(
            Modifier
                .background(colorResource(R.color.primary))
                .size(dimensionResource(R.dimen.small_padding))
        )
        Image(
            painter = painterResource(R.drawable.baseline_bloodtype_24),
            contentDescription = stringResource(R.string.blood_type)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FHSTPGroup3BTheme {
        Greeting("Mobile Coding")
    }
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