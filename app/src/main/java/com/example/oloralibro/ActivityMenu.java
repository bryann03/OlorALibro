package com.example.oloralibro;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

public class ActivityMenu extends AppCompatActivity {

    Button botonLibrerias, botonActividades, botonIniciarSesion, botonPremios;
    Boolean userIniciado = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle(R.string.mnsje_bienvenida);

        final int userSesionIniciada = getIntent().getIntExtra("userSesionIniciada", 0);

        botonLibrerias = findViewById(R.id.BotonLibrerias);
        botonActividades = findViewById(R.id.BotonActividades);
        botonIniciarSesion = findViewById(R.id.BotonIniciarSesion);
        botonPremios = findViewById(R.id.BotonPremios);

        //RECIBIMOS LA VARIABLE DEFINIDA EN LA ACTIVITY DE INICIO DE SESION, SI ES 1 SE CAMBIA EL TEXTO DEL BOTON
        //DE INICAR SESION A CERRAR SESIÓN
        //Y CUANDO LE DA
        if(userSesionIniciada == 1)
        {
            userIniciado = true;
            botonIniciarSesion.setText(R.string.cerrar_sesion);
            /*botonIniciarSesion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDialogCerrarSesion();
                }
            });*/
        }
        botonLibrerias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //REEMPLAZA EL CONTENEDOR DE LOS FRAGMENTS POR UNO ESPECIFICO
                //con "addToBackStack" se puede volver al fragment anterior
                //fragmentManager.beginTransaction().replace(R.id.contenedor, new FragmentLibrerias()).addToBackStack("tag").commit();
                MetodosVarios.abrirActivity(getApplicationContext(), ActivityListaLibrerias.class);

            }
        });

        botonActividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MetodosVarios.abrirActivity(getApplicationContext(), ActivityInfoActividades.class);
            }
        });

        botonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userIniciado)
                {
                    showDialogCerrarSesion();
                }
                else{

                    MetodosVarios.abrirActivity(getApplicationContext(), ActivityIniciarSesion.class);
                }
            }
        });

        botonPremios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MetodosVarios.abrirActivity(getApplicationContext(), ActivityListaPremios.class);
            }
        });
    }

    private void showDialogCerrarSesion()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext(), R.style.styleAlertDialog);
        builder.setTitle(Html.fromHtml("<b>" + getString(R.string.cerrar_sesion) + "</b>"));
        builder.setMessage(getString(R.string.pregunta_cerrar_sesion));

        String aceptarText = getString(R.string.Si);
        builder.setPositiveButton(aceptarText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent refresh = new Intent(getApplicationContext(), ActivityMenu.class);
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
    }

}
