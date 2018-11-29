package com.example.oloralibro;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.oloralibro.Adaptadores.RVAdaptadorPremios;

import java.util.ArrayList;

public class ActivityListaPremios extends AppCompatActivity {

    RecyclerView rvPremios;
    Context context;
    public ArrayList<DatosPremios> premios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Muestra el botón para ir atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_lista_premios);

        rvPremios = (RecyclerView) findViewById(R.id.rvPremios);

        //EVITA QUE SE CAMBIE EL TAMAÑO DEL RECYVLERVIEW
        rvPremios.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(context);
        rvPremios.setLayoutManager(llm);
        premios = RepositorioDatos.getDatosPremios();
        RVAdaptadorPremios adaptador = new RVAdaptadorPremios(premios);
        rvPremios.setAdapter(adaptador);
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
