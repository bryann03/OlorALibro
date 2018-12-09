package com.example.oloralibro;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class ActivityIniciarSesion extends AppCompatActivity {

    private final int ACTIVITY_CODIGO = 1;
    Button botonRegistrarse, botonIniciarSesion;
    EditText editTextEmail;
    Boolean userSesionIniciada = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        setTitle(R.string.iniciar_sesion);

        //Muestra el botón para ir atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Esconde la StatusBar del movil
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //ASIGNACION VARIABLES
        editTextEmail = findViewById(R.id.editTextEmail);
        botonRegistrarse =  findViewById(R.id.botonRegistrarse);
        botonIniciarSesion = findViewById(R.id.botonIniciarSesion);

        //RECIBO INTENT CON EL EMAIL DEL USUARIO
        final String emailUser = getIntent().getStringExtra("emailUser");


        botonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SE LANZA LA ACTIVIDAD DEL MENU PRINCIPAL CON EL ForResult PARA QUE SE RECIBA EL EMAIL INTORDUCIDO
                //AL HACER EL REGISTRO
                Intent activityRegistrarse = new Intent(getApplicationContext(), ActivityRegistrarse.class);
                startActivityForResult(activityRegistrarse, ACTIVITY_CODIGO);
            }
        });

        botonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //SE LANZA LA ACTIVIDAD DEL MENU PRINCIPAL Y LE PASAMOS UNA VARIABLE TIPO INT PARA VERIFICAR
                //SI EL USUARIO HA PODIDO INICIAR SESION CORRECTAMENTE, SI ES 1 SE LANZA LA ACTIVIDAD SINO
                //SALE UN MENSJAE DE ERROR
                Intent activityMenuPrincipal = new Intent(getApplicationContext(), ActivityMenu.class);
                activityMenuPrincipal.putExtra("userSesionIniciada", 1);
                startActivity(activityMenuPrincipal);

                /*if(COMPROBACION DEL USUARIO CON EL JSON PA`VER SI EXISTE)
                {

                    Intent activityMenuPrincipal = new Intent(getApplicationContext(), ActivityMenu.class);
                    activityMenuPrincipal.putExtra("userSesionIniciada", 1);
                    startActivity(activityMenuPrincipal);
                }
                 */
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

    //METODO PARA RECIBIR DATOS DE OTRO ACTIVITY
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        //VERIFICAMOS SI ES CORRECTO LOS "Result"
        if(requestCode == ACTIVITY_CODIGO  && resultCode  == RESULT_OK)
        {
            String emailUser = data.getStringExtra("emailUser");
            editTextEmail.setText(emailUser);
        }
    }
}
