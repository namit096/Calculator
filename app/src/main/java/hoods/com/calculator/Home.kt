package hoods.com.calculator

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hoods.com.calculator.ui.theme.CalculatorTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeCalculator(calculatorViewModel: CalculatorViewModel?) {
    val uiState = calculatorViewModel?.uiState
    Box(modifier = Modifier.fillMaxSize()) {
        val contentMargin = 16.dp



        Column(modifier = Modifier.align(Alignment.BottomCenter)) {

            Box(modifier = Modifier,
                contentAlignment = Alignment.BottomEnd
            ){
                Surface(
                    shape = RoundedCornerShape(bottomEnd = 30.dp , bottomStart = 30.dp),
                    color = Color(32,91,122),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(210.dp)
//                        .fillMaxHeight()
//                        .weight(1f)
                ) {
//                    Text("Namit", color = Color(237, 234, 208))
                }

                Column(
                    modifier = Modifier
                        .padding(horizontal = contentMargin),
//                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = uiState?.infix ?: "-20+60/-5*(20-5)",
                        color = Color.White,
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.Light,
                        fontFamily = FontFamily.Monospace
                    )
                    Spacer(modifier = Modifier.size(contentMargin))
                    Text(
                        text = uiState?.result ?: "-200",
                        color = Color.White,
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.End),
                        fontFamily = FontFamily.Monospace
                    )
                    Spacer(modifier = Modifier.size(23.dp))
                }

            }



            Row {
                val numbers = listOf(
                    "AC", "(", ")", "^",
                    "7", "8", "9", "*",
                    "4", "5", "6", "/",
                    "1" , "2" , "3", "+",
                    "0", ".", "=", "-"
                )


                LazyVerticalGrid(
                    cells = GridCells.Fixed(4),
                    modifier = Modifier
                        .weight(1f)
                ) {
                    items(numbers) { number ->

                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .background(Color.White),
                            contentAlignment = Alignment.Center
                        ){
                            CharacterItem(
                                char = number,
                                modifier = Modifier
                                    .padding(top = 10.dp, bottom = 10.dp)
                                    .height(88.dp)
                                    .width(93.dp)
                                ) {

                                if(number == "=") {
                                    calculatorViewModel?.evaluateExpression()
                                }
                                else if (number != "AC")
                                {
                                calculatorViewModel?.onInfixChange(number)
                                }
                                else{
                                    calculatorViewModel?.clearInfixExpression()
                                }

                            }
                        }


                    }


                }

//            ConstraintLayout(modifier = Modifier.weight(.8f)) {
//            val (addition, multiplication,
//                division, minus, power, equal) = createRefs()
//                CharacterItem(
//                    char = "-",
//                    modifier = Modifier
//                        .height(50.dp)
//                        .constrainAs(minus){
//                            top.linkTo(parent.top)
//                            start.linkTo(parent.start)
//                            end.linkTo(division.start)
//                            bottom.linkTo(addition.top)
//                        }
//                        .aspectRatio(1f)
//                    ,
//                    color = MaterialTheme.colors.secondary
//                ) {
//                    calculatorViewModel?.onInfixChange("-")
//                }
//                CharacterItem(
//                    char = "/",
//                    modifier = Modifier
//                        .height(50.dp)
//                        .constrainAs(division){
//                            top.linkTo(parent.top)
//                            start.linkTo(minus.end,contentMargin)
//                            end.linkTo(parent.end,contentMargin)
//                        }
//                        .aspectRatio(1f)
//                    ,
//                    color = MaterialTheme.colors.secondary
//                ) {
//                    calculatorViewModel?.onInfixChange("/")
//                }
//
//                CharacterItem(
//                    char = "*",
//                    modifier = Modifier
//                        .height(50.dp)
//                        .constrainAs(multiplication){
//                            top.linkTo(division.bottom,contentMargin)
//                            start.linkTo(addition.end)
//                            end.linkTo(parent.end)
//                            bottom.linkTo(power.top)
//                        }
//                        .aspectRatio(1f)
//                    ,
//                    color = MaterialTheme.colors.secondary
//                ) {
//                    calculatorViewModel?.onInfixChange("*")
//                }
//                CharacterItem(
//                    char = "^",
//                    modifier = Modifier
//                        .height(50.dp)
//                        .constrainAs(power){
//                            top.linkTo(multiplication.bottom,contentMargin)
//                            start.linkTo(addition.end,contentMargin)
//                            end.linkTo(parent.end,contentMargin)
//                            bottom.linkTo(equal.top)
//                        }
//                        .aspectRatio(1f)
//                    ,
//                    color = MaterialTheme.colors.secondary
//                ) {
//                    calculatorViewModel?.onInfixChange("^")
//                }
//
//                CharacterItem(
//                    char = "+",
//                    modifier = Modifier
//                        .width(50.dp)
//                        .constrainAs(addition){
//                            top.linkTo(minus.bottom,contentMargin)
//                            start.linkTo(parent.start)
//                            end.linkTo(multiplication.start)
//                            bottom.linkTo(equal.top,contentMargin)
//                        }
//                        .aspectRatio(1f / 2f)
//                    ,
//                    color = MaterialTheme.colors.secondary
//                ) {
//                    calculatorViewModel?.onInfixChange("+")
//                }
//                CharacterItem(
//                    char = "=",
//                    modifier = Modifier
//                        .height(50.dp)
//                        .constrainAs(equal){
//                            top.linkTo(power.bottom,contentMargin)
//                            start.linkTo(parent.start)
//                            end.linkTo(parent.end,contentMargin)
//                            bottom.linkTo(parent.bottom)
//                        }
//                        .aspectRatio(2f / 1f)
//                    ,
//                    color = MaterialTheme.colors.secondary
//                ) {
//                   calculatorViewModel?.evaluateExpression()
//                }
//            }


            }


        }


    }


}


@Composable
fun CharacterItem(
    char: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.surface,
    onClick: () -> Unit,
) {
    Surface(
        shape = RoundedCornerShape(30.dp),
        color = Color(162,187,207),
//        elevation : 2.dp,
        modifier = modifier
            .clickable {
                onClick.invoke()
            }
    ) {
        Box(contentAlignment = Alignment.Center
        ) {
            Text(
                text = char,
                modifier = Modifier
                    .padding(8.dp),
                fontSize  = 32.sp,
                fontFamily = FontFamily.Monospace,
//                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.button
            )
        }

    }


}



@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Calculator",
                    fontSize = 24.sp,
                    fontFamily = FontFamily.Monospace,

//                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier.fillMaxWidth() . height(40.dp) .background(Color(32,91,122))
    )
}

@Preview(showSystemUi = true)
@Composable
fun PrevHomeCalculator() {
    CalculatorTheme {
        Scaffold(
            topBar = {
                WoofTopAppBar()
            }
        ) {it->
            Surface(modifier = Modifier.fillMaxSize(),
                color = Color(32,91,122)) {

                HomeCalculator(calculatorViewModel = null)
            }
        }

//        HomeCalculator(calculatorViewModel = null)
    }
}



























