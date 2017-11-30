package com.accelerometer_android_test.cal.accelerometer_android_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView xText, yText, zText;
    private Sensor mySensor;
    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create sensor manager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        //Accelerometer sensor
        mySensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Register sensor listener
        sensorManager.registerListener(this, mySensor,SensorManager.SENSOR_DELAY_NORMAL);

        //Assign Textview
        xText = (TextView) findViewById(R.id.xText);
        yText = (TextView) findViewById(R.id.yText);
        zText = (TextView) findViewById(R.id.zText);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // not use
    }
}
