package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    TextView recibenumero1, recibenumero2, texto, resultado;
    Button btnVolver;

    int n1, n2, r;
    String operacion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        recibenumero1 = findViewById(R.id.recibenunero1);
        recibenumero2 = findViewById(R.id.recibenunero2);
        texto = findViewById(R.id.texto);
        resultado = findViewById(R.id.resultado);
        btnVolver = findViewById(R.id.btnVolver);

        n1 = Integer.valueOf(getIntent().getExtras().getString("numero1"));
        n2 = Integer.valueOf(getIntent().getExtras().getString("numero2"));
        operacion = getIntent().getExtras().getString("operacion");
        switch (operacion){
            case "Suma":
                r = n1 + n2;
                break;
            case "Resta":
                r = n1 - n2;
                break;
            case "Multiplicacion":
                r = n1 * n2;
                break;
            case "Division":
                r = n1 / n2;
                break;
        }

        texto.setText("La "+operacion+" es:");
        resultado.setText(String.valueOf(r));

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}