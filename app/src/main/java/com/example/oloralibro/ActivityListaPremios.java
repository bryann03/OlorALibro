package com.example.oloralibro;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oloralibro.Adaptadores.RVAdaptadorPremios;

import java.util.ArrayList;

public class ActivityListaPremios extends AppCompatActivity {

    RecyclerView rvPremios;
    Context context;
    public ArrayList<DatosPremios> premios;
    TextView txtViewMisPuntos;
    int misPuntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Muestra el botón para ir atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_lista_premios);

        rvPremios = findViewById(R.id.rvPremios);
        txtViewMisPuntos = findViewById(R.id.txtViewMisPuntos);
        misPuntos = Integer.parseInt(txtViewMisPuntos.getText().toString());

        //EVITA QUE SE CAMBIE EL TAMAÑO DEL RECYVLERVIEW
        rvPremios.setHasFixedSize(true);


        LinearLayoutManager llm = new LinearLayoutManager(context);
        rvPremios.setLayoutManager(llm);
        premios = RepositorioDatos.getDatosPremios();
        RVAdaptadorPremios adaptador = new RVAdaptadorPremios(premios);

        rvPremios.setAdapter(adaptador);
        adaptador.setOnItemClickListener(new RVAdaptadorPremios.OnItemClickListener() {

            //METODO PARA LLAMAR AL EVENTO ONCLICK DEL BOTÓN CANJEAR
            @Override
            public void onCanjearClick(int position) {
                showDialogCanjear(position);
            }
        });
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

    //METODO PARA MOSTRAR EL DIALOGO DE CONFIRMACION DE CANJEO DE PREMIO
    private void showDialogCanjear(int position)
    {
        final DatosPremios premio = premios.get(position);
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityListaPremios.this, R.style.styleAlertDialog);
        builder.setTitle(Html.fromHtml("<b>" + getString(R.string.canjear_premio) + "</b>"));
        builder.setMessage(getString(R.string.pregunta_canjear_1) + premio.costePremio + getString(R.string.pregunta_canjear_2));

        String aceptarText = getString(R.string.Canjear);
        builder.setPositiveButton(aceptarText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(premio.costePremio > misPuntos)
                {
                    MetodosVarios.mostrarToast(getApplicationContext(), getString(R.string.puntos_insuf));

                }
                else
                {
                    misPuntos = misPuntos - premio.costePremio;
                    txtViewMisPuntos.setText(String.valueOf(misPuntos));
                    MetodosVarios.mostrarToast(getApplicationContext(), getString(R.string.canjeado));
                }
            }
        });

        String cancelarText = getString(R.string.cancelar);
        builder.setNegativeButton(cancelarText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialogo = builder.create();
        dialogo.show();;
    }
}
