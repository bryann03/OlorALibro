package com.example.oloralibro.activities;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.oloralibro.MetodosVarios;
import com.example.oloralibro.R;

import java.util.Locale;

public class ActivityMenu extends AppCompatActivity {

    Button botonLibrerias, botonActividades, botonIniciarSesion, botonPremios, botonConfiguracion, botonAcercaDe;
    Boolean userIniciado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle(getString(R.string.mnsje_bienvenida_1) + "Olor A Libro!");

        //Esconde la StatusBar del movil
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final int userSesionIniciada = getIntent().getIntExtra("userSesionIniciada", 0);
        final String nombreUser = getIntent().getStringExtra("nombreUser");

        String bienvenida = getString(R.string.mnsje_bienvenida_2) + nombreUser + "!";

        botonLibrerias = findViewById(R.id.BotonLibrerias);
        botonActividades = findViewById(R.id.BotonActividades);
        botonIniciarSesion = findViewById(R.id.BotonIniciarSesion);
        botonPremios = findViewById(R.id.BotonPremios);
        botonConfiguracion = findViewById(R.id.BotonConfiguracion);
        botonAcercaDe = findViewById(R.id.BotonAcercaDe);

        //RECIBIMOS LA VARIABLE DEFINIDA EN LA ACTIVITY DE INICIO DE SESION, SI ES 1 SE CAMBIA EL TEXTO DEL BOTON
        //DE INICAR SESION A CERRAR SESIÓN
        //Y CUANDO LE DA
        if(userSesionIniciada == 1)
        {
            userIniciado = true;
            botonIniciarSesion.setText(R.string.cerrar_sesion);
            setTitle(bienvenida);
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
                MetodosVarios.mostrarToast(getApplicationContext(), "COMING SOON!");
            }
        });

        botonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MetodosVarios.abrirActivity(getApplicationContext(), ActivityIniciarSesion.class);
            }
        });

        botonPremios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MetodosVarios.abrirActivity(getApplicationContext(), ActivityListaPremios.class);
            }
        });

        botonConfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MetodosVarios.abrirActivity(getApplicationContext(), ActivityConfiguracion.class);
            }
        });

        botonAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MetodosVarios.abrirActivity(getApplicationContext(), ActivitySobreNosotros.class);
            }
        });
    }

    /*private void showDialogCerrarSesion()
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
    }*/

}
