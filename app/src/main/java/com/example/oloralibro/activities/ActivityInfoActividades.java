package com.example.oloralibro.activities;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.oloralibro.DatosPremios;
import com.example.oloralibro.MetodosVarios;
import com.example.oloralibro.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class ActivityInfoActividades extends AppCompatActivity {

    TextView textViewNombreActividad, textViewDescripcionActividad, textViewDireccionActividad, textViewFechaActividad,
            textViewPrecioActividad, textViewPuntosPremioActividad;
    ImageView imageViewActividad;
    Button buttonApuntarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_actividades);
        setTitle(R.string.actividades_menu);

        //Muestra el botón para ir atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Esconde la StatusBar del movil
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textViewDescripcionActividad = findViewById(R.id.textViewDescripcionActividad);
        textViewDireccionActividad = findViewById(R.id.textViewDireccionActividad);
        textViewFechaActividad = findViewById(R.id.textViewFechaActividad);
        textViewNombreActividad = findViewById(R.id.textViewNombreActividad);
        textViewPrecioActividad = findViewById(R.id.textViewPrecioActividad);
        textViewPuntosPremioActividad = findViewById(R.id.textViewPuntosPremioActividad);
        imageViewActividad = findViewById(R.id.imageViewActividad);
        buttonApuntarse = findViewById(R.id.buttonApuntarse);

        final String nombreActividad = getIntent().getExtras().getString("nombreActividad");


        try
        {
            String jsonDataString = MetodosVarios.readJSONFromFile(getApplicationContext(), R.raw.jsonactividades);
            JSONObject jsonMain = new JSONObject(jsonDataString);
            JSONArray itemsJSONArray = jsonMain.getJSONArray("Actividades");

            for (int i = 0; i < itemsJSONArray.length(); i++) {

                // Creating JSONObject from JSONArray
                JSONObject jsonObj = itemsJSONArray.getJSONObject(i);

                // Getting data from individual JSONObject
                final String nombreActividadJSON = jsonObj.getString("Nombre");
                String fechaActividad = jsonObj.getString("Fecha");
                String direccionActividad = jsonObj.getString("Ubicacion");
                String puntosActividad = jsonObj.getString("Puntos");
                String descripcionActividad = jsonObj.getString("Descripcion");
                String precioActividad = jsonObj.getString("Precio");
                String imagenActividad = jsonObj.getString("Ruta Foto");

                int imagenID = getApplicationContext().getResources().getIdentifier(imagenActividad, "drawable", getApplicationContext().getPackageName());

                if(nombreActividad.equals(nombreActividadJSON))
                {
                    textViewNombreActividad.setText(nombreActividadJSON);
                    textViewFechaActividad.setText(fechaActividad);
                    textViewDireccionActividad.setText(direccionActividad);
                    textViewPuntosPremioActividad.setText(puntosActividad);
                    textViewDescripcionActividad.setText(descripcionActividad);
                    textViewPrecioActividad.setText(precioActividad);
                    imageViewActividad.setImageResource(imagenID);

                }
            }
        }
        catch (IOException | JSONException exception)
        {
            Log.e(ActivityListaPremios.class.getName(), "Error al cargar JSON", exception);
        }

        buttonApuntarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showDialogApuntado(nombreActividad);
                MetodosVarios.mostrarToast(getApplicationContext(), getString(R.string.apuntado_actividad));
            }
        });

    }

    //METODO PARA MOSTRAR EL DIALOGO DE CONFIRMACION DE CANJEO DE PREMIO
    protected void showDialogApuntado(String nombreAct)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext(), R.style.styleAlertDialog);
        builder.setTitle(Html.fromHtml("<b>" + nombreAct + "</b>"));
        builder.setMessage(getString(R.string.apuntado_actividad));

        String aceptarText = getString(R.string.Canjear);
        builder.setPositiveButton(aceptarText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialogo = builder.create();
        dialogo.show();;
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
