package br.crateus.kariri.petnat.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import br.crateus.kariri.petnat.R;
import br.crateus.kariri.petnat.model.Veterinario;

public class VerCadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_cadastro);

        TextView tvNome, tvCpf, tvCrmv, tvEspecialidade;

        tvNome = (TextView) findViewById(R.id.tvNomeMd);
        tvCpf = (TextView) findViewById(R.id.tvCpf);
        tvCrmv = (TextView) findViewById(R.id.tvCrmvMd);
        tvEspecialidade = (TextView) findViewById(R.id.tvEspecialidadeMd);

        FirebaseAuth mAuth;
        FirebaseUser mUser;

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://pet-natu-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference();

        myRef.child("usuario").child(mUser.getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()){
                    Veterinario veterinario = new Veterinario();
                    DataSnapshot dataSnapshot = task.getResult();

                    tvNome.setText(dataSnapshot.getValue(Veterinario.class).getNome());
                    tvEspecialidade.setText(dataSnapshot.getValue(Veterinario.class).getEspecialidade());
                    tvCrmv.setText(dataSnapshot.getValue(Veterinario.class).getCmfv());
                    tvCpf.setText(dataSnapshot.getValue(Veterinario.class).getCpf());
                }
            }
        });


    }
}