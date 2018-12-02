package com.example.oloralibro.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oloralibro.ActivityListaPremios;
import com.example.oloralibro.DatosPremios;
import com.example.oloralibro.MetodosVarios;
import com.example.oloralibro.R;
import com.example.oloralibro.RecyclerViewOnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class RVAdaptadorPremios extends RecyclerView.Adapter<RVAdaptadorPremios.PremioViewHolder>{

    private ArrayList<DatosPremios> premios;
    private OnItemClickListener mListemer;

    public interface OnItemClickListener
    {
        void onCanjearClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListemer = listener;
    }

    //CLASE ViewHolder
    public static class PremioViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView nombrePremio;
        TextView descripcionPremio;
        TextView costePremio;
        ImageView imagenPremio;
        Button buttonCanjear;

        PremioViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            this.cv = (CardView)itemView.findViewById(R.id.cardViewPremios);
            this.nombrePremio = (TextView)itemView.findViewById(R.id.textViewNombrePremio);
            this.descripcionPremio = (TextView)itemView.findViewById(R.id.textViewDescripcionPremio);
            this.costePremio = (TextView)itemView.findViewById(R.id.textViewCostePremio);
            this.imagenPremio = (ImageView)itemView.findViewById(R.id.imageViewPremio);
            this.buttonCanjear = (Button)itemView.findViewById(R.id.buttonCanjear);
            buttonCanjear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            listener.onCanjearClick(position);
                        }
                    }
                }
            });
        }
    }


    //CONSTRUCTOR CLASE ADPATADOR
    public RVAdaptadorPremios(ArrayList<DatosPremios> premios) {
        this.premios = premios;
    }

    @NonNull
    @Override
    public PremioViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.design_cv_premios, viewGroup, false);
        final PremioViewHolder pvh = new PremioViewHolder(v, mListemer);
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


}
