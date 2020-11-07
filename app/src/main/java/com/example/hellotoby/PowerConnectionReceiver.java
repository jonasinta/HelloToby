package com.example.hellotoby;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class PowerConnectionReceiver extends BroadcastReceiver {
    String msg = "Android : ";
    private String subject;
    private String message="leMessage is here enclosed";
    private String[] sendAddress;
//private Context contextSpreader;
private Intent intent4class;
    @Override
    public void onReceive(Context context, Intent intent) {
       // contextSpreader = context;
        intent4class = intent;
        Resources res = context.getResources();
        sendAddress = res.getStringArray(R.array.addressess);
        Toast toast = Toast.makeText(context, intent.getAction(), Toast.LENGTH_LONG);

        toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
        toast.show();
       composeEmail(sendAddress, context+intent.getAction());



        Log.d("YAY", "in broadcast intent module");
      //  throw new UnsupportedOperationException("Not yet implemented");
    }
    public void composeEmail(String[] addresses, String subject) {
        String emailSubject= subject;


        //Creating SendMail object
        SendMail sm = new SendMail( addresses, emailSubject, message);

        //Executing sendmail to send email
        sm.execute();
    }

}
