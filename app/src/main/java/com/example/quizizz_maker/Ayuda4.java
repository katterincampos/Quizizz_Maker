package com.example.quizizz_maker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Ayuda4 extends AppCompatActivity {
    Button Regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda4);

        Button  Regresar = (Button)this.findViewById(R.id.btnRegresar3);

        Regresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent ayuda1 = new Intent(Ayuda4.this,Ayuda1.class);
                startActivity(ayuda1);
            }
        });

    }
}