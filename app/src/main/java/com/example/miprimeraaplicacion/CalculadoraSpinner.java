package com.example.miprimeraaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CalculadoraSpinner extends AppCompatActivity implements View.OnClickListener {

    EditText edtNumero1;
    EditText edtNumero2;
    EditText edtResultado;
    Spinner spOperacion;
    Button btnCalcular;
    Button btnMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_spinner);

        edtNumero1 = findViewById(R.id.edtNumero1);
        edtNumero2 = findViewById(R.id.edtNumero2);
        edtResultado = findViewById(R.id.edtResultado);
        spOperacion = findViewById(R.id.spOperacion);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnMensaje = findViewById(R.id.btnMensaje);

        btnCalcular.setOnClickListener(this);
        btnMensaje.setOnClickListener(this);
    }

    private void calcularOperacion() {
        double numero1 = 0;
        double numero2 = 0;
        int operacion = 0;
        try {
            numero1 = Double.parseDouble(edtNumero1.getText().toString());
            numero2 = Double.parseDouble(edtNumero2.getText().toString());
            operacion = spOperacion.getSelectedItemPosition();
        } catch (Exception e) {
            Log.e("TAG", e.toString());
        }

        String resultado = "";

        switch (operacion) {
            case 0:
                resultado = String.valueOf(numero1 + numero2);
                break;
            case 1:
                resultado = String.valueOf(numero1 - numero2);
                break;
            case 2:
                resultado = String.valueOf(numero1 * numero2);
                break;
            case 3:
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCalcular:
                calcularOperacion();
                break;
            case R.id.btnMensaje:
                Toast.makeText(this, "Hola, esta es mi primera Aplicación Móvil.", Toast.LENGTH_LONG).show();;
                break;
        }
    }
}