package com.example.usuario.yourwelcome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity implements View.OnClickListener{

    Button bnt1,btn2,btn3;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //enlace
        bnt1 = (Button) findViewById(R.id.bntInterface);
        btn2 = (Button) findViewById(R.id.btnListen);
        btn3 = (Button) findViewById(R.id.bntInterface2);

        bnt1.setOnClickListener(this);
        btn3.setOnClickListener(this);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(),"Hola Listen",Toast.LENGTH_LONG).show();
            }
        });

        Bundle recibo = getIntent().getExtras();

        if(recibo!=null){
            contador = recibo.getInt("contador");
        }
        if(savedInstanceState!=null){
            contador=savedInstanceState.getInt("contador");
        }
    }

    //VOLVER - INLINE
    public void irMain(View g){
        Intent ir = new Intent(Home.this,MainActivity.class);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TOP | ir.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(ir);
    }
    public void irPulso(View g){
        Intent ir = new Intent(Home.this,Pulso.class);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TOP | ir.FLAG_ACTIVITY_CLEAR_TASK);
        Bundle entrega = new Bundle();
        entrega.putInt("contador",contador);
        ir.putExtras(entrega);
        startActivity(ir);
    }
            /*
            * param: none
            * propose: Call TestService Activity
             */
    public void irTestService(){
        Intent ir = new Intent(Home.this,TestService.class);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TOP | ir.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(ir);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bntInterface:
                Toast.makeText(this,"Hola interface",Toast.LENGTH_LONG).show();
                break;
            case R.id.bntInterface2:
                irTestService();
                break;
            default:
                Toast.makeText(this,"Hola",Toast.LENGTH_LONG).show();
        }
    }
}
