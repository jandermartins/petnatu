package br.crateus.kariri.petnat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.crateus.kariri.petnat.R;

public class PainelAdmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel_adm);

        Button btCadastrarPet = (Button) findViewById(R.id.btCadastrarPetPA);

        btCadastrarPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PainelAdmActivity.this, CadastrarPetActivity.class));
            }
        });
    }
}