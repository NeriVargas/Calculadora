package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class CalcularActivity extends AppCompatActivity {

        EditText numero1,numero2;
        RadioButton suma,resta,multiplicacion,division;
        Button btnCalcular;
        String operacion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular);
        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);

        suma = findViewById(R.id.suma);
        resta = findViewById(R.id.resta);
        multiplicacion = findViewById(R.id.multiplicacion);
        division = findViewById(R.id.division);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numero1.getText().toString().length()>1){
                } else if (numero2.getText().toString().length()>1) {
                    Toast.makeText(getApplicationContext(), "ingresa numero 2", Toast.LENGTH_LONG).show();
                } else {
                    if(suma.isChecked())
                        operacion = "Suma";
                    if(resta.isChecked())
                        operacion = "Resta";
                    if(multiplicacion.isChecked())
                        operacion = "Multiplicacion";
                    if(division.isChecked())
                        operacion = "Division";
                    Intent i = new Intent(getApplicationContext(),ResultadoActivity.class);
                    i.putExtra("numero1", numero1.getText().toString());
                    i.putExtra("numero2", numero2.getText().toString());
                    i.putExtra("operacion", operacion);
                    startActivity(i);

                }
            }
        });
    }
}