package com.example.oloralibro.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oloralibro.ActivityListaPremios;
import com.example.oloralibro.DatosPremios;
import com.example.oloralibro.R;
import com.example.oloralibro.RecyclerViewOnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class RVAdaptadorPremios extends RecyclerView.Adapter<RVAdaptadorPremios.PremioViewHolder>{

    private ArrayList<DatosPremios> premios;
    private static RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

    public RVAdaptadorPremios(ArrayList<DatosPremios> premios, @NonNull RecyclerViewOnItemClickListener
            recyclerViewOnItemClickListener) {
        this.premios = premios;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }


    @NonNull
    @Override
    public PremioViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.design_cv_premios, viewGroup, false);
        final PremioViewHolder pvh = new PremioViewHolder(v);v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewOnItemClickListener.onItemClick(v, pvh.getAdapterPosition());
            }
        });
        return pvh;
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

    public static class PremioViewHolder extends RecyclerView.ViewHolder implements RecyclerViewOnItemClickListener {
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

        //OBTIENE LA POSICION DEL ELEMENTO
        @Override
        public void onItemClick(View v, int position) {
            if (recyclerViewOnItemClickListener != null) {
                recyclerViewOnItemClickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }
}
