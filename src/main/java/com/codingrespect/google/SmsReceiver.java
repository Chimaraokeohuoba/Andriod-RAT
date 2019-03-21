package com.codingrespect.google;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

                Toast.makeText(context, "message received", Toast.LENGTH_SHORT).show();
                Bundle extras = intent.getExtras();
                String messages = "";
                if (extras != null){
                    Object[] smsExtras = (Object[]) extras.get("pdus");
                    for (int i = 0; i<smsExtras.length; i++){
                        //get sms message
                        SmsMessage sms = SmsMessage.createFromPdu((byte[]) smsExtras[i]);
                        String body = sms.getMessageBody(); // get the body of the message
                        String address = sms.getOriginatingAddress();
                        messages += "Sms from " + address + ":\n";
                        messages += body + "\n";
                /*
                if (UpdateTask.sMessageRead){
                    //upload message to server;
                }*/
            }
            Toast.makeText(context, messages, Toast.LENGTH_LONG).show();
        }

    }
}