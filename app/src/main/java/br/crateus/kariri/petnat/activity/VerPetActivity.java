package br.crateus.kariri.petnat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.crateus.kariri.petnat.R;
import br.crateus.kariri.petnat.model.Pet;

public class VerPetActivity extends AppCompatActivity {

    EditText nome, nomeTutor, peso, nascimento, especie, raca, sexo;
    Button editar;
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
        sexo = (EditText) findViewById(R.id.etSexoPetVIew);
        especie = (EditText) findViewById(R.id.etEspeciePetView);
        raca = (EditText) findViewById(R.id.etRacaPetView);
        nascimento = (EditText) findViewById(R.id.etNascimentoPetView);
        editar = (Button) findViewById(R.id.btEditarPet);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        mDatabase = FirebaseDatabase.getInstance("https://pet-natu-default-rtdb.firebaseio.com/");
        DatabaseReference myref = mDatabase.getReference();

        nome.setText(getIntent().getExtras().getString("nomePet"));
        nomeTutor.setText(getIntent().getExtras().getString("cpfTutor"));
        peso.setText(getIntent().getExtras().getString("peso"));
        nascimento.setText(getIntent().getExtras().getString("nascimento"));
        especie.setText(getIntent().getExtras().getString("especie"));
        raca.setText(getIntent().getExtras().getString("raca"));
        sexo.setText(getIntent().getExtras().getString("sexo"));

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pet petEdit = new Pet(mUser.getUid(), nomeTutor.getText().toString(), nome.getText().toString(), especie.getText().toString(), raca.getText().toString()
                        , peso.getText().toString(), nascimento.getText().toString());
                petEdit.setIdPet(getIntent().getExtras().getString("idPet"));
                myref.child("pets").child(getIntent().getExtras().getString("idPet")).setValue(petEdit);

            }
        });
    }
}