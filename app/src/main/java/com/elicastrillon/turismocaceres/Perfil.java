package com.elicastrillon.turismocaceres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Perfil extends AppCompatActivity {
    Intent intent;

    TextView tUsername, tCorreo;
    String username, correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tUsername = (TextView) findViewById(R.id.tUsername);
        tCorreo = (TextView) findViewById(R.id.tCorreo);

        try{
        // obteniendo las variables para enviar a perfil
        Bundle extras = getIntent().getExtras();  // objeto para extraer la informacion desde login
            username = extras.getString("username");
            correo = extras.getString("correo");
        }catch (Exception e){
            e.printStackTrace();
        }

        tUsername.setText(username);
        tCorreo.setText(correo);

    }

    // crea el menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu1) {
        getMenuInflater().inflate(R.menu.menu1, menu1);
        return true;
    }

    //saber el menu presionado
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        switch (id){

            // Menu principal
            case R.id.mPrincipal:
                intent = new Intent(Perfil.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;

            // cerrando la sesion
            case R.id.mCerrarSesion:
                intent = new Intent(Perfil.this, Login.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                break;

        }

        return super.onOptionsItemSelected(item);
    }


}
