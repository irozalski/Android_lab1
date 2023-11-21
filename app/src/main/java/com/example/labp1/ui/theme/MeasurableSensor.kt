package com.example.labp1.ui.theme

abstract class MeasurableSensor(
    protected val sensorType : Int

) {

    protected var onSensorValuesChanged: ((List<Float>) -> Unit)? = null

    abstract val doesSensorExist: Boolean

    abstract fun startListening()
    abstract fun stopListening()

    fun setonSensorValuesChangedListener(listener: (List<Float>) -> Unit){
        onSensorValuesChanged = listener
    }
}