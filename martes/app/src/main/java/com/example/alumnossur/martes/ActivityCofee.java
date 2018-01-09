package com.example.alumnossur.martes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityCofee extends AppCompatActivity {

    private EditText txtNombre;
    private CheckBox chkOpcion1;
    private CheckBox chkOpcion2;
    private TextView txtNumero;
    private int cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cofee);
        Toolbar toolbar = findViewById(R.id.barraHerramientas);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("hola hola titulo cafe");
        getSupportActionBar().setSubtitle("sirvase un cafeee");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtNombre = findViewById(R.id.txtNombre);
        chkOpcion1 = findViewById(R.id.chkOpcion1);
        chkOpcion2 = findViewById(R.id.chkOpcion2);
        txtNumero = findViewById(R.id.txtNumero);
        cantidad = 1;
        txtNumero.setText(String.valueOf(cantidad));
    }
    public void clickBtnMas(View view) {
        if (cantidad < 10) {
            cantidad++;
            txtNumero.setText(String.valueOf(cantidad));
        }
    }
    public void clickBtnMenos(View view) {
        if (cantidad > 1) {
            cantidad--;
            txtNumero.setText(String.valueOf(cantidad));
        }
    }
    public void clickBtnListo(View view) {
        if(!txtNombre.getText().toString().isEmpty()) {
            int totalUnitario = 10;
            if (chkOpcion1.isChecked())
                totalUnitario += 4;
            if (chkOpcion2.isChecked())
                totalUnitario += 5;
            totalUnitario *= cantidad;
            Toast.makeText(this, "total: " + String.valueOf(totalUnitario), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "ingrese nombre!!!!!", Toast.LENGTH_LONG).show();
        }
    }
}
