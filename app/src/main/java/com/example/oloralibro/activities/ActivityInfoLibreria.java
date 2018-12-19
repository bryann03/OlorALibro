package com.example.oloralibro.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oloralibro.MetodosVarios;
import com.example.oloralibro.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class ActivityInfoLibreria extends AppCompatActivity {

    TextView textViewLibreria, textViewUbicacion, textViewListaActividades, textViewDescripcionLibreria,
            textViewTelefonoLibreria, textViewHorarioLibreria, textViewCorreoLibreria;
    ImageView imageViewFotoLibreria;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_libreria);

        //Muestra el botón para ir atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Esconde la StatusBar del movil
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textViewLibreria = findViewById(R.id.textViewLibreria);
        textViewUbicacion = findViewById(R.id.textViewUbicacion);
        textViewListaActividades = findViewById(R.id.textViewListaActividades);
        textViewDescripcionLibreria = findViewById(R.id.textViewDescripcionLibreria);
        textViewCorreoLibreria = findViewById(R.id.textViewCorreoLibreria);
        textViewHorarioLibreria = findViewById(R.id.textViewHorarioLibreria);
        textViewTelefonoLibreria = findViewById(R.id.textViewTelefonoLibreria);
        imageViewFotoLibreria = findViewById(R.id.imageViewFotoLibreria);

        final String nombreLibreria = getIntent().getExtras().getString("nombreLibreria");

        try {
            String jsonDataString = MetodosVarios.readJSONFromFile(getApplicationContext(), R.raw.jsonlibrerias);

            JSONObject jsonMain = new JSONObject(jsonDataString);
            JSONArray itemsJSONArray = jsonMain.getJSONArray("Librerias");


            for (int i = 0; i < itemsJSONArray.length(); i++) {

                // Creating JSONObject from JSONArray
                JSONObject jsonObj = itemsJSONArray.getJSONObject(i);

                // Getting data from individual JSONObject
                final String nombreLibreriaJSON = jsonObj.getString("Nombre");
                String descripcionLibreria = jsonObj.getString("Descripcion");
                String telefonoLibreria = jsonObj.getString("Telefono");
                String horarioLibreria = jsonObj.getString("Horario");
                String correoLibreria = jsonObj.getString("Correo");
                String imagenNombre = jsonObj.getString("Ruta Foto");

                int imagenID = getApplicationContext().getResources().getIdentifier(imagenNombre, "drawable", getApplicationContext().getPackageName());

                if(nombreLibreria.equals(nombreLibreriaJSON))
                {
                    textViewLibreria.setText(nombreLibreriaJSON);
                    textViewDescripcionLibreria.setText(descripcionLibreria);
                    textViewTelefonoLibreria.setText(telefonoLibreria);
                    textViewHorarioLibreria.setText(horarioLibreria);
                    textViewCorreoLibreria.setText(correoLibreria);
                    imageViewFotoLibreria.setImageResource(imagenID);

                    textViewListaActividades.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent activityListaActividades = new Intent(getApplicationContext(), ActivityListaActividades.class);

                            //EXTRAE EL TEXTO DEL NOMBRE DE LA LIBRERIA Y LO PASA POR PARAMETRO TIPO STRING CON EL INTENT
                            activityListaActividades.putExtra("nombreLibreria", nombreLibreriaJSON);
                            startActivity(activityListaActividades);
                        }
                    });
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        setTitle(nombreLibreria);
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

    //METODO PARA OBTENER LA LOCALIZACION AL ABRIR MAPS
    protected void getLocation(String nombreLibreria)
    {
        double latitude = 40.6420300;
        double longitude = -4.1554000;
        String label = nombreLibreria;
        String uriBegin = "geo:" + latitude + "," + longitude;
        String query = latitude + "," + longitude + "(" + label + ")";
        String encodedQuery = Uri.encode(query);
        String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
        Uri uriguri21 = Uri.parse(uriString);
        Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uriguri21);
        startActivity(mapIntent);
    }
}
