package com.example.usuario.yourwelcome.Servicios;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import java.sql.BatchUpdateException;

public class Prueba extends Service {
    public Prueba() {
    }

    Hilo obj;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        obj = new Hilo();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int opcion = intent.getExtras().getInt("opcion");
        //Toast.makeText(this,"Hola:"+opcion,Toast.LENGTH_LONG).show();
        if(opcion==1){
            /*for (int i=0;i<=100;i++){
                if(i==1 || i==10 || i==20 || i==30 || i==40 || i==50 || i==60 || i==70 || i==80|| i==90|| i==100){
                    Toast.makeText(this,"Hola:"+i,Toast.LENGTH_LONG).show();
                }
            }*/
            for (int i=0;i<=3;i++){
                try {
                    Thread.sleep(5000);
                    Toast.makeText(this,"Hola:"+i,Toast.LENGTH_SHORT).show();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else if(opcion==2){
            obj.execute();
        }
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }
    //<param,progrees,result>
    public class Hilo extends AsyncTask<Void,Integer,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            for (int i=0;i<=3;i++){
                try {
                    Thread.sleep(2000);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Toast.makeText(getApplicationContext(),"AsyncTask:"+values[0],Toast.LENGTH_SHORT).show();
        }
    }

}
