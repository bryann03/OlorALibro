package com.example.oloralibro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class MetodosVarios extends AppCompatActivity {

    //METODO PARA LANZAR EL INTENT Y ABRIR UNA ACTIVITY
    public static void abrirActivity(Context context, Class clase)
    {
        Intent activity = new Intent(context, clase);
        context.startActivity(activity);
    }

    public String obtenerStringIntent(String clave)
    {
        String stringIntent = getIntent().getExtras().getString(clave);
        return stringIntent;
    }

    public static void mostrarToast(Context context, String mensaje)
    {
        Toast t1 = Toast.makeText(context.getApplicationContext(), mensaje, Toast.LENGTH_SHORT);
        t1.show();
    }
}
