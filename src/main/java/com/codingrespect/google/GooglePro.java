package com.codingrespect.google;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Timer;

public class GooglePro extends Service {
    public static final long REPEAT_INTERVAL = 10*1000;
    private Timer mTimer = null;
    public GooglePro() {

    }

    @Override
    public void onCreate() {
        if (mTimer != null){
            mTimer.cancel();
        }else {
            mTimer = new Timer();
        }
        mTimer.scheduleAtFixedRate(new UpdateTask(getApplicationContext()), 0, REPEAT_INTERVAL);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //onTaskRemoved(intent);
        //Toast.makeText(getApplicationContext(), "service started", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Intent restartServiceIntent = new Intent(getApplicationContext(), this.getClass());
        restartServiceIntent.setPackage(getPackageName());
        startService(restartServiceIntent);
        super.onTaskRemoved(rootIntent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }






}


