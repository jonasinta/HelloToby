package com.example.hellotoby;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Belal on 10/30/2015.
 * JONASJONASJONAS below ;
 * Gmail authority bits were derived froom here: https://crunchify.com/java-mailapi-example-send-an-email-via-gmail-smtp/
 */

//Class is extending AsyncTask because this class is going to perform a networking operation
public class SendMail extends AsyncTask<Void,Void,Void> {

    //Declaring Variables
  //  private Context context;
    private Session session;

    //Information to send email
    private String[] email;
    private String subject;
    private String message;
    String strDate;

    //Progressdialog to show while sending email
   // private ProgressDialog progressDialog;

    static MimeMessage generateMailMessage;

    //Class Constructor
    public SendMail( String[] email, String subject, String message){
        //Initializing variables
      //  this.context = context;
        this.email = email;
        this.subject = subject;
        this.message = message;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd/MM, hh:mm:ss aa");
        strDate = "Time of event: " + mdformat.format(calendar.getTime()) +"\n";
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        //Showing progress dialog while sending email
       // progressDialog = ProgressDialog.show(context,"Sending message","Please wait...",false,false);
        System.out.println("sendMail pre execute");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Dismissing the progress dialog
       // progressDialog.dismiss();
        //Showing a success message
      //  Toast.makeText(context,"Message Sent",Toast.LENGTH_LONG).show();
        System.out.println("sendMail post execute");
    }

    @Override
    protected Void doInBackground(Void... params) {
        //Creating properties
        Properties props = new Properties();


        //Configuring properties for gmail
        //If you are not using gmail you may need to change the values
        // Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        session = Session.getDefaultInstance(props, null);



        try {
            //Creating MimeMessage object
            MimeMessage mm = new MimeMessage(session);

            //Setting sender address
            mm.setFrom(new InternetAddress(Config.EMAIL));
            //Adding receiver
            for (String addy:email ) {
                mm.addRecipient(Message.RecipientType.TO, new InternetAddress(addy));
            }

            //Adding subject
            mm.setSubject(subject);
            //Adding message
            mm.setText(strDate + message);
            System.out.println("Mail Session has been created successfully..");

            // Step3
            System.out.println("\n\n 3rd ===> Get Session and Send mail");
            Transport transport = session.getTransport("smtp");

            // Enter your correct gmail UserID and Password
            // if you have 2FA enabled then provide App Specific Password
            transport.connect("smtp.gmail.com", Config.EMAIL, Config.PASSWORDGmail);
            //Sending email
            transport.sendMessage(mm, mm.getAllRecipients());
            transport.close();



        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}