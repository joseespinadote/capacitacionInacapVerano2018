package com.example.alumnossur.martes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.barraHerramientas);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("hola hola titulo");
        getSupportActionBar().setSubtitle("hola subtitulo");
    }

    public void lanzaInvitacion(View view) {
        Intent i = new Intent(this, ActivityInvitation.class);
        startActivity(i);
    }

    public void lanzaOtraActividad(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }

    public void lanzaActividadCafe(View view) {
        Intent i = new Intent(this, ActivityCofee.class);
        startActivity(i);
    }

    public void lanzaActividadTe(View view) {
    }
}
