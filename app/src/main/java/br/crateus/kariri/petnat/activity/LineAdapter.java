package br.crateus.kariri.petnat.activity;

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

    public LineAdapter(ArrayList pets) {
        mPets = pets;
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
            public void onClick(View v) {
            }
        });
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
