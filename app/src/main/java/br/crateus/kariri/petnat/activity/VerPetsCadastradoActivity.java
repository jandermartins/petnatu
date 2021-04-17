package br.crateus.kariri.petnat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import br.crateus.kariri.petnat.R;


public class VerPetsCadastradoActivity extends AppCompatActivity {

    RecyclerView rvPets;
    LineAdapter lineAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pets_cadastrado);

        rvPets = (RecyclerView) findViewById(R.id.RvVerPetsCadastrados);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvPets.setLayoutManager(layoutManager);
        lineAdapter = new LineAdapter(new ArrayList(0));
        rvPets.setAdapter(lineAdapter);

        Button btMore = (Button) findViewById(R.id.btMaisPet);

//        btMore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(VerPetsCadastradoActivity.this, VerPetActivity.class));
//            }
//        });
    }
}