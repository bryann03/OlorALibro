package com.example.oloralibro;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
        setContentView(R.layout.activity_lista_premios);

        rvPremios = (RecyclerView) findViewById(R.id.rvPremios);
        rvPremios.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        rvPremios.setLayoutManager(llm);
        premios = RepositorioDatos.getDatosPremios();
        RVAdaptadorPremios adaptador = new RVAdaptadorPremios(premios);
        rvPremios.setAdapter(adaptador);
    }
}