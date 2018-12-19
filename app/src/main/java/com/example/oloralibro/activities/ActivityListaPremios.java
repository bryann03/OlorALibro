package com.example.oloralibro.activities;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.oloralibro.Adaptadores.RVAdaptadorPremios;
import com.example.oloralibro.DatosPremios;
import com.example.oloralibro.MetodosVarios;
import com.example.oloralibro.R;
import com.example.oloralibro.RepositorioDatos;

import java.util.ArrayList;

public class ActivityListaPremios extends AppCompatActivity {

    RecyclerView rvPremios;
    ArrayList<DatosPremios> premios;
    TextView txtViewMisPuntos;
    int misPuntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Muestra el botón para ir atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Esconde la StatusBar del movil
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lista_premios);

        rvPremios = findViewById(R.id.rvPremios);
        txtViewMisPuntos = findViewById(R.id.txtViewMisPuntos);
        misPuntos = Integer.parseInt(txtViewMisPuntos.getText().toString());

        //EVITA QUE SE CAMBIE EL TAMAÑO DEL RECYVLERVIEW
        rvPremios.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
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

    /*private void addItemsFromJSON()
    {
        try
        {
            String jsonDataString = readJSONFromFile();
            JSONArray itemsJSONArray = new JSONArray(jsonDataString);

            for(int contador = 0; contador < itemsJSONArray.length(); contador++)
            {
                JSONObject itemObject = itemsJSONArray.getJSONObject(contador);

                String nombrePremio = itemObject.getString("Nombre");
                String descripcionPremio = itemObject.getString("Descripcion");
                String puntos = itemObject.getString("Puntos");
                String urlImagenPremio = itemObject.getString("Ruta foto");

                DatosPremios premio = new DatosPremios(nombrePremio, descripcionPremio, puntos, urlImagenPremio);
                arrayPremiosJSON.add(premio);
            }
        }
        catch (IOException | JSONException exception)
        {
            Log.e(ActivityListaPremios.class.getName(), "Error al cargar JSON", exception);
        }
    }

    private String readJSONFromFile() throws IOException
    {
        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try
        {
            String jsonDataString = null;
            inputStream = getResources().openRawResource(R.raw.jsonpremios);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));
            while ((jsonDataString = bufferedReader.readLine()) != null){
                builder.append(jsonDataString);
            }
        } finally {
            if (inputStream != null){
                inputStream.close();
            }
        }

        return new String(builder);
    }*/

    /*public void loadJSONFromAsset() throws IOException, JSONException
    {
        String json = null;

        try
        {
            InputStream inputStream = context.getAssets().open("JSON_Premios.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

            JSONObject obj = new JSONObject(json);
            JSONArray jsonArrayPremios = obj.getJSONArray("Premios");
            ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> m_li;

            for(int contador = 0; contador < jsonArrayPremios.length(); contador++)
            {
                JSONObject jo_inside = jsonArrayPremios.getJSONObject(contador);
                String nombrePremio = jo_inside.getString("Nombre");
                String descripcionPremio = jo_inside.getString("Descripcion");
                String puntos = jo_inside.getString("Puntos");
                String urlImagenPremio = jo_inside.getString("Ruta foto");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }*/
}
