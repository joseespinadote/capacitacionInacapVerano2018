package com.example.alumnossur.martes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.alumnossur.martes.adapter.TeAdapter;
import com.example.alumnossur.martes.modelo.Te;

public class ActivityTea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea);
        RecyclerView rv = findViewById(R.id.recycleTe);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        rv.setAdapter(new TeAdapter(Te.getLista(), R.layout.tarjeta_te, this));
    }
}
