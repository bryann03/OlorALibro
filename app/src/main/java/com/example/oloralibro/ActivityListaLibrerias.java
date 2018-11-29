package com.example.oloralibro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.example.oloralibro.Adaptadores.RVAdaptadorLibrerias;

import java.util.ArrayList;

public class ActivityListaLibrerias extends AppCompatActivity {

    RecyclerView rvLibrerias;
    Context context;
    ArrayList<DatosLibreria> librerias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_librerias);

        //Muestra el botón para ir atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Librerias");

        rvLibrerias = (RecyclerView) findViewById(R.id.rvLibrerias);
        rvLibrerias.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        rvLibrerias.setLayoutManager(llm);

        librerias = RepositorioDatos.getDatosLibrerias();

        RVAdaptadorLibrerias adaptador = new RVAdaptadorLibrerias(librerias, new RecyclerViewOnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Intent activityInfoLibreria = new Intent(getApplicationContext(), ActivityInfoLibreria.class);

                //CREA UN OBJETO DE LA CLASE DATOSLIBRERIA A LA QUE SE LE ASIGNA LA POSICION DEL ONITEMCLICK
                DatosLibreria nomLibreria = librerias.get(position);

                //EXTRAE EL TEXTO DEL NOMBRE DE LA LIBRERIA Y LO PASA POR PARAMETRO TIPO STRING CON EL INTENT
                activityInfoLibreria.putExtra("nombreLibreria", nomLibreria.nombreLibreria);
                startActivity(activityInfoLibreria);
            }
        });
        rvLibrerias.setAdapter(adaptador);
    }

    //METODO PARA CERRAR LA ACTIVIDAD A TRAVES DEL BOTÓN
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
