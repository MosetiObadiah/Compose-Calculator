package com.ox55.calculator

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.window.layout.WindowMetricsCalculator
import com.ox55.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Calc()
            }
        }
    }
}

@Composable
fun Calc() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    println("Screen localConfiguration width: $screenWidth dp")
    println("Screen localConfiguration height: $screenHeight dp")

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            Modifier.padding(innerPadding)
        ) {
           Column(
               Modifier
                   .padding(5.dp)
                   .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
                   .fillMaxHeight(0.3f)
                   .defaultMinSize(convertPixelsToDp(LocalContext.current, screenWidth * 2).dp, convertPixelsToDp(LocalContext.current, screenHeight).dp)
                   .background(Color.Cyan)
           ) {

           }
            Column(
                Modifier
                    .padding(5.dp)
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
                    .fillMaxHeight(1f)
                    .defaultMinSize(convertPixelsToDp(LocalContext.current, screenWidth * 2).dp, convertPixelsToDp(LocalContext.current, screenHeight).dp)
                    .background(Color.Cyan)
            ) {

            }
        }
    }
}

fun convertPixelsToDp(context: Context, pixels: Int): Float {
    val screenPixelDensity = context.resources.displayMetrics.density
    val dpValue = pixels / screenPixelDensity
    println("dp value $dpValue")
    return dpValue
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CalcPreview() {
    Calc()
}