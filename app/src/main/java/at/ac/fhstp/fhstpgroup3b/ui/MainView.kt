package at.ac.fhstp.fhstpgroup3b.ui

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import at.ac.fhstp.fhstpgroup3b.R
import at.ac.fhstp.fhstpgroup3b.SecondActivity
import at.ac.fhstp.fhstpgroup3b.ui.theme.FHSTPGroup3BTheme

enum class Screens {
    Home,
    Overview
}


@Composable
fun MainApp(mainViewModel: MainViewModel = viewModel()) {
    val navController = rememberNavController()
    val context = LocalContext.current

    val uiState by mainViewModel.calculationUiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(navController, startDestination = Screens.Home.name) {
            composable(Screens.Home.name) {
                Box(Modifier.padding(innerPadding)) {
                    Calculation("${uiState.result}", {
                        text1, text2 -> mainViewModel.calculate(text1, text2)
                    })
                }
            }
            composable(Screens.Overview.name) {
                Column(Modifier.padding(innerPadding)) {

                    Greeting(
                        name = "World. Result: ${uiState.result}",
                        modifier = Modifier.padding(innerPadding)
                    )

                    Button(onClick = {
                        val intent = Intent(context, SecondActivity::class.java)
                        intent.putExtra("text-to-transfer", "Hello from first activity!")
                        context.startActivity(intent)
                    }) {
                        Text("Navigate to second activity!")
                    }
                }

            }
        }
        /*Column(Modifier.padding(innerPadding)) {
            Greeting(
                name = "World",
                modifier = Modifier.padding(innerPadding)
            )
            Calculation()
        }*/
    }

}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: Screens.Home.name
    val currentScreen = Screens.valueOf(currentRoute)

    NavigationBar {
        NavigationBarItem(
            selected = currentScreen == Screens.Home,
            onClick = { navController.navigate(Screens.Home.name) },
            icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = currentScreen == Screens.Overview,
            onClick = { navController.navigate(Screens.Overview.name) },
            icon = { Icon(imageVector = Icons.AutoMirrored.Default.List, contentDescription = "Overview") },
            label = { Text("Overview") }
        )
    }
}


@Composable
fun Calculation(result: String, calculationTriggered: (String, String) -> Unit) {
    var inputText1 by remember { mutableStateOf("") }
    var inputText2 by remember { mutableStateOf("") }
//    var resultText by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(inputText1, { changedText -> inputText1 = changedText },
            label = { Text("Number 1") }
        )
        OutlinedTextField(inputText2, { changedText -> inputText2 = changedText },
            label = { Text("Number 2") }
        )
        Button(onClick = {
            // Here we are in an event handler, it is ok to perform side effects
//            val num1 = inputText1.toDoubleOrNull() ?: 0.0
//            val num2 = inputText2.toDoubleOrNull() ?: 0.0
//            val sum = num1 + num2
//            resultText = "Result: $sum"
//
            calculationTriggered(inputText1, inputText2)
        }) {
            Text("Calculate!")
        }
        Text("Result: $result")
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