package com.raja.jetpackcompose.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.compose.AppTheme
import com.raja.hotelbooking.splash.SplashScreenBackgroundDesign
import com.raja.jetpackcompose.R
import com.raja.jetpackcompose.navigation.AppNavController
import com.raja.jetpackcompose.navigation.NavInfo
import com.raja.jetpackcompose.navigation.NavManager
import com.raja.jetpackcompose.navigation.Route
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject

@AndroidEntryPoint
class SplashScreen : ComponentActivity() {

    @Inject
    lateinit var navManager: NavManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                SplashScreenDesign()
                SetupAppNavController(navManager)
            }
        }
    }
}

@Composable
fun SplashScreenDesign(splashViewModel: SplashScreenViewModel = hiltViewModel()) {

    val texts = listOf("Please wait...","Welcome!, Let's have plan today!!")
    var visibleIndex by remember {
        mutableStateOf(-1)
    }

    val textMeasure = remember {
        mutableStateOf(0)
    }

    /*For Showing App Name after Lottie Animation*/
    var showHolidayPlan by remember {
        mutableStateOf(false)
    }

    var showHolidayQuotes by remember {
        mutableStateOf(false)
    }

    // Launch a coroutine to update visibleIndex
    LaunchedEffect(Unit) {
        delay(500)
        showHolidayPlan = true

        delay(500)
        showHolidayQuotes = true
        for (index in texts.indices) {
            delay(800) // Delay between texts
            visibleIndex = index
        }
    }








    Box (modifier =
    Modifier
        .fillMaxWidth()
        .padding(4.dp)) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /*Image(
            painter = painterResource(id = R.drawable.icon_launcher), // Your splash screen icon
            contentDescription = "App Logo",
            modifier = Modifier.size(100.dp) // Adjust the size as needed
        )*/

            val compositions by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.holiday_anim))
            val progress by animateLottieCompositionAsState(composition = compositions, iterations = 1, speed = 1.0f, restartOnPlay = true)
            LottieAnimation(
                composition = compositions,
                progress = { progress },
                modifier = Modifier.fillMaxSize(0.4f)
            )

            LaunchedEffect(key1 = progress){
                if(progress == 1.0f){
                    splashViewModel.navManager.navigate(NavInfo(id = Route.MAINHOMENAVIGATION.MainHomeNavView,
                        navOptions = NavOptions.Builder().setPopUpTo(Route.SPLASHSCREEN.SplashView, inclusive = true).build()))
                }
            }
            Spacer(modifier = Modifier.padding(4.dp))


            AnimatedVisibility(visible = showHolidayPlan) {
                Text(
                    text = "Holiday Plan",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(vertical = 4.dp) // Adjust spacing as needed
                        .onGloballyPositioned { coordinates ->
                            if (coordinates.size.width > textMeasure.value)
                                textMeasure.value = coordinates.size.width
                        }// Center align the texts
                )
            }


            AnimatedVisibility(visible = showHolidayQuotes) {
                Text(
                    text = "Lets have some plan to explore the world!",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(vertical = 4.dp) // Adjust spacing as needed
                        .onGloballyPositioned { coordinates ->
                            if (coordinates.size.width > textMeasure.value)
                                textMeasure.value = coordinates.size.width
                        }// Center align the texts
                )



            }



        }
        Box(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .align(Alignment.BottomEnd)

        ) {
            texts.forEachIndexed { index, text ->
              AnimatedVisibility(
                    visible = index == visibleIndex,
                    enter = fadeIn(animationSpec = tween(durationMillis = 1000)),
                    exit = fadeOut(animationSpec = tween(durationMillis = 500)),
                  modifier = Modifier.align(Alignment.Center)
                ) {
                    Text(
                        text = text,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .padding(vertical = 4.dp) // Adjust spacing as needed
                            .onGloballyPositioned { coordinates ->
                                if (coordinates.size.width > textMeasure.value)
                                    textMeasure.value = coordinates.size.width
                            }// Center align the texts
                    )

                }
            }
        }
    }
}

@Composable
fun MyAppTheme(content: @Composable () -> Unit) {
    MaterialTheme {
        // You can use your custom theme here
        content()

    }
}


@Composable
fun SetupAppNavController(navManager: NavManager){

    val navController = rememberNavController()

    AppNavController(navHostController = navController)

    val navInfo by navManager.route.collectAsState()
    LaunchedEffect(key1 = navInfo){
        navInfo.id?.let {
            navController.navigate(it, navInfo.navOptions)
            navManager.navigate(null)
        }







    }
}

@Preview
@Composable
fun SplashScreenPreview(){
    SplashScreenDesign(splashViewModel = SplashScreenViewModel(navManager = NavManager()))
   // SplashScreenBackgroundDesign()
}