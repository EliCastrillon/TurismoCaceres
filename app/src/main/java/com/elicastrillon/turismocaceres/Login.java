package com.elicastrillon.turismocaceres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText eUsername, ePassword;
    TextView tRegistrarse;
    Button bIniciar;
    Intent intent;
    String username="", password="", correo="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // castin
        eUsername = (EditText) findViewById(R.id.eUsername);
        ePassword = (EditText) findViewById(R.id.ePassword);
        tRegistrarse = (TextView) findViewById(R.id.tRegistrarse);
        bIniciar = (Button) findViewById(R.id.bIniciar);

        //


        // Boton iniciar el logeo
        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!username.toString().equals("") && !password.toString().equals("")) {

                    //Validan que los dos campos esten diligenciados
                    if (!eUsername.getText().toString().equals("") && !ePassword.getText().toString().equals("")) {
                        //Validar los datos digitados con los del registro
                        if (eUsername.getText().toString().equals(username) && ePassword.getText().toString().equals(password)) {
                            intent = new Intent(Login.this, MainActivity.class);
                           // enviando datos a Main para perfil
                            intent.putExtra("username",username);
                            intent.putExtra("correo",correo);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Nombre de usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "LLenar Campos vacíos", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(getApplicationContext(), "Usuario no Registrado, !Por Favor Registrase¡", Toast.LENGTH_SHORT).show();

                }

            }
        });

        // Boton registrarse
        tRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent para abrir otra actividad. En donde estoy para donde voy...
                intent = new Intent (Login.this, Registro.class);
                // Iniciar la actidad previa con un numero para saber cual actividad corresponde
                startActivityForResult(intent,2524);

            }
        });


    }
    // sobrecarga de metodos...

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // validar los estados de registro...
        if (requestCode==2524 && resultCode == RESULT_OK){
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            correo = data.getExtras().getString("correo");


        }
        if (requestCode==2524 && resultCode == RESULT_CANCELED){
            Toast.makeText(this, "El  Registro Fué Cancelado", Toast.LENGTH_SHORT).show();
        }

    }



}
