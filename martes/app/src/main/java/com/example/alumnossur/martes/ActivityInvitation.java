package com.example.alumnossur.martes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ActivityInvitation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitation);
        Toolbar toolbar = findViewById(R.id.barraHerramientas);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("hola hola invitacion");
        getSupportActionBar().setSubtitle("hola subtitulo invitacion");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
