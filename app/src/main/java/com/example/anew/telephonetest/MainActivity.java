package com.example.anew.telephonetest;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
    }

    public void Message(View view)
    {

        SmsManager smg=SmsManager.getDefault();
        Intent sendint=new Intent(this,Sendact.class);
        Intent delint=new Intent(this,Delact.class);
        PendingIntent pensent=PendingIntent.getActivity(this,0,sendint,0);
        PendingIntent pendel=PendingIntent.getActivity(this,0,delint,0);
        smg.sendTextMessage("9491167472","null",et2.getText().toString(),pensent,pendel);
    }

    public void Call(View view)
    {
        Intent i=new Intent();
        i.setAction(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:"+et1.getText().toString()));
        startActivity(i);
    }
}
