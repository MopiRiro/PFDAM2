package com.example.pfdam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnConductor;
    Button btnCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConductor=findViewById(R.id.btnSoyConductor);
        btnCliente=findViewById(R.id.btnSoyCliente);

        btnConductor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSelectAuth();
            }
        });

        btnCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSelectAuth();
            }
        });
    }

    private void  goToSelectAuth(){
        Intent i= new Intent(MainActivity.this,SelectOptionAuthActivity.class);
        startActivity(i);

    }
}