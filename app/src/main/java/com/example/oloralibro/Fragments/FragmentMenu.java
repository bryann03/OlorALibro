package com.example.oloralibro.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.oloralibro.ActivityInfoActividades;
import com.example.oloralibro.ActivityIniciarSesion;
import com.example.oloralibro.ActivityListaLibrerias;
import com.example.oloralibro.ActivityListaPremios;
import com.example.oloralibro.MetodosVarios;
import com.example.oloralibro.R;


public class FragmentMenu extends Fragment {

    Button botonLibrerias, botonActividades, botonIniciarSesion, botonPremios;
    //MetodosVarios metodosVarios = new MetodosVarios();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_menu, container, false);


        final FragmentManager fragmentManager = getFragmentManager();

        botonLibrerias = (Button) root.findViewById(R.id.BotonLibrerias);
        botonActividades = (Button) root.findViewById(R.id.BotonActividades);
        botonIniciarSesion = (Button) root.findViewById(R.id.BotonIniciarSesion);
        botonPremios = (Button) root.findViewById(R.id.BotonPremios);

        botonLibrerias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //REEMPLAZA EL CONTENEDOR DE LOS FRAGMENTS POR UNO ESPECIFICO
                //con "addToBackStack" se puede volver al fragment anterior
                //fragmentManager.beginTransaction().replace(R.id.contenedor, new FragmentLibrerias()).addToBackStack("tag").commit();
                //metodosVarios.abrirActivity(getActivity(), ActivityListaLibrerias.class);
                abrirActivity(getActivity(), ActivityListaLibrerias.class);

            }
        });

        botonActividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //metodosVarios.abrirActivity(getActivity(), ActivityInfoActividades.class);
                abrirActivity(getActivity(), ActivityInfoActividades.class);

            }
        });

        botonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //metodosVarios.abrirActivity(getActivity(), ActivityIniciarSesion.class);
                abrirActivity(getActivity(), ActivityIniciarSesion.class);

            }
        });

        botonPremios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //metodosVarios.abrirActivity(getActivity(), ActivityListaPremios.class);
                abrirActivity(getActivity(), ActivityListaPremios.class);
            }
        });

        return root;
    }

    //METODO PARA LANZAR EL INTENT Y ABRIR UNA ACTIVITY
    public void abrirActivity(Context context, Class clase)
    {
        Intent activity = new Intent(context, clase);
        startActivity(activity);
    }

}
