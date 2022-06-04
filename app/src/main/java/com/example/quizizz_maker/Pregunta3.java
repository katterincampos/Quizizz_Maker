package com.example.quizizz_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Pregunta3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta3);

        final EditText tPregunta = (EditText) this.findViewById(R.id.pregunta3);
        final EditText tCorrecto = (EditText) this.findViewById(R.id.respCorrecta_2_1);
        final EditText tIncorrecto1 = (EditText) this.findViewById(R.id.respIncorrecta_3_1);
        final EditText tIncorrecto2 = (EditText) this.findViewById(R.id.respIncorrecta_3_2);
        final EditText tIncorrecto3 = (EditText) this.findViewById(R.id.respIncorrecta_3_3);
        Button btnSave = (Button) this.findViewById(R.id.siguiente3);

        Bundle datosRecibidos1 = this.getIntent().getExtras();

        String nombre = datosRecibidos1.getString("cNombre");
        String categoria = datosRecibidos1.getString("cCat");
        String pregunta1 = datosRecibidos1.getString("1cPregunta");
        String respCorrect1_ = datosRecibidos1.getString("1cCorrecto");
        String respIncorrecta1_1 = datosRecibidos1.getString("1cIncorrecto1");
        String respIncorrecta1_2 = datosRecibidos1.getString("1cIncorrecto2");
        String respIncorrecta1_3 = datosRecibidos1.getString("1cIncorrecto3");

        String pregunta2_ = datosRecibidos1.getString("2cPregunta");
        String respCorrect2_1 = datosRecibidos1.getString("2cCorrecto");
        String respIncorrecta2_1 = datosRecibidos1.getString("2cIncorrecto1");
        String respIncorrecta2_2 = datosRecibidos1.getString("2cIncorrecto2");
        String respIncorrecta2_3 = datosRecibidos1.getString("2cIncorrecto3");

        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String Preg = tPregunta.getText().toString();
                String RespCorr = tCorrecto.getText().toString();
                String RespInc1 = tIncorrecto1.getText().toString();
                String RespInc2 = tIncorrecto2.getText().toString();
                String RespInc3 = tIncorrecto3.getText().toString();


                Bundle pasarDatos2 = new Bundle();
                pasarDatos2.putString("cNombre",nombre);
                pasarDatos2.putString("cCat",categoria);
                pasarDatos2.putString("1cPregunta", pregunta1);
                pasarDatos2.putString("1cCorrecto", respCorrect1_);
                pasarDatos2.putString("1cIncorrecto1", respIncorrecta1_1);
                pasarDatos2.putString("1cIncorrecto2", respIncorrecta1_2);
                pasarDatos2.putString("1cIncorrecto3", respIncorrecta1_3);

                pasarDatos2.putString("2cPregunta", pregunta2_);
                pasarDatos2.putString("2cCorrecto", respCorrect2_1);
                pasarDatos2.putString("2cIncorrecto1", respIncorrecta2_1);
                pasarDatos2.putString("2cIncorrecto2", respIncorrecta2_2);
                pasarDatos2.putString("2cIncorrecto3", respIncorrecta2_3);

                pasarDatos2.putString("3cPregunta", Preg);
                pasarDatos2.putString("3cCorrecto", RespCorr);
                pasarDatos2.putString("3cIncorrecto1", RespInc1);
                pasarDatos2.putString("3cIncorrecto2", RespInc2);
                pasarDatos2.putString("3cIncorrecto3", RespInc3);
                Intent siga = new Intent(Pregunta3.this, Pregunta4.class);

                siga.putExtras(pasarDatos2);
                startActivity(siga);
            }
        });
    }
}