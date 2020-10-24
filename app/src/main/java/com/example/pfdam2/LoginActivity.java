package com.example.pfdam2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText etEmail;
    TextInputEditText etPassword;
    Button btnIniciarSesion;

    FirebaseAuth Auth;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnIniciarSesion=findViewById(R.id.btnIniciarSesion);
        Auth=FirebaseAuth.getInstance();
        database= FirebaseDatabase.getInstance().getReference();

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingreso();
            }
        });

    }

    public void ingreso(){
        String email=etEmail.getText().toString();
        String password=etPassword.getText().toString();

        if(!email.isEmpty() && !password.isEmpty()){
            if(password.length() >=6){
                Auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Se ingreso correctamente",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(LoginActivity.this,"La contraseña es incorrecta",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            else{
                Toast.makeText(this,"La contraseña debe tener más de 6 caracteres",Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this,"La contraseña y el email son obligatorios",Toast.LENGTH_SHORT).show();
        }
    }
}