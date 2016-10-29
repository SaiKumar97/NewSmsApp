package com.example.ask.smsapp;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ask on 28/10/16.
 */

public class FragmentActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public final static String EXTRA_MESSAGE = "com.example.simpllistfragment.smsMESSAGE";
    public ListView lv;
    public String[][] smsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_activity);

        Intent intent = getIntent();

        Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);

        ArrayList<String> al = new ArrayList<>();
        int noOfColumns = cursor.getColumnCount();
        int noOfRows = cursor.getCount();
        smsData = new String[noOfRows][noOfColumns];
        String[] smsBody = new String[noOfRows];
        if (cursor.moveToFirst()) {
            int row = 0;
            do {
                String msgData = "";

                for(int index=0;index<noOfColumns;index++)
                {
                    msgData += " " + cursor.getColumnName(index) + ":" + cursor.getString(index);
                    smsData[row][index] = cursor.getString(index);
                }
                smsBody[row] = cursor.getString(2);
                row++;
                al.add(msgData);
            } while (cursor.moveToNext());
        } else {
            System.err.println("NO INBOX HERE");
        }

        for(int i=0; i<noOfRows; i++) {

        }

//        al.toArray(new String[al.size()])
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.fragment_activity, R.id.text_view_msg, smsBody);

        lv =  (ListView) findViewById(R.id.list_view_msg);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent intent = new Intent(this, SmsActivity.class);
        intent.putExtra(EXTRA_MESSAGE, smsData[position][13]); //lv.getAdapter().getItem(position);

        startActivity(intent);

        Toast.makeText(this, "Item: " + position, Toast.LENGTH_SHORT).show();

    }


}

