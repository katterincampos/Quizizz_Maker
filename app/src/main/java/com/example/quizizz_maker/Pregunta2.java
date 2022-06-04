package com.example.quizizz_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Pregunta2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta2);

        final EditText tPregunta = (EditText) this.findViewById(R.id.pregunta2_1);
        final EditText tCorrecto = (EditText) this.findViewById(R.id.respCorrecta_1_1);
        final EditText tIncorrecto1 = (EditText) this.findViewById(R.id.respIncorrecta_2_1);
        final EditText tIncorrecto2 = (EditText) this.findViewById(R.id.respIncorrecta_2_2);
        final EditText tIncorrecto3 = (EditText) this.findViewById(R.id.respIncorrecta_2_3);
        Button btnSave = (Button) this.findViewById(R.id.siguiente2);

        Bundle datosRecibidos = this.getIntent().getExtras();

        String nombre = datosRecibidos.getString("cNombre");
        String categoria = datosRecibidos.getString("cCat");
        String pregunta1 = datosRecibidos.getString("1cPregunta");
        String respCorrect1_ = datosRecibidos.getString("1cCorrecto");
        String respIncorrecta1_1 = datosRecibidos.getString("1cIncorrecto1");
        String respIncorrecta1_2 = datosRecibidos.getString("1cIncorrecto2");
        String respIncorrecta1_3 = datosRecibidos.getString("1cIncorrecto3");

        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String Preg = tPregunta.getText().toString();
                String RespCorr = tCorrecto.getText().toString();
                String RespInc1 = tIncorrecto1.getText().toString();
                String RespInc2 = tIncorrecto2.getText().toString();
                String RespInc3 = tIncorrecto3.getText().toString();


                Bundle pasarDatos1 = new Bundle();
                pasarDatos1.putString("cNombre",nombre);
                pasarDatos1.putString("cCat",categoria);
                pasarDatos1.putString("1cPregunta", pregunta1);
                pasarDatos1.putString("1cCorrecto", respCorrect1_);
                pasarDatos1.putString("1cIncorrecto1", respIncorrecta1_1);
                pasarDatos1.putString("1cIncorrecto2", respIncorrecta1_2);
                pasarDatos1.putString("1cIncorrecto3", respIncorrecta1_3);

                pasarDatos1.putString("2cPregunta", Preg);
                pasarDatos1.putString("2cCorrecto", RespCorr);
                pasarDatos1.putString("2cIncorrecto1", RespInc1);
                pasarDatos1.putString("2cIncorrecto2", RespInc2);
                pasarDatos1.putString("2cIncorrecto3", RespInc3);
                Intent siga = new Intent(Pregunta2.this, Pregunta3.class);

                siga.putExtras(pasarDatos1);
                startActivity(siga);
            }
        });
    }
}
