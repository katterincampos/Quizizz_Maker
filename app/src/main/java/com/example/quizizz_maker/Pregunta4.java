package com.example.quizizz_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Pregunta4 extends AppCompatActivity {
    BaseDeDatos cuestionarios;
    String accion="nuevo";
    String Id="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta4);

        Button btnSave = (Button) this.findViewById(R.id.siguiente);

    }
    public void guardar_amigo(View v){
        final EditText tPregunta = (EditText) this.findViewById(R.id.NombreQuizz);
        final EditText tCorrecto = (EditText) this.findViewById(R.id.Categotia);
        final EditText tIncorrecto1 = (EditText) this.findViewById(R.id.NombreQuizz);
        final EditText tIncorrecto2 = (EditText) this.findViewById(R.id.Categotia);
        final EditText tIncorrecto3 = (EditText) this.findViewById(R.id.NombreQuizz);
        try{
            Bundle datosRecibidos = this.getIntent().getExtras();

            String Nombre = datosRecibidos.getString("cNombre");
            String categoria = datosRecibidos.getString("cCat");
            String pregunta1 = datosRecibidos.getString("1cPregunta");
            String respCorrect1_ = datosRecibidos.getString("1cCorrecto");
            String respIncorrecta1_1 = datosRecibidos.getString("1cIncorrecto1");
            String respIncorrecta1_2 = datosRecibidos.getString("1cIncorrecto2");
            String respIncorrecta1_3 = datosRecibidos.getString("1cIncorrecto3");

            String pregunta2 = datosRecibidos.getString("2cPregunta");
            String respCorrect2 = datosRecibidos.getString("2cCorrecto");
            String respIncorrecta2_1 = datosRecibidos.getString("2cIncorrecto1");
            String respIncorrecta2_2 = datosRecibidos.getString("2cIncorrecto2");
            String respIncorrecta2_3 = datosRecibidos.getString("2cIncorrecto3");

            String pregunta3 = datosRecibidos.getString("3cPregunta");
            String respCorrect3 = datosRecibidos.getString("3cCorrecto");
            String respIncorrecta3_1 = datosRecibidos.getString("3cIncorrecto1");
            String respIncorrecta3_2 = datosRecibidos.getString("3cIncorrecto2");
            String respIncorrecta3_3 = datosRecibidos.getString("3cIncorrecto3");

            String Preg = tPregunta.getText().toString();
            String RespCorr = tCorrecto.getText().toString();
            String RespInc1 = tIncorrecto1.getText().toString();
            String RespInc2 = tIncorrecto2.getText().toString();
            String RespInc3 = tIncorrecto3.getText().toString();

            cuestionarios = new BaseDeDatos(Pregunta4.this, "",null,1);
            cuestionarios.guardarCuestionario( Nombre, categoria,  pregunta1,respCorrect1_,respIncorrecta1_1,respIncorrecta1_2,respIncorrecta1_3,pregunta2,respCorrect2,respIncorrecta2_1,respIncorrecta2_2,respIncorrecta2_3,pregunta3,respCorrect3,respIncorrecta3_1,respIncorrecta3_2,respIncorrecta3_3,Preg,RespCorr,RespInc1,RespInc2,RespInc3,accion,Id);
            Toast.makeText(Pregunta4.this, "Listo, Cuestionario registrado con exito", Toast.LENGTH_LONG).show();
            Intent imostrar= new Intent(Pregunta4.this, MainActivity.class);
            startActivity(imostrar);
        }catch(Exception ex){
            Toast.makeText(Pregunta4.this, "Error: "+ ex.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
    }
}
