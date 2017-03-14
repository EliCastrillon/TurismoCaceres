package com.elicastrillon.turismocaceres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    // variables para enviar a perfil del usuario
    String  username, correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // obteniendo las variables para enviar a perfil
try {


    Bundle extras = getIntent().getExtras();  // objeto para extraer la informacion desde login que van para perfil
    username = extras.getString("username");
    correo = extras.getString("correo");

}catch (Exception e){}


    }


    // crea el menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //saber el menu presionado
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.mCerrar:
                intent = new Intent(MainActivity.this, Login.class);
              startActivity(intent);
                finish();
                break;
            case R.id.mMiPerfil:
                intent = new Intent(MainActivity.this, Perfil.class);
               // enviando los datos para perfil
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
