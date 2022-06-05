package com.example.quizizz_maker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class Ayuda1 extends AppCompatActivity {
    Button Video;
    Button Crearquizz;
    Button resquizz;
    Button iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda1);

        Button Video = (Button)this.findViewById(R.id.btnVideo);
        Button Crearquizz = (Button)this.findViewById(R.id.btnCrearquizz);
        Button resquizz = (Button)this.findViewById(R.id.btnresquizz);
        Button iniciar = (Button)this.findViewById(R.id.btniniciar);


        Video.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent ayuda2 = new Intent(Ayuda1.this, Ayuda2.class);
                startActivity(ayuda2);
            }
        });
        iniciar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent Segunda_Pantalla = new Intent(Ayuda1.this, Segunda_Pantalla.class);
                startActivity(Segunda_Pantalla);
            }
        });

        Crearquizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ayuda3 = new Intent(Ayuda1.this, Ayuda3.class);
                startActivity(ayuda3);
            }
        });

        resquizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  ayuda4 = new Intent(Ayuda1.this, Ayuda4.class);
                startActivity(ayuda4);
            }
        });
    }
}