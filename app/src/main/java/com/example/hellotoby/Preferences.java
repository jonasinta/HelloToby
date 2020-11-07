package com.example.hellotoby;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Preferences extends Activity implements View.OnClickListener {
    private EditText editTextEmail1, editTextEmail2, editTextEmail3;


    private EditText editTextSubject, editTextMessage, editTextTestPeriod;


    private Button buttonSetPreferences,  buttonClearPreferences;

    private Timer timer;
    private Integer heartbeatperiodDays;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        Context context = getApplicationContext();
        //Initializing the views
        editTextEmail1 = findViewById(R.id.editTextEmail1);
        editTextEmail2 = findViewById(R.id.editTextEmail2);
        editTextEmail3 = findViewById(R.id.editTextEmail3);

        editTextSubject = findViewById(R.id.editTextSubject);
        editTextMessage = findViewById(R.id.editTextMessage);
        editTextTestPeriod= findViewById(R.id.editTextTestPeriod);
        buttonSetPreferences= findViewById(R.id.SetPreferences);
        buttonClearPreferences= findViewById(R.id.ClearPreferences);

        buttonSetPreferences.setOnClickListener(this);


        // creating timer task, timer

       timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                System.out.println("1");
            }
        };
        long timerPeriod= 1000 *60 *60 *24 * heartbeatperiodDays;
        timer.scheduleAtFixedRate(timerTask,timerPeriod,timerPeriod);

    }

    @Override
    protected void onPause() {
        super.onPause();
        timer.cancel();
    }


    @Override
    public void onClick(View view) {
if (view==buttonSetPreferences) {
    String email1  = editTextEmail1.getText().toString();
    String email2  = editTextEmail2.getText().toString();
    String email3  = editTextEmail3.getText().toString();

   

}
    }
}

