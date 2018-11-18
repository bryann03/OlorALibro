package com.example.oloralibro.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oloralibro.DatosLibreria;
import com.example.oloralibro.R;
import com.example.oloralibro.RecyclerViewOnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class RVAdaptadorLibrerias extends RecyclerView.Adapter<RVAdaptadorLibrerias.LibreriaViewHolder> {

    private ArrayList<DatosLibreria> librerias;
    private static RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

    public RVAdaptadorLibrerias(ArrayList<DatosLibreria> librerias, @NonNull RecyclerViewOnItemClickListener
            recyclerViewOnItemClickListener) {
        this.librerias = librerias;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    @NonNull
    @Override
    public LibreriaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.design_cv_libreria, viewGroup, false);
        final LibreriaViewHolder pvh = new LibreriaViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewOnItemClickListener.onItemClick(v, pvh.getAdapterPosition());
            }
        });
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull LibreriaViewHolder libreriaViewHolder, int position) {
        libreriaViewHolder.nombreLibreria.setText(librerias.get(position).nombreLibreria);
        libreriaViewHolder.poblacionLibreria.setText(librerias.get(position).poblacionLibreria);
        libreriaViewHolder.imagenLibreria.setImageResource(librerias.get(position).imagenLibreria);
    }

    @Override
    public int getItemCount() {
        return librerias.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class LibreriaViewHolder extends RecyclerView.ViewHolder implements RecyclerViewOnItemClickListener{
        CardView cv;
        TextView nombreLibreria;
        TextView poblacionLibreria;
        ImageView imagenLibreria;

        LibreriaViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardViewLibrerias);
            nombreLibreria = (TextView)itemView.findViewById(R.id.textViewNombreLibreria);
            poblacionLibreria = (TextView)itemView.findViewById(R.id.textViewPoblaciónLibreria);
            imagenLibreria = (ImageView)itemView.findViewById(R.id.imageViewLibreria);
        }

        @Override
        public void onItemClick(View v, int position) {
            if (recyclerViewOnItemClickListener != null) {
                recyclerViewOnItemClickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }
}
