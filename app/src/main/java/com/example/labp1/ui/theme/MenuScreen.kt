package com.example.labp1.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.labp1.R

@Composable
fun MenuScreen(
    navController : NavController
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp)
        )
        {
            TopBar("Sensor App")

            Spacer(modifier = Modifier.size(40.dp))

            TextComponent(
                textValue = "Wybierz sensor:",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(60.dp))
            Row(modifier = Modifier.fillMaxWidth()) {

                Spacer(modifier = Modifier.width(35.dp))

                TextComponent(
                    textValue = "Sensor1",
                    textSize = 24.sp
                )

                Spacer(modifier = Modifier.width(60.dp))

                TextComponent(
                    textValue = "Sensor2",
                    textSize = 24.sp
                )

            }

            Row(modifier = Modifier.fillMaxWidth()) {

                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(20.dp)
                        .size(110.dp),
                    elevation = 4.dp
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = 1.dp,
                                color = Color.Green,
                                shape = RoundedCornerShape(8.dp)
                            )

                    ) {
                        Image(

                            modifier = Modifier
                                .padding(16.dp)
                                .wrapContentHeight()
                                .wrapContentWidth()
                                .clickable {
                                    navController.navigate(route = Routes.FIRST_SENSOR_SCREEN)
                                },
                            painter = painterResource(id = R.drawable.sensor1),
                            contentDescription = "Sensor"
                        )


//                    Button(
//                        modifier = Modifier.fillMaxWidth(),
//                        onClick = { navController.navigate(route = Routes.WELCOME_SCREEN) }) {
//                        TextComponent(textValue = "Go to sensor", textSize = 18.sp)
//                    }

//                ButtonComponent(navController = rememberNavController(),
//                    goToDetailsScreen = {
//                        Pair(
//                            userInputViewModel.uiState.value.sensorSelected,
//                            userInputViewModel.uiState.value.sensorSelected
//                        )
//                    }
//
//                )


//                TextComponent(
//                textValue = "Wzrost",
//                textSize = 24.sp
//                )
//
//                TextInputComponent(
//                placeholderText = "Podaj swój wzrost",
//                onTextChanged = {userInputViewModel.onEvent(UserDataUiEvents.UserHeightEntered(it.toFloat()))
//                })
//
//                Spacer(modifier = Modifier.size(60.dp))
//
//                TextComponent(
//                textValue = "Waga",
//                textSize = 24.sp
//                )
//
//                TextInputComponent(
//                placeholderText = "Podaj swoją wage",
//                onTextChanged = {userInputViewModel.onEvent(UserDataUiEvents.UserWeightEntered(it.toFloat()))
//                })
                    }
                }

                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(20.dp)
                        .size(110.dp),
                    elevation = 4.dp
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = 1.dp,
                                color = Color.Green,
                                shape = RoundedCornerShape(8.dp)
                            )

                    ) {
                        Image(

                            modifier = Modifier
                                .padding(16.dp)
                                .wrapContentHeight()
                                .wrapContentWidth()
                                .clickable {
                                    navController.navigate(route = Routes.SECOND_SENSOR_SCREEN)
                                },
                            painter = painterResource(id = R.drawable.sensor2),
                            contentDescription = "Sensor2"
                        )
                    }
                }
            }

        }
    }

}

@Preview
@Composable
fun MenuScreenPreview(){
    MenuScreen(navController = rememberNavController())
}

