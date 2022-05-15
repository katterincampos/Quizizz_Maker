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


public class Creacion_Cuestionarios extends AppCompatActivity {

    BaseDeDatos cuestionarios;
    String accion = "nuevo";
    String Id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_cuestionarios);
        final EditText tNombre = (EditText) this.findViewById(R.id.NombreQuizz);
        final EditText Tcategoria = (EditText) this.findViewById(R.id.Categotia);
        Button btnSave = (Button) this.findViewById(R.id.btnSave);


        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
// Crear las variables que reciben los datos
                String nom = tNombre.getText().toString();
                String cat = Tcategoria.getText().toString();


// Primera salida utilizando Toast
                Bundle pasarDatos = new Bundle();

                pasarDatos.putString("cNombre", nom);
                pasarDatos.putString("cCat", cat);
                Intent siga = new Intent(Creacion_Cuestionarios.this, Pregunta1.class);

                siga.putExtras(pasarDatos);
                startActivity(siga);
            }
        });


    }
}