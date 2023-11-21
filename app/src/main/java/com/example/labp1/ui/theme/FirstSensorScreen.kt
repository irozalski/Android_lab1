package com.example.labp1.ui.theme

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class LightSensor(
    context: Context
): AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_LIGHT,
    sensorType = Sensor.TYPE_LIGHT
)



@Composable
fun FirstSensorScreen(){
    val viewModel = viewModel<MainViewModel>()
    val isDark = viewModel.isDark
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(
            if(isDark) Color.DarkGray else Color.White)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            text = "Sensor11111")
    }
}

@Preview
@Composable
fun WelcomeScreenPreview(){
    FirstSensorScreen()
}