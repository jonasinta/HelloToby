package com.example.hellotoby;

import android.content.Context;
import android.content.Intent;


import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity implements View.OnClickListener {
    private String subject;
    private String message;
    private ImageView imageViewToby;
 private Resources res2;
   private String[] email;

    //Send button
    private Button buttonSend;
    private Button buttonSetPreferences;

    private static final String LOG_TAG =   MainActivity.class.getSimpleName();


   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      res2 = getResources();
       imageViewToby = findViewById(R.id.imageView1);

       buttonSend = findViewById(R.id.buttonSend);
       buttonSetPreferences = findViewById(R.id.buttonSetPreferences);

       //Adding click listener
       buttonSend.setOnClickListener(this);
       buttonSetPreferences.setOnClickListener(this);
    //   sendEmail();

   }
    private void sendEmail() {
        //Getting content for email
       

        //Declaring EditText
        email = res2.getStringArray(R.array.addressess);
        subject= "holleeFuck second";
        message="leMessage is here enclosed";

        //Creating SendMail object
        SendMail sm = new SendMail( email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }


   public void broadcastIntent(View view) {

       Intent intent=new Intent();
       intent.setAction("com.example.hellotoby.CUSTOM_INTENT");

       sendBroadcast(intent);

   }

    @Override
    public void onClick(View view) {
       if (view==buttonSend) {
           sendEmail();
       }//close if
        if (view==buttonSetPreferences){
            launchSecondActivity(view);
        }
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, Preferences.class);

       startActivity(intent);
    }
    // broadcast a custom intent.
    }