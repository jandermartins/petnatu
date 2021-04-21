package br.crateus.kariri.petnat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.crateus.kariri.petnat.R;

public class VerPetActivity extends AppCompatActivity {

    EditText nome, nomeTutor, peso, nascimento, especie, raca;
    FirebaseDatabase mDatabase;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pet);

        nome = (EditText) findViewById(R.id.etNomePetView);
        nomeTutor = (EditText) findViewById(R.id.etTutorPetView);
        peso = (EditText) findViewById(R.id.etPEsoPetView);
        nascimento = (EditText) findViewById(R.id.etNascimentoPetView);
        especie = (EditText) findViewById(R.id.etEspeciePetView);
        raca = (EditText) findViewById(R.id.etRacaPetView);

        mDatabase = FirebaseDatabase.getInstance("https://pet-natu-default-rtdb.firebaseio.com/");
        DatabaseReference myref = mDatabase.getReference();

        nome.setText(getIntent().getExtras().getString("nomePet"));
        nomeTutor.setText(getIntent().getExtras().getString("cpfTutor"));
        peso.setText(getIntent().getExtras().getString("peso"));
        nascimento.setText(getIntent().getExtras().getString("nascimento"));
        especie.setText(getIntent().getExtras().getString("especie"));
        raca.setText(getIntent().getExtras().getString("raca"));

    }
}