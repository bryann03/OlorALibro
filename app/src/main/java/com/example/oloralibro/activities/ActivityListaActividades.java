package com.example.oloralibro.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.oloralibro.MetodosVarios;
import com.example.oloralibro.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class ActivityListaActividades extends AppCompatActivity {

    ListView listViewActividades;
    TextView textViewActividadesDisponibles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_actividades);
        setTitle(R.string.actividades_menu);

        //Muestra el botón para ir atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Esconde la StatusBar del movil
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        listViewActividades = findViewById(R.id.listViewActividades);
        textViewActividadesDisponibles = findViewById(R.id.textViewActividadesDisponibles);

        final String nombreLibreria = getIntent().getExtras().getString("nombreLibreria");
        String tituloFinal = getString(R.string.titulo_lista_act) + nombreLibreria;



        textViewActividadesDisponibles.setText(tituloFinal);

        final ArrayList<String> listaActividades = new ArrayList<String>();
        try
        {

            //EXTRAE EL TEXTO DEL FICHERO JSON EN UN STRING
            String jsonDataString = MetodosVarios.readJSONFromFile(getApplicationContext(), R.raw.jsonactividades);

            //CREA UN OBJETO JSON Y ALMACENA EL STRING EXTRAIDO ANTERIORMENTE
            JSONObject jsonMain = new JSONObject(jsonDataString);

            //CREA UN OBJETO ARRAY DE ITEMS DE JSON Y LE PASAMOS EL NOMBRE DE LA RAIZ DE ESTE
            JSONArray itemsJSONArray = jsonMain.getJSONArray("Actividades");

            //LO RECORREMOS PARA EXTRAER LOS DATOS INDIVIDUALES DEL JSON
            for (int i = 0; i < itemsJSONArray.length(); i++) {

                // Creating JSONObject from JSONArray
                JSONObject jsonObj = itemsJSONArray.getJSONObject(i);

                // Getting data from individual JSONObject
                final String nombreLibreriaJSON = jsonObj.getString("Nombre Libreria");
                final String nombreActividad = jsonObj.getString("Nombre");

                if(nombreLibreria.equals(nombreLibreriaJSON))
                {
                    listaActividades.add(nombreActividad);
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(), R.layout.design_lv_actividades, listaActividades);
                    listViewActividades.setAdapter(adaptador);
                    listViewActividades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent activityInfoActividad = new Intent(getApplicationContext(), ActivityInfoActividades.class);

                            String nombreActividadIntent = listViewActividades.getItemAtPosition(position).toString();
                            activityInfoActividad.putExtra("nombreActividad", nombreActividadIntent);
                            startActivity(activityInfoActividad);
                        }
                    });
                }
            }
        }
        catch (IOException | JSONException exception)
        {
            Log.e(ActivityListaActividades.class.getName(), "Error al cargar JSON", exception);
        }
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
