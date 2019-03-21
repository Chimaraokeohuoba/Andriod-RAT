package com.codingrespect.google;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class Receivers extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, intent.getAction(), Toast.LENGTH_SHORT).show();
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){
            Toast.makeText(context, "booting finished", Toast.LENGTH_SHORT).show();
        }

        if (Intent.ACTION_POWER_CONNECTED.equals(intent.getAction())){
            //Toast.makeText(context, "phone plugged", Toast.LENGTH_SHORT).show();
            if (!serviceIsRunning(GooglePro.class,context)){
                //start GooglePro service
                Intent serviceIntent = new Intent(context, GooglePro.class);
                context.startService(serviceIntent);
            }

        }

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            Toast.makeText(context, "connection changed", Toast.LENGTH_SHORT).show();
            if (!serviceIsRunning(GooglePro.class,context)){
                //start GooglePro service
                Intent serviceIntent = new Intent(context, GooglePro.class);
                context.startService(serviceIntent);
            }

        }
    }



    private boolean serviceIsRunning(Class<?> serviceClass, Context context){
        ActivityManager manager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service: manager.getRunningServices(Integer.MAX_VALUE)){
            if (serviceClass.getName().equals(service.service.getClassName())){
               // Toast.makeText(context, "Service "+serviceClass.getName().toString()+" is already running", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        //Toast.makeText(context, "Service "+serviceClass.getName().toString()+" is not running", Toast.LENGTH_SHORT).show();
        return false;
    }
}