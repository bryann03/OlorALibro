package com.example.oloralibro.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oloralibro.DatosPremios;
import com.example.oloralibro.R;
import com.example.oloralibro.RecyclerViewOnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class RVAdaptadorPremios extends RecyclerView.Adapter<RVAdaptadorPremios.PremioViewHolder>{

    private ArrayList<DatosPremios> premios;

    public RVAdaptadorPremios(ArrayList<DatosPremios> premios) {
        this.premios = premios;
    }

    @NonNull
    @Override
    public PremioViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.design_cv_premios, viewGroup, false);
        return new PremioViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PremioViewHolder premioViewHolder, int position) {
        premioViewHolder.nombrePremio.setText(premios.get(position).nombrePremio);
        premioViewHolder.descripcionPremio.setText(premios.get(position).descripcionPremio);
        premioViewHolder.costePremio.setText(Integer.toString(premios.get(position).costePremio));
        premioViewHolder.imagenPremio.setImageResource(premios.get(position).imagenPremio);
    }

    @Override
    public int getItemCount() {
        return premios.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    static class PremioViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView nombrePremio;
        TextView descripcionPremio;
        TextView costePremio;
        ImageView imagenPremio;

        PremioViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardViewPremios);
            nombrePremio = (TextView)itemView.findViewById(R.id.textViewNombrePremio);
            descripcionPremio = (TextView)itemView.findViewById(R.id.textViewDescripcionPremio);
            costePremio = (TextView)itemView.findViewById(R.id.textViewCostePremio);
            imagenPremio = (ImageView)itemView.findViewById(R.id.imageViewPremio);
        }
    }
}
