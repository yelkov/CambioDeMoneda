package com.example.cambiodemoneda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {
    Button btnVolver;
    TextView tvResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        inicializarViews();
        Intent intent = getIntent();
        String resultado;

        if(intent.hasExtra("Ptas")){
            Float valorPtas = intent.getFloatExtra("Ptas",0.0f);
            resultado = String.format("%.2f",calcularEuros(valorPtas));
            tvResultado.setText(valorPtas+" "+ getString(R.string.resultado_ptas_to_euros) + resultado + getString(R.string.resultado_euros));
        }else if(intent.hasExtra("Euros")){
            Float valorEuros = intent.getFloatExtra("Euros",0.0f);
            resultado = String.format("%.2f",calcularPtas(valorEuros));
            tvResultado.setText(valorEuros + getString(R.string.resultado_euros_to_pts) + resultado + getString(R.string.resultado_ptas));
        }

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void inicializarViews() {
        btnVolver = findViewById(R.id.btnVolver);
        tvResultado = findViewById(R.id.tvResultado);
    }

    private float calcularEuros(Float valorPtas){
        return valorPtas / 166;
    }

    private float calcularPtas(Float valorEuros){
        return valorEuros * 166;
    }
}