package com.elicastrillon.turismocaceres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView texMunicipio;

    Intent intent;
    // variables para enviar a perfil del usuario
    String  username, correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // obteniendo las variables para enviar a perfil
        texMunicipio = (TextView) findViewById(R.id.texMunicipio);
try {


    Bundle extras = getIntent().getExtras();  // objeto para extraer la informacion desde login que van para perfil
    username = extras.getString("username");
    correo = extras.getString("correo");

}catch (Exception e){}

          texMunicipio.setText("Nombre del municipio: Cáceres\n" +
                          "\n" +
                          "NIT: 890981567-1\n" +
                          "\n" +
                          "Código Dane: 05120\n" +
                          "\n" +
                          "Gentilicio: Cacereño - ña\n" +
                          "\n" +
                          "Otros nombres que ha recibido el municipio: San Miguel de Cáceres, San Martín de Cáceres," +
                          " Santa Maria Magdalena de Cáceres y Campamento del César.\n"+
                  "Extensión total:1953 Km2\n" +
                  "Extensión área urbana:1 Km2\n" +
                  "Extensión área rural:1952 Km2\n" +
                  "Altitud de la cabecera municipal (metros sobre el nivel del mar): 150 Mts\n" +
                  "Temperatura media: 28º a 35º C\n" +
                  "Distancia de referencia: 230 Km de Medellín");
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
            case R.id.mHoteles:
                intent = new Intent(MainActivity.this, Hoteles.class);
                startActivity(intent);
                finish();
                break;
            case R.id.mRestaurantes:
                intent = new Intent(MainActivity.this, Restaurantes.class);
                startActivity(intent);
                finish();
                break;
            case R.id.mBares:
               intent = new Intent(MainActivity.this, Bares.class);
                startActivity(intent);
                finish();
                break;
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
