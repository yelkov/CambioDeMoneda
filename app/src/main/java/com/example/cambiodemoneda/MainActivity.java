package com.example.cambiodemoneda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnCambiar;

    EditText etValor;
    RadioGroup rgCambio;
    RadioButton rbtPtasEuros, rbtEurosPtas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarViews();

        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etValor.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, getString(R.string.toast_values), Toast.LENGTH_LONG).show();
                    return;
                }
                Float valor = Float.parseFloat(String.valueOf(etValor.getText()));
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                if(rbtPtasEuros.isChecked()){
                    intent.putExtra("Ptas",valor);
                }else if(rbtEurosPtas.isChecked()){
                    intent.putExtra("Euros",valor);
                }
                startActivity(intent);
            }
        });
    }

    private void inicializarViews() {
        btnCambiar = findViewById(R.id.btnCambiar);
        etValor = findViewById(R.id.etValor);
        rgCambio = findViewById(R.id.rgCambio);
        rbtEurosPtas = findViewById(R.id.rbtEurosPtas);
        rbtPtasEuros = findViewById(R.id.rbtPtasEuros);
    }
}