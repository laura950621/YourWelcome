package com.example.usuario.yourwelcome.Servicios;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import java.sql.BatchUpdateException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Prueba extends Service {
    public Prueba() {
    }

    String fecha;
    SimpleDateFormat dateFormat;

    Hilo obj;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int opcion = intent.getExtras().getInt("opcion");
        //Toast.makeText(this,"Hola:"+opcion,Toast.LENGTH_LONG).show();
        obj = new Hilo();
        if(opcion==1){
            for (int i=0;i<=3;i++){
                try {
                    Thread.sleep(2000);
                    Toast.makeText(this,"Fecha: "+fecha,Toast.LENGTH_SHORT).show();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else if(opcion==2){
            obj.execute();
        }
        //stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }
    //<param,progrees,result>
    public class Hilo extends AsyncTask<Void,Integer,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            for (int i=0;i<=3;i++){
                try {

                    publishProgress(i);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            fecha = dateFormat.format(new Date());
            Toast.makeText(getApplicationContext(),"Fecha: "+values[0]+" "+fecha,Toast.LENGTH_SHORT).show();
        }
    }

}
