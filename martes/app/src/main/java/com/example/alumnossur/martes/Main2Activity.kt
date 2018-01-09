package com.example.alumnossur.martes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val toolbar = findViewById<Toolbar>(R.id.barraHerramientas)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "hola kotlin!"
        supportActionBar!!.subtitle = "esta es la unica actividad en kotlin"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}
