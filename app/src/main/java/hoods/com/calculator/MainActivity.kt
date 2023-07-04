package hoods.com.calculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import hoods.com.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<CalculatorViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val infix = "20+3*2*(2-4)"
            val result = Model().result(infix)
            Log.i("MainActivity", "onCreate:The postFIx is $result")
            CalculatorTheme {
                Scaffold(
                    topBar = {
                        WoofTopAppBar()
                    }
                ) { it ->
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color(32, 91, 122)
                    ) {
                        HomeCalculator(calculatorViewModel = viewModel)
                    }
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorTheme {

    }
}