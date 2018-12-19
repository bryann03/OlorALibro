package com.example.oloralibro;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MetodosVarios extends AppCompatActivity {

    //METODO PARA LANZAR EL INTENT Y ABRIR UNA ACTIVITY
    public static void abrirActivity(Context context, Class clase)
    {
        Intent activity = new Intent(context, clase);
        context.startActivity(activity);
    }


    public static String readJSONFromFile(Context context, int rutaJSON) throws IOException
    {
        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try
        {
            String jsonDataString = null;
            inputStream = context.getResources().openRawResource(rutaJSON);
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
    }

    public static void mostrarToast(Context context, String mensaje)
    {
        Toast t1 = Toast.makeText(context.getApplicationContext(), mensaje, Toast.LENGTH_SHORT);
        t1.show();
    }

    /*private void showDialogCerrarSesion(final Context context)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.styleAlertDialog);
        builder.setTitle(Html.fromHtml("<b>" + getString(R.string.cerrar_sesion) + "</b>"));
        builder.setMessage(getString(R.string.pregunta_cerrar_sesion));

        String aceptarText = getString(R.string.Si);
        builder.setPositiveButton(aceptarText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent refresh = new Intent(context, ActivityMenu.class);
                startActivity(refresh);
                finish();
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
    }*/
}
