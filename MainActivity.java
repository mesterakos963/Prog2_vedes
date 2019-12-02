package com.example.guessinggame;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.vedes2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sima = findViewById(R.id.gameMode1);
        Button osszetett = findViewById(R.id.gameMode2);

        sima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), com.example.guessinggame.SimpleGame.class);
                startActivity(myIntent);
            }
        });

        osszetett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), com.example.guessinggame.NotSimpleGame.class);
                startActivity(myIntent);
            }
        });
    }
}