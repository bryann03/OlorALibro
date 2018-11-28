package com.example.oloralibro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegistrarse extends AppCompatActivity {

    EditText editTextRegistroNombre, editTextRegistroApellido, editTextRegistroEmail,
            editTextRegistroContraseña, editTextRegistroRepiteContraseña;
    CheckBox checkBoxTermes, checkBoxPublicitat;
    Button buttonRegistroRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
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
                    Toast t1 = Toast.makeText(getApplicationContext(),"Uno o mas campos están vacios", Toast.LENGTH_SHORT);
                    t1.show();
                }
                else
                {
                    Intent pantallaInicioSesión = new Intent(getApplicationContext(), ActivityIniciarSesion.class);
                    startActivity(pantallaInicioSesión);
                }
            }
        });

        //Esconde la StatusBar del movil
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
