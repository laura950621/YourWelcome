package com.example.usuario.yourwelcome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.usuario.yourwelcome.Servicios.Prueba;

public class TestService extends AppCompatActivity {


    Intent servicio;
    boolean flag2=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_service);
    }
    //VOLVER - INLINE
    public void volver(View g){
        Intent ir = new Intent(TestService.this,Home.class);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TOP | ir.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(ir);
    }
    public void IniciarServicio1(View g){
        servicio = new Intent(TestService.this, Prueba.class);
        Bundle datos = new Bundle();
        datos.putInt("opcion",1);
        servicio.putExtras(datos);
        flag2=true;
        startService(servicio);
    }
    public void IniciarServicio2(View g){
        servicio = new Intent(TestService.this, Prueba.class);
        Bundle datos = new Bundle();
        datos.putInt("opcion",2);
        servicio.putExtras(datos);
        flag2=true;
        startService(servicio);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(flag2){
            stopService(servicio);
        }
    }
}
