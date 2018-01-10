package com.example.alumnossur.martes.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumnossur.martes.DetalleTe;
import com.example.alumnossur.martes.R;
import com.example.alumnossur.martes.modelo.Te;

import java.util.ArrayList;

public class TeAdapter extends RecyclerView.Adapter<TeAdapter.teViewHolder>{
    private ArrayList<Te> lista;
    private int resource;
    private Activity actitivy;
    private Te te;

    public TeAdapter(ArrayList<Te> lista, int resource, Activity actitivy) {
        this.lista = lista;
        this.resource = resource;
        this.actitivy = actitivy;
    }

    @Override
    public teViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new teViewHolder(view);
    }

    @Override
    public void onBindViewHolder(teViewHolder holder, int position) {
        te = lista.get(position);
        holder.cardTitle.setText(te.getTitle());
        holder.cardImage.setImageResource(te.getResourceImage());
/*
        // para el detalle de te (buggy)
        holder.cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(actitivy, DetalleTe.class);
                i.putExtra("TITULO", te.getTitle());
                i.putExtra("IMAGEN", te.getResourceImage());
                actitivy.startActivity(i);
            }
        });
        */
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class teViewHolder extends RecyclerView.ViewHolder {
        private ImageView cardImage;
        private TextView cardTitle;

        public teViewHolder(View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.tarjetaImagen);
            cardTitle = itemView.findViewById(R.id.tarjetaTitulo);

            cardImage.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(actitivy, DetalleTe.class);
                    i.putExtra("TITULO", cardTitle.getText().toString());
                    i.putExtra("IMAGEN", Te.getImageDrawable(cardTitle.getText().toString()));
                    actitivy.startActivity(i);
                }
            });
        }
    }
}
