package br.crateus.kariri.petnat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.crateus.kariri.petnat.R;
import br.crateus.kariri.petnat.model.Veterinario;

public class CadastrarUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);

        FirebaseAuth mAuth;
        FirebaseUser mUser;
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://pet-natu-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference();

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        EditText etNome = (EditText) findViewById(R.id.etNomeCadastrar);
        EditText etCpf = (EditText) findViewById(R.id.etCpfCadastrar);
        EditText etCrmv = (EditText) findViewById(R.id.etCrmvCadastrar);
        EditText etEspecialidade = (EditText) findViewById(R.id.etEspecialidadeCadastrar);
        Button btEnviar = (Button) findViewById(R.id.btCadatroUser);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EscreverNovoUsuario(mUser, etNome, etCpf, etCrmv, myRef);
            }
        });
    }
    private void EscreverNovoUsuario(FirebaseUser mUser, EditText etNome, EditText etCpf, EditText etCrmv, DatabaseReference myRef) {
        Veterinario veterinario = new Veterinario(mUser.getUid(), etNome.getText().toString(), etCpf.getText().toString(), etCrmv.getText().toString(), etCrmv.getText().toString());
        Log.i("teste", veterinario.getNome());
        myRef.child("usuario").child(mUser.getUid()).setValue(veterinario);
        startActivity(new Intent(CadastrarUsuarioActivity.this, PaginaInicialActivity.class));
    }
}