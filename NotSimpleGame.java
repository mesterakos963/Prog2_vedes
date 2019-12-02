package com.example.vedes2;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.vedes2.R;

import java.util.Random;

class NotSimpleGame extends Activity {
    TextView messageText;
    EditText enteredNumber;
    Button validateButton;

    int numberToFind;
    int numberTries;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.content);

        System.out.println("NotSimpleGame created");

        messageText = findViewById(R.id.msg);
        enteredNumber = findViewById(R.id.enteredNumber);
        validateButton = findViewById(R.id.validateButton);

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = Integer.parseInt(enteredNumber.getText().toString());
                numberTries++;

                if (n == numberToFind) {
                    Toast.makeText(getApplicationContext(), "Gratulálok! Megvan a szám! " + numberToFind + " Összesen " + numberTries + " próbálkozásra volt szükséged.", Toast.LENGTH_SHORT).show();
                    newGame();
                } else if (n > numberToFind) {
                    messageText.setText(R.string.too_high);
                } else {
                    messageText.setText(R.string.too_low);
                }
            }
        });

        newGame();
    }

    private void newGame() {
        numberToFind = new Random().nextInt(100) + 1;
        messageText.setText(R.string.start_msg);
        enteredNumber.setText("");
        numberTries = 0;
    }
}
