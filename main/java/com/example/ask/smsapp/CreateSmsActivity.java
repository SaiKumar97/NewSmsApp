package com.example.ask.smsapp;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ask on 29/10/16.
 */

public class CreateSmsActivity extends AppCompatActivity implements View.OnClickListener{
    public static int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_sms_activity);

        Intent intent = getIntent();

        Button sendmsg = (Button) findViewById(R.id.sendButton);
        sendmsg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        EditText num = (EditText) findViewById(R.id.msgNumber);
        EditText msg = (EditText) findViewById(R.id.msgText);

        String number = num.getText().toString();
        String message = msg.getText().toString();

                    try {

                        SmsManager.getDefault().sendTextMessage(number, null, message, null, null);
                        Toast.makeText(this, " Sms Sent to " + number, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        AlertDialog.Builder alertDialogBuilder = new
                                AlertDialog.Builder(this);
                        AlertDialog dialog = alertDialogBuilder.create();

                        dialog.setMessage(e.getMessage());

                        dialog.show();
                        Toast.makeText(this, " Sent Failed " , Toast.LENGTH_LONG).show();
                    }
    }
}
