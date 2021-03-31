package br.crateus.kariri.petnat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import br.crateus.kariri.petnat.R;
import br.crateus.kariri.petnat.model.Pet;
import br.crateus.kariri.petnat.model.Tutor;

public class CadastrarTutorActivity extends AppCompatActivity {

    EditText etCpf, etNome, etEndereco, etTelefone;
    Button btCadastrar;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_tutor);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://pet-natu-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference();

        etCpf = (EditText) findViewById(R.id.etCpfTC);
        etNome = (EditText) findViewById(R.id.etNomeTC);
        etEndereco = (EditText) findViewById(R.id.etEnderecoTC);
        etTelefone = (EditText) findViewById(R.id.etTelefoneTC);
        btCadastrar = (Button) findViewById(R.id.btTC);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tutor tutor = new Tutor(etCpf.getText().toString(), etNome.getText().toString(),
                        etEndereco.getText().toString(), etTelefone.getText().toString());
                myRef.child("usuario").child(mUser.getUid()).child("tutores").child(etCpf.getText().toString()).setValue(tutor);
                startActivity(new Intent(CadastrarTutorActivity.this, PainelAdmActivity.class));
            }
        });
    }
}