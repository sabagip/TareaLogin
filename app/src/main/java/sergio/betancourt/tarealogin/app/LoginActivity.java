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
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends ActionBarActivity {

    //Estaticos
    static String NAME = "admin";
    static String PASS = "1234";

    //Elementos layout
    EditText edtNombre;
    EditText edtPasw;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtNombre = (EditText) findViewById(R.id.txtUsuario);
        edtPasw = (EditText) findViewById(R.id.txtContrasena);
        btnLogin = (Button) findViewById(R.id.btnLogin);


        //Recuperamos las preferencias almacenadas
        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        String name = prefs.getString("name", "");
        String pass = prefs.getString("pass", "");

        //Comprobamos nombre y clave de ususario
        if (name.equals(NAME) && pass.equals(PASS)) {

            //Si el usuario almacenado es correcto, entramos en la app
            Intent intent = new Intent(LoginActivity.this, Principal.class);
            startActivity(intent);
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNombre.getText().toString().equals(NAME) && edtPasw.getText().toString().equals(PASS)) {
                    //Si el usuario escrito es correcto, almacenamos la preferencia y entramos en la app
                    SharedPreferences settings = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("name", edtNombre.getText().toString());
                    editor.putString("pass", edtPasw.getText().toString());

                    //Confirmamos el almacenamiento.
                    editor.commit();

                    //Entramos en la app
                    Intent intent = new Intent(LoginActivity.this, Principal.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecto", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
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
