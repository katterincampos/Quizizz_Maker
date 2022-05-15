package com.example.quizizz_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Pregunta1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta1);

        final EditText tPregunta = (EditText) this.findViewById(R.id.Pregunta1);
        final EditText tCorrecto = (EditText) this.findViewById(R.id.RespCorrecta_1_1);
        final EditText tIncorrecto1 = (EditText) this.findViewById(R.id.RespIncorrecta_1_1);
        final EditText tIncorrecto2 = (EditText) this.findViewById(R.id.RespIncorrecta_1_2);
        final EditText tIncorrecto3 = (EditText) this.findViewById(R.id.RespIncorrecta_1_3);
        Button btnSave = (Button) this.findViewById(R.id.siguiente);

        Bundle datosRecibidos = this.getIntent().getExtras();

        String nombre = datosRecibidos.getString("cNombre");
        String categoria = datosRecibidos.getString("cCat");

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
                pasarDatos.putString("1cPregunta", Preg);
                pasarDatos.putString("1cCorrecto", RespCorr);
                pasarDatos.putString("1cIncorrecto1", RespInc1);
                pasarDatos.putString("1cIncorrecto2", RespInc2);
                pasarDatos.putString("1cIncorrecto3", RespInc3);
                Intent siga = new Intent(Pregunta1.this, Pregunta2.class);

                siga.putExtras(pasarDatos);
                startActivity(siga);
            }
        });
    }
}