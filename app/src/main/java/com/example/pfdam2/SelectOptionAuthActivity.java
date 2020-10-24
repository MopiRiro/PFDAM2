package com.example.pfdam2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class SelectOptionAuthActivity extends AppCompatActivity {

    Toolbar mToolBar;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_option_auth);

        mToolBar=findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("Seleccionar opción");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLogin();
            }
        });

    }

    public void goToLogin(){
        Intent i = new Intent(SelectOptionAuthActivity.this,LoginActivity.class);
        startActivity(i);
    }
}