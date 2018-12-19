package com.example.oloralibro.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.oloralibro.MetodosVarios;
import com.example.oloralibro.R;

public class ActivityRegistrarse extends AppCompatActivity {

    EditText editTextRegistroNombre, editTextRegistroApellido, editTextRegistroEmail,
            editTextRegistroContraseña, editTextRegistroRepiteContraseña;
    CheckBox checkBoxTermes, checkBoxPublicitat;
    Button buttonRegistroRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        //Muestra el botón para ir atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Esconde la StatusBar del movil
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("Registro");

        editTextRegistroNombre = findViewById(R.id.editTextRegistroNombre);
        editTextRegistroApellido = findViewById(R.id.editTextRegistroApellido);
        editTextRegistroEmail = findViewById(R.id.editTextRegistroEmail);
        editTextRegistroContraseña = findViewById(R.id.editTextRegistroContraseña);
        editTextRegistroRepiteContraseña = findViewById(R.id.editTextRegistroRepiteContraseña);
        buttonRegistroRegistrarse = findViewById(R.id.buttonRegistroRegistrarse);

        buttonRegistroRegistrarse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(editTextRegistroNombre.getText().toString().isEmpty() || editTextRegistroApellido.getText().toString().isEmpty() ||
                        editTextRegistroEmail.getText().toString().isEmpty() || editTextRegistroContraseña.getText().toString().isEmpty() ||
                        editTextRegistroRepiteContraseña.getText().toString().isEmpty())
                {
                    MetodosVarios.mostrarToast(getApplicationContext(), "Uno o mas campos están vacios");
                }
                else if (!editTextRegistroContraseña.getText().toString().equals(editTextRegistroRepiteContraseña.getText().toString()))
                {
                    MetodosVarios.mostrarToast(getApplicationContext(),"¡Las contraseñas no coinciden!");
                }
                else
                {
                    /*//GUARDAR USUARIO EN ARCHIVO JSON!!!!!!!
                    String nombre, apellido, email, contraseña;
                    nombre = editTextRegistroNombre.getText().toString();
                    apellido = editTextRegistroApellido.getText().toString();
                    email = editTextRegistroEmail.getText().toString();
                    contraseña = editTextRegistroContraseña.getText().toString();

                    JSONObject json = new JSONObject();

                    try
                    {
                        json.put("nombreUser", nombre);
                        json.put("apellidoUser", apellido);
                        json.put("emailUser", email);
                        json.put("contraseñaUser", contraseña);
                    }
                    catch (JSONException e)
                    {

                    }*/
                    Intent iniciarSesion = new Intent(getApplicationContext(), ActivityIniciarSesion.class);
                    iniciarSesion.putExtra("userSesionIniciada", 1);
                    iniciarSesion.putExtra("emailUser", editTextRegistroEmail.getText().toString());
                    iniciarSesion.putExtra("nombreUser", editTextRegistroNombre.getText().toString());
                    //setResult(Activity.RESULT_OK, iniciarSesion);
                    startActivity(iniciarSesion);
                    finish();
                }
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
}
