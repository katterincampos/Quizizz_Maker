package com.example.quizizz_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Creacion_Cuestionarios extends AppCompatActivity {

    BaseDeDatos cuestionarios;
    String accion="nuevo";
    String Id="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_cuestionarios);

     }
    public void mostrardatos(){
        try {
            Bundle bundle = getIntent().getExtras();
            accion = bundle.getString("accion");
            if (accion.equals("modificar")) {
                Id = bundle.getString("id");
                String user[] = bundle.getStringArray("user");
                TextView tempVal = (TextView) findViewById(R.id.Pregunta);
                tempVal.setText(user[0].toString());
                tempVal = (TextView) findViewById(R.id.RespuestaCorrecta);
                tempVal.setText(user[1].toString());
                tempVal = (TextView) findViewById(R.id.RespIncor1);
                tempVal.setText(user[2].toString());
            }
        }catch (Exception e){
            Toast.makeText(Creacion_Cuestionarios.this, "Error: "+ e.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
        }

    }
    public void guardar_amigo(View v){
        try{
            TextView tempVal = (TextView)findViewById(R.id.Pregunta);
            String nom = tempVal.getText().toString();
            tempVal = (TextView)findViewById(R.id.RespuestaCorrecta);
            String RespC = tempVal.getText().toString();
            tempVal = (TextView)findViewById(R.id.RespIncor1);
            String RespInc1 = tempVal.getText().toString();
            tempVal = (TextView)findViewById(R.id.RespIncor2);
            String RespInc2 = tempVal.getText().toString();
            tempVal = (TextView)findViewById(R.id.RespIncor3);
            String RespInc3 = tempVal.getText().toString();
            cuestionarios = new BaseDeDatos(Creacion_Cuestionarios.this, "",null,1);
            cuestionarios.guardarCuestionario(nom, RespC,  RespInc1,RespInc2,RespInc3, accion, Id);
            Toast.makeText(Creacion_Cuestionarios.this, "Listo, amigo registrado con exito", Toast.LENGTH_LONG).show();
            Intent imostrar= new Intent(Creacion_Cuestionarios.this,
                    MainActivity.class);
            startActivity(imostrar);
        }catch(Exception ex){
            Toast.makeText(Creacion_Cuestionarios.this, "Error: "+
                    ex.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
    }
}