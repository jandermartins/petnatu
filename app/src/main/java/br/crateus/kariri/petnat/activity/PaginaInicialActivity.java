package br.crateus.kariri.petnat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.crateus.kariri.petnat.R;

public class PaginaInicialActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onStart() {
        VerificaLogado();
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_inicial);

        Button btPainelAdmPI = (Button) findViewById(R.id.btPainelAdmPI);
        Button btSair = (Button) findViewById(R.id.btSair);


        btPainelAdmPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaginaInicialActivity.this, PainelAdmActivity.class));
            }
        });

        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(PaginaInicialActivity.this, LoginActivity.class));
            }
        });



    }
    private void VerificaLogado() {
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        if(mUser == null){
            startActivity(new Intent(PaginaInicialActivity.this, LoginActivity.class));
        }
    }
}