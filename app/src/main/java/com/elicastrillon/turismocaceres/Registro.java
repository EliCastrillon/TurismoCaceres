package com.elicastrillon.turismocaceres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    EditText eRegUsername, eRegPassword, eRegRepPassword, eRegCorreo;
    Button bRegistrarse, bCancelar;
    String username="", password="", repPassword="", correo="";
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // castin
        eRegUsername = (EditText) findViewById(R.id.eRegUsername);
        eRegPassword = (EditText) findViewById(R.id.eRegPassword);
        eRegRepPassword = (EditText) findViewById(R.id.eRegRepPassword);
        eRegCorreo = (EditText) findViewById(R.id.eRegCorreo);
        bRegistrarse = (Button) findViewById(R.id.bRegistrarse);
        bCancelar = (Button) findViewById(R.id.bCancelar);

         // escuchadores de los botones Registrar y Cancelar

        bRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                username = eRegUsername.getText().toString();
                password = eRegPassword.getText().toString();
                repPassword = eRegRepPassword.getText().toString();
                correo = eRegCorreo.getText().toString();

                // comprovando que los campos tengan datos

                if (username.equals("")&& password.equals("") && repPassword.equals("") && correo.equals("")){
                    Toast.makeText(getApplicationContext(),"Las Campos están vacios", Toast.LENGTH_SHORT).show();
                }
                else if(username.equals("")){
                    Toast.makeText(getApplicationContext(),"El campo Usuario está vacio", Toast.LENGTH_SHORT).show();
                }
                else if(password.equals("")) {
                    Toast.makeText(getApplicationContext(), "El campo contraseña está vacío", Toast.LENGTH_SHORT).show();
                }
                else if(repPassword.equals("")) {
                    Toast.makeText(getApplicationContext(), "El campo repetir contraseña está vacío", Toast.LENGTH_SHORT).show();
                }
                else if(correo.equals("")) {
                    Toast.makeText(getApplicationContext(), "El campo correo está vacío", Toast.LENGTH_SHORT).show();
                }
                else {
                    // comprovando que las contraseñas sean iguales
                    if (password.equals(repPassword)) {
                        //Enviando datos a la actividad login para el ingreso a la aplicacion.
                        intent = new Intent();
                        intent.putExtra("username", username);
                        intent.putExtra("password", password);
                        intent.putExtra("correo",correo);
                        // enviando los datos del intent
                        setResult(RESULT_OK, intent);
                        finish();



                    }else {
                        Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }

                }





            }

        });

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // cancelando el registro en la aplicación
                intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });
    }
}
