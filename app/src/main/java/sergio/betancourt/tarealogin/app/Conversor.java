package sergio.betancourt.tarealogin.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;


public class Conversor extends ActionBarActivity {
    Button btnCentigrados, btnFarenheit;
    EditText edtTemperatura;
    TextView txtResultado;

    float temperatura, resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);

        btnCentigrados = (Button) findViewById(R.id.btnCentigrados);
        btnFarenheit = (Button) findViewById(R.id.btnFarenheit);
        edtTemperatura = (EditText) findViewById(R.id.edtResultado);
        txtResultado = (TextView) findViewById(R.id.txtResultado);

        temperatura = 0;

        btnCentigrados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertirCentaFar();
            }
        });

        btnFarenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertirFaraCent();
            }
        });
    }


        private void convertirCentaFar(){
            try{
            temperatura = Float.parseFloat(edtTemperatura.getText().toString());
            resultado = (temperatura * 1.8f) + 32;
            txtResultado.setText("Los grados Fahrenheit son: " + resultado);}
            catch(Exception e){
                Toast toast = Toast.makeText(getApplicationContext(), "Debe de ingresar una temperatura", Toast.LENGTH_LONG);
            }
        }

        private void convertirFaraCent(){
            try {
                temperatura = Float.parseFloat(edtTemperatura.getText().toString());
                resultado = (temperatura - 32) * (0.555555555555555555f);
                txtResultado.setText("Los grados Centigrados son: " + resultado);
            }
            catch(Exception e){
                Toast toast = Toast.makeText(getApplicationContext(), "Debe de ingresar una temperatura", Toast.LENGTH_LONG);
            }
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.conversor, menu);
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
