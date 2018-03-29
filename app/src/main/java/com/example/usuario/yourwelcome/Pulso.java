package com.example.usuario.yourwelcome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Pulso extends AppCompatActivity {

    int contador=0;

    TextView txtv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulso);

        txtv1 = (TextView) findViewById(R.id.Texto1);

        txtv1.append("Hola mundo!!");
    }
    //VOLVER - INLINE
    public void irHome2(View g){
        Intent ir = new Intent(Pulso.this,Home.class);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TOP | ir.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(ir);
    }

    public void sumarView(View g){
        sumar();
    }
    public void sumar(){
        contador++;
        txtv1.setText(""+contador);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("contador",contador);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        contador = savedInstanceState.getInt("contador");
        txtv1.setText(""+contador);
    }
}
