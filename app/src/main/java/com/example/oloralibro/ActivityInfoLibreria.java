package com.example.oloralibro;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.oloralibro.Fragments.FragmentMenu;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class ActivityInfoLibreria extends AppCompatActivity implements Toolbar.OnMenuItemClickListener
{

    TextView textViewLibreria, textViewUbicacion;
    //MetodosVarios metodosVarios = new MetodosVarios();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_libreria);

        //Muestra el botón para ir atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Librerias");

        /*IMPLEMENTA EL ICONO "HOME" EN LA STATUS BAR
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.activity_menu_principal);
        toolbar.setOnMenuItemClickListener(this);*/

        textViewLibreria = (TextView) findViewById(R.id.textViewLibreria);
        textViewUbicacion = (TextView) findViewById(R.id.textViewUbicacion);

        /*Bundle b = new Bundle();
        b = getIntent().getExtras();
        final String nombreLibreria = b.getString("nombreLibreria");*/

        //final String nombreLibreria = metodosVarios.obtenerStringIntent("nombreLibreria");
        final String nombreLibreria = getIntent().getExtras().getString("nombreLibreria");
        textViewLibreria.setText(nombreLibreria);

        textViewUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation(nombreLibreria);
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

    protected void getLocation(String nombreLibreria)
    {
        double latitude = 41.3818;
        double longitude = 2.1685;
        String label = nombreLibreria;
        String uriBegin = "geo:" + latitude + "," + longitude;
        String query = latitude + "," + longitude + "(" + label + ")";
        String encodedQuery = Uri.encode(query);
        String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
        Uri uri = Uri.parse(uriString);
        Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
        startActivity(mapIntent);
    }


    //METODO PARA DAR ACCION AL BOTÓN "HOMEDEL STATUS BAR
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.iconoMenuPrincipal)
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.contenedor, new FragmentMenu()).commit();
            return true;
        }

        return true;
    }
}
