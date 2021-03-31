package br.crateus.kariri.petnat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.crateus.kariri.petnat.R;
import br.crateus.kariri.petnat.model.Pet;

public class CadastrarPetActivity extends AppCompatActivity {

    EditText etCpfTutor, etNomeCadastro, etEspecie, etRaca, etPeso, etDataNascimento;
    Button btCadastrar;
    Spinner spSexo;
    RadioGroup rgCastrado;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_pet);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://pet-natu-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference();

        etCpfTutor = (EditText) findViewById(R.id.etCpfTutorCadastroPet);
        etNomeCadastro = (EditText) findViewById(R.id.etNomeCadastroPet);
        etEspecie = (EditText) findViewById(R.id.etEspecieCadastroPet);
        etRaca = (EditText) findViewById(R.id.etRacaCadastroPet);
        etPeso = (EditText) findViewById(R.id.etPesoCadastroPet);
        etDataNascimento = (EditText) findViewById(R.id.etDataCadastroPet);
        spSexo = (Spinner) findViewById(R.id.spinnerCadastroSexoPet);
        rgCastrado = (RadioGroup) findViewById(R.id.rgCadastroPet);

        btCadastrar = (Button) findViewById(R.id.btCadastrarPet);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pet pet = new Pet(etCpfTutor.getText().toString(), etNomeCadastro.getText().toString(), etEspecie.getText().toString(),
                        etRaca.getText().toString(), etPeso.getText().toString(), etDataNascimento.getText().toString());
                myRef.child("usuario").child(mUser.getUid()).child("tutores").child
                        (etCpfTutor.getText().toString()).child("pets").setValue(pet);
                Toast.makeText(CadastrarPetActivity.this, "Pet Cadastrado com sucesso!!!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CadastrarPetActivity.this, PainelAdmActivity.class));
            }
        });
    }
}