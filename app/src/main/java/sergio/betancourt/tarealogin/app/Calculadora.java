package sergio.betancourt.tarealogin.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Calculadora extends ActionBarActivity {

    int  memoria;
    float fltResultado,  fltaux1, fltaux2;
    String strResultado, strAux;
    boolean operacion;

    TextView txtResultado;

    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnPunto;
    Button btnSumar;
    Button btnRestar;
    Button btnMultiplicar;
    Button btnDividir;
    Button btnIgual;
    Button btnBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        memoria = 0;
        fltResultado = 0;
        fltaux1 = 0;
        fltaux2 = 0;
        strResultado = "";
        strAux = "";
        operacion = true;


        txtResultado = (TextView) findViewById(R.id.txtResultado);
        btn0 = (Button ) findViewById(R.id.btn0);
        btn1 = (Button ) findViewById(R.id.btn1);
        btn2 = (Button ) findViewById(R.id.btn2);
        btn3 = (Button ) findViewById(R.id.btn3);
        btn4 = (Button ) findViewById(R.id.btn4);
        btn5 = (Button ) findViewById(R.id.btn5);
        btn6 = (Button ) findViewById(R.id.btn6);
        btn7 = (Button ) findViewById(R.id.btn7);
        btn8 = (Button ) findViewById(R.id.btn8);
        btn9 = (Button ) findViewById(R.id.btn9);
        btnPunto = (Button ) findViewById(R.id.btnPunto);
        btnSumar = (Button ) findViewById(R.id.btnSumar);
        btnRestar = (Button ) findViewById(R.id.btnRestar);
        btnMultiplicar = (Button ) findViewById(R.id.btnMultiplicar);
        btnDividir = (Button ) findViewById(R.id.btnDividir);
        btnIgual = (Button ) findViewById(R.id.btnIgual);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presiona0();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presiona1();
            }
        });

            btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presiona2();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presiona3();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presiona4();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presiona5();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presiona6();
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presiona7();
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presiona8();
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presiona9();
            }
        });

            btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presionaSumar();
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presionaRestar();
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presionaMultiplicar();
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presionaDividir();
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fltaux1 = 0;
                fltaux2 = 0;
                strResultado = "";
                strAux = "";
                operacion = true;
                txtResultado.setText("0");
            }
        });


        btnPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presionaPunto();
            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presionaIgual(memoria);
            }
        });

    }

        private void presiona0(){
            strResultado = strResultado + 0;
            txtResultado.setText(strResultado);
        }

        private void presiona1(){
            strResultado = strResultado + 1;
            txtResultado.setText(strResultado );
        }

        private void presiona2(){
            strResultado = strResultado + 2;
            txtResultado.setText(strResultado);
        }

        private void presiona3(){
            strResultado = strResultado + 3;
            txtResultado.setText(strResultado );
        }

        private void presiona4(){
            strResultado = strResultado + 4;
            txtResultado.setText(strResultado);
        }

        private void presiona5(){
            strResultado = strResultado + 5;
            txtResultado.setText(strResultado );
        }

        private void presiona6(){
            strResultado = strResultado + 6;
            txtResultado.setText(strResultado);
        }

        private void presiona7(){
            strResultado = strResultado + 7;
            txtResultado.setText(strResultado );
        }

        private void presiona8(){
            strResultado = strResultado + 8;
            txtResultado.setText(strResultado);
        }

        private void presiona9(){
            strResultado = strResultado + 9;
            txtResultado.setText(strResultado);
        }


        private int presionaSumar(){
            memoria = 1;
            try {

                if (operacion) {
                    fltaux2 = Float.parseFloat(strResultado);
                    strResultado = "";
                    fltaux1 += fltaux2;
                    operacion = false;
                } else {
                    fltaux2 = Float.parseFloat(strResultado);
                    fltaux1 += fltaux2;
                    strResultado = "";
                    txtResultado.setText("" + fltaux1);
                }
            }
            catch (NumberFormatException e){

            }
            return memoria;
        }


    private int presionaRestar(){
        memoria = 2;
        try {
            if (operacion) {
                fltaux2 = Float.parseFloat(strResultado);
                strResultado = "";
                fltaux1 = fltaux2;
                operacion = false;
            } else {
                fltaux2 = Float.parseFloat(strResultado);
                fltaux1 -= fltaux2;
                strResultado = "";
                txtResultado.setText("" + fltaux1);
            }
        }
        catch (NumberFormatException e){

        }
        return memoria;
    }

    private int presionaMultiplicar(){
        memoria = 3;
        try {
                if (operacion) {
                fltaux2 = Float.parseFloat(strResultado);
                strResultado = "";
                fltaux1 = fltaux2;
                operacion = false;
            } else {
                fltaux2 = Float.parseFloat(strResultado);
                fltaux1 *= fltaux2;
                strResultado = "";
                txtResultado.setText("" + fltaux1);
            }
        }
        catch (NumberFormatException e){

        }
        return memoria;
    }

    private int presionaDividir(){
        memoria = 4;
        try {
            if (operacion) {
                fltaux2 = Float.parseFloat(strResultado);
                strResultado = "";
                fltaux1 = fltaux2;
                operacion = false;
            } else {
                fltaux2 = Float.parseFloat(strResultado);
                fltaux1 /= fltaux2;
                strResultado = "";
                txtResultado.setText("" + fltaux1);
            }
        }
        catch (NumberFormatException e){

        }
        catch(ArithmeticException e){
            Toast toast = Toast.makeText(getApplicationContext(),"División entre cero",Toast.LENGTH_SHORT);
        }
        return memoria;
    }

    private void presionaPunto(){
            strResultado = strResultado + ".";
    }



        private void presionaIgual(int cadena){

            switch (cadena){

                case 1:
                    try {
                            fltaux2 = Float.parseFloat(strResultado);
                            fltaux1 += fltaux2;
                            strResultado = "";
                            txtResultado.setText("" + fltaux1);

                    }
                    catch (Exception e){

                    }

                    break;

                case 2:
                    try{

                        fltaux2 = Float.parseFloat(strResultado);
                        fltaux1 -= fltaux2;
                        strResultado = "";
                        txtResultado.setText("" + fltaux1);
                    }
                    catch(Exception e){

                    }
                    break;


                case 3:
                    try{
                        fltaux2 = Float.parseFloat(strResultado);
                        fltaux1 *= fltaux2;
                        strResultado = "";
                        txtResultado.setText("" + fltaux1);
                    }
                    catch(Exception e){

                    }

                case 4:
                    try{
                        fltaux2 = Float.parseFloat(strResultado);
                        fltaux1 /= fltaux2;
                        strResultado = "";
                        txtResultado.setText("" + fltaux1);
                    }
                    catch (Exception e){
                        Toast toast = Toast.makeText(getApplicationContext(), "Division entre cero", Toast.LENGTH_SHORT);
                    }

                    default:
                        operacion = true;
            }


        }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculadora, menu);
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
