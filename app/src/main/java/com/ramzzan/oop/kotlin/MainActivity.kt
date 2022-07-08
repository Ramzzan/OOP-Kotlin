package com.ramzzan.oop.kotlin

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.ramzzan.oop.kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val engine = Engine()
        val carBrand = BMW()

        val car = Car(engine, carBrand)
        car.startCar()
        car.printCarBrand()
        car.flashLight()
    }


}


private const val TAG = "Demo"

class Car(private val engine: Engine, private val carBrand: CarBrand) {

    fun printCarBrand() {
        Log.d(TAG, carBrand.getCarBrand())
    }
    fun startCar() {
        Log.d(TAG, engine.start())
        Log.d(TAG, "start Car")
    }

    fun flashLight() {
        Log.d(TAG, "flash Light")
    }

}

class Engine {

    fun start(): String {
        return "Starting Engine"
    }
}

class BMW: CarBrand {
    override fun getCarBrand(): String {
      return "BMW M2"
    }

}

interface CarBrand {
    fun getCarBrand(): String
}