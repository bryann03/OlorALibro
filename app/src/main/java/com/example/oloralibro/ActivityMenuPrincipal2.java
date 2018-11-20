package com.example.oloralibro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMenuPrincipal2 extends AppCompatActivity {

    Button botonLibrerias, botonActividades, botonIniciarSesion, botonPremios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal2);
        setTitle("¡Bienvenido a Olor a libro!");

        botonLibrerias = (Button) findViewById(R.id.BotonLibrerias);
        botonActividades = (Button) findViewById(R.id.BotonActividades);
        botonIniciarSesion = (Button) findViewById(R.id.BotonIniciarSesion);
        botonPremios = (Button) findViewById(R.id.BotonPremios);

        botonLibrerias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //REEMPLAZA EL CONTENEDOR DE LOS FRAGMENTS POR UNO ESPECIFICO
                //con "addToBackStack" se puede volver al fragment anterior
                //fragmentManager.beginTransaction().replace(R.id.contenedor, new FragmentLibrerias()).addToBackStack("tag").commit();
                //metodosVarios.abrirActivity(getActivity(), ActivityListaLibrerias.class);
                abrirActivity(getApplicationContext(), ActivityListaLibrerias.class);

            }
        });

        botonActividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //metodosVarios.abrirActivity(getActivity(), ActivityInfoActividades.class);
                abrirActivity(getApplicationContext(), ActivityInfoActividades.class);

            }
        });

        botonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //metodosVarios.abrirActivity(getActivity(), ActivityIniciarSesion.class);
                abrirActivity(getApplicationContext(), ActivityIniciarSesion.class);

            }
        });

        botonPremios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //metodosVarios.abrirActivity(getActivity(), ActivityListaPremios.class);
                abrirActivity(getApplicationContext(), ActivityListaPremios.class);
            }
        });
    }


    //METODO PARA LANZAR EL INTENT Y ABRIR UNA ACTIVITY
    public void abrirActivity(Context context, Class clase)
    {
        Intent activity = new Intent(context, clase);
        startActivity(activity);
    }
}
