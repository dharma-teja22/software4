package com.example.software4;

import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class forgotpw extends AppCompatActivity implements SmsListener{
    private MyOTPReceiver broadcastReceiver;
    public static final String OTP_REGEX = "[0-9]{1,6}";
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpw);
        MyOTPReceiver.bindListener(this);
        Bundle b = getIntent().getExtras();
        //bname=b.getString("bname");
        name=b.getString("uname");
        broadcastReceiver = new MyOTPReceiver();
    }
    public void messageReceived(String messageText) {

        //From the received text string you may do string operations to get the required OTP
        //It depends on your SMS format
        Log.e("Message",messageText);
        Toast.makeText(forgotpw.this,"Message: "+
                messageText,Toast.LENGTH_LONG).show();

        // If your OTP is six digits number, you may use the below code

        Pattern pattern = Pattern.compile(OTP_REGEX);
        Matcher matcher = pattern.matcher(messageText);
        String otp = "XXXXX";
        while (matcher.find())
        {
            otp = matcher.group();
        }

        Toast.makeText(forgotpw.this,"OTP: "+ otp ,Toast.LENGTH_LONG).show();
        TextView t = findViewById(R.id.tv);
        t.setText(otp);
    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter=new IntentFilter
                ("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(broadcastReceiver,intentFilter);
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }

}
