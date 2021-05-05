package br.crateus.kariri.petnat.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import br.crateus.kariri.petnat.R;
import br.crateus.kariri.petnat.model.Pet;

public class CadastrarPetActivity extends AppCompatActivity {

    EditText etCpfTutor, etNomeCadastro, etEspecie, etRaca, etPeso, etDataNascimento;
    ImageButton ibAnexarExame;
    Button btFoto;

    Spinner spSexo;
    RadioGroup rgCastrado;

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    FirebaseStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_pet);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://pet-natu-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference();
//        StorageReference storageRef = storage.getReference();
        etCpfTutor = (EditText) findViewById(R.id.etCpfTutorCadastroPet);
        etNomeCadastro = (EditText) findViewById(R.id.etNomeCadastroPet);
        etEspecie = (EditText) findViewById(R.id.etEspecieCadastroPet);
        etRaca = (EditText) findViewById(R.id.etRacaCadastroPet);
        etPeso = (EditText) findViewById(R.id.etPesoCadastroPet);
        etDataNascimento = (EditText) findViewById(R.id.etDataCadastroPet);
        spSexo = (Spinner) findViewById(R.id.spinnerCadastroSexoPet);
        rgCastrado = (RadioGroup) findViewById(R.id.rgCadastroPet);

        Button btCadastrar = (Button) findViewById(R.id.btCadastrarPet);

        btFoto = (Button) findViewById(R.id.btFoto);

        btFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarFoto();
            }
        });

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        String link = "";

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pet pet = new Pet(mUser.getUid(), etCpfTutor.getText().toString(), etNomeCadastro.getText().toString(), etEspecie.getText().toString(),
                        etRaca.getText().toString(), etPeso.getText().toString(), etDataNascimento.getText().toString(), link);
                pet.setIdPet(String.valueOf(pet.hashCode()));
                myRef.child("pets").child(String.valueOf(pet.hashCode())).setValue(pet);
                Toast.makeText(CadastrarPetActivity.this, "Pet Cadastrado com sucesso!!!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CadastrarPetActivity.this, PainelAdmActivity.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView imageView = findViewById(R.id.ivFotoExame);
            imageView.setImageBitmap(imageBitmap);
        }

    }

    static final int image = 1;

    private void tirarFoto(){
        Log.i("botão", "ok");
        Intent tirarfoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (tirarfoto.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(tirarfoto, image);
        }
    }
}