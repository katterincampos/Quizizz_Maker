package com.example.quizizz_maker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Ayuda2 extends AppCompatActivity {
    Button Regresar;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda2);
        Button  Regresar = (Button)this.findViewById(R.id.btnRegresar);
        Regresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent ayuda1 = new Intent(Ayuda2.this,Ayuda1.class);
                startActivity(ayuda1);
            }
        });

        videoView = (VideoView)findViewById(R.id.videoView);

        String path = "android.resource://"+ getPackageName() + "/" +
                R.raw.video;
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();

    }
}

