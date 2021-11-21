package com.example.miprimeraaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtNumero1;
    EditText edtNumero2;
    EditText edtResultado;
    EditText edtOperacion;
    Button btnCalcular;
    Button btnNavegar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumero1 = findViewById(R.id.edtNumero1);
        edtNumero2 = findViewById(R.id.edtNumero2);
        edtResultado = findViewById(R.id.edtResultado);
        edtOperacion = findViewById(R.id.edtOperacion);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnNavegar = findViewById(R.id.btnNavegar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ejecute cuando presionemos el boton
                calcularOperacion();
            }
        });

        btnNavegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navegar();
            }
        });
    }

    private void navegar() {
        Intent intent = new Intent(this, CalculadoraSpinner.class);
        startActivity(intent);
    }

    private void calcularOperacion() {
        double numero1 = 0;
        double numero2 = 0;
        String operacion = "";

        try {
            numero1 = Double.parseDouble(edtNumero1.getText().toString());
            numero2 = Double.parseDouble(edtNumero2.getText().toString());
            operacion = edtOperacion.getText().toString();
        } catch (Exception e) {
            Log.e("TAG", e.toString());
        }

        String resultado = "";

        switch (operacion.toLowerCase()) {
            case "suma":
                resultado = String.valueOf(numero1 + numero2);
                break;
            case "resta":
                resultado = String.valueOf(numero1 - numero2);
                break;
            case "multiplicacion":
                resultado = String.valueOf(numero1 * numero2);
                break;
            case "division":
                if (numero2 == 0){
                    resultado = "No se puede dividir entre 0";
                } else {
                    resultado = String.valueOf(numero1 / numero2);
                }
                break;
            default:
                resultado = "Operacion incorrecta";
                break;
        }

        edtResultado.setText(resultado);
    }
}