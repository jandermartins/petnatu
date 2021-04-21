package br.crateus.kariri.petnat.activity;


import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.crateus.kariri.petnat.R;

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView nomePet;
    public Button btMore;

    public LineHolder(@NonNull View itemView) {
        super(itemView);
        nomePet = (TextView) itemView.findViewById(R.id.tvNomePetRv);
        btMore = (Button) itemView.findViewById(R.id.btMaisPet);
    }
}
