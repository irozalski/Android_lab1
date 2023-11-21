package com.example.labp1.ui.theme

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


class LightSensorViewModel(private val context: Context) : ViewModel(), SensorEventListener {

    companion object {
        fun create(context: Context): LightSensorViewModel {
            return LightSensorViewModel(context)
        }
    }

    private val sensorManager: SensorManager by lazy {
        context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }
    private val lightSensor: Sensor? by lazy {
        sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
    }

    private val _lightValues = mutableStateOf(0f)
    val lightValues: State<Float> = _lightValues

    init {
        lightSensor?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            _lightValues.value = it.values[0]
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    fun stopListening() {
        lightSensor?.let {
            sensorManager.unregisterListener(this, it)
        }
    }
}



@Composable
fun FirstSensorScreen(lightSensorViewModel: LightSensorViewModel = viewModel()){

    val lightValues by lightSensorViewModel.lightValues
    val threshold = 1000f

    DisposableEffect(lightSensorViewModel) {
        onDispose {
            lightSensorViewModel.stopListening()
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(
            if(lightValues>threshold) Color.DarkGray else Color.White)
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