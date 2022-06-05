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

        Bundle datosRecibidos = this.getIntent().getExtras();

        String nombre = datosRecibidos.getString("cNombre");
        String categoria = datosRecibidos.getString("cCat");
        String pregunta1 = datosRecibidos.getString("1cPregunta");
        String respCorrect1_ = datosRecibidos.getString("1cCorrecto");
        String respIncorrecta1_1 = datosRecibidos.getString("1cIncorrecto1");
        String respIncorrecta1_2 = datosRecibidos.getString("1cIncorrecto2");
        String respIncorrecta1_3 = datosRecibidos.getString("1cIncorrecto3");

        String pregunta2_ = datosRecibidos.getString("2cPregunta");
        String respCorrect2_1 = datosRecibidos.getString("2cCorrecto");
        String respIncorrecta2_1 = datosRecibidos.getString("2cIncorrecto1");
        String respIncorrecta2_2 = datosRecibidos.getString("2cIncorrecto2");
        String respIncorrecta2_3 = datosRecibidos.getString("2cIncorrecto3");

        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String Preg = tPregunta.getText().toString();
                String RespCorr = tCorrecto.getText().toString();
                String RespInc1 = tIncorrecto1.getText().toString();
                String RespInc2 = tIncorrecto2.getText().toString();
                String RespInc3 = tIncorrecto3.getText().toString();


                Bundle pasarDatos = new Bundle();
                pasarDatos.putString("cNombre",nombre);
                pasarDatos.putString("cCat",categoria);
                pasarDatos.putString("1cPregunta", pregunta1);
                pasarDatos.putString("1cCorrecto", respCorrect1_);
                pasarDatos.putString("1cIncorrecto1", respIncorrecta1_1);
                pasarDatos.putString("1cIncorrecto2", respIncorrecta1_2);
                pasarDatos.putString("1cIncorrecto3", respIncorrecta1_3);

                pasarDatos.putString("2cPregunta", pregunta2_);
                pasarDatos.putString("2cCorrecto", respCorrect2_1);
                pasarDatos.putString("2cIncorrecto1", respIncorrecta2_1);
                pasarDatos.putString("2cIncorrecto2", respIncorrecta2_2);
                pasarDatos.putString("2cIncorrecto3", respIncorrecta2_3);

                pasarDatos.putString("3cPregunta", Preg);
                pasarDatos.putString("3cCorrecto", RespCorr);
                pasarDatos.putString("3cIncorrecto1", RespInc1);
                pasarDatos.putString("3cIncorrecto2", RespInc2);
                pasarDatos.putString("3cIncorrecto3", RespInc3);
                Intent siga = new Intent(Pregunta3.this, Pregunta4.class);

                siga.putExtras(pasarDatos);
                startActivity(siga);
            }
        });
    }
}