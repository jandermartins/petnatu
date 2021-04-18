package br.crateus.kariri.petnat.activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.crateus.kariri.petnat.R;
import br.crateus.kariri.petnat.model.Pet;

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {

    private final List<Pet> mPets;
    private Context context;


    public LineAdapter(ArrayList pets, Context context) {
        mPets = pets;
        this.context = context;
    }

    @NonNull
    @Override
    public LineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext()).inflate
                (R.layout.custonrecyclerpets, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position) {
        holder.nomePet.setText(String.format(Locale.getDefault(), "%s, %s",
                mPets.get(position).getIdPet(),
                mPets.get(position).getNome()));

        holder.btMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                abrirPet(v, position);
            }
        });
    }

    private void abrirPet(View v, int position) {
        final Intent i = new Intent(v.getContext(), VerPetActivity.class);

        i.putExtra("idPet", mPets.get(position).getIdPet());
        i.putExtra("nomePet", mPets.get(position).getNome());
        i.putExtra("cpfTutor", mPets.get(position).getCpfTutor());
        i.putExtra("idVeterinario", mPets.get(position).getIdVeterinario());
        i.putExtra("especie", mPets.get(position).getEspecie());
        i.putExtra("raca", mPets.get(position).getRaca());
        i.putExtra("peso", mPets.get(position).getPeso());
        i.putExtra("sexo", mPets.get(position).getSexo());
        i.putExtra("nascimento", mPets.get(position).getNascimento());
    }

    public void inserirItem(Pet pet){
        mPets.add(pet);
        notifyItemInserted(getItemCount());
    }


    @Override
    public int getItemCount() {
        return mPets != null ? mPets.size() : 0;
    }
}
