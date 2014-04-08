package sergio.betancourt.tarealogin.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Principal extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ImageButton btnCalculadora = (ImageButton) findViewById(R.id.imgCalculadora);
        ImageButton btnConversor = (ImageButton) findViewById(R.id.imgTermometro);

        final Button btnCerrarSesion = (Button) findViewById(R.id.btnCerrarSesion);


        btnCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarCalculadora();
            }
        });

        btnConversor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarConversor();
            }
        });

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCerrarSesion();
            }
        });



    }




    private void cambiarCalculadora() {
        Intent intent = new Intent(this, Calculadora.class);
        startActivityForResult(intent, 0);

    }


    private void cambiarConversor(){
        Intent intent = new Intent(this, Conversor.class);
        startActivityForResult(intent, 0);
    }

    private void btnCerrarSesion() {
        //Borramos el usuario almacenado en preferencias y volvemos a la pantalla de login
        SharedPreferences settings = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("name", "");
        editor.putString("pass", "");


        //Confirmamos el almacenamiento.
        editor.commit();


        //Volvemos a la pantalla de Login
        Intent intent = new Intent(Principal.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
