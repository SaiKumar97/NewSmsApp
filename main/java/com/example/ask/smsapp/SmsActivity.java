package com.example.ask.smsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by ask on 29/10/16.
 */

public class SmsActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sms_fragment);

        Intent intent = getIntent();
        String message = intent.getStringExtra(FragmentActivity.EXTRA_MESSAGE);

        TextView textView = (TextView) findViewById(R.id.text_view_msg);
        textView.setText(message);
    }
}
