package dawareestudio.app_php;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;

public class MyActivity extends Activity {

    /*declaraciones de objetos*/
    private Button btnactivar;
    private Button btndesactivar;
    private WebView mWebView;
    private Button btncamara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        //codigo para mostrar lo de php
        HttpHandler handlerh = new HttpHandler();
        String txt = handlerh.post("http://daviduxotto.ddns.net/alarma/activo.php");
        TextView t = (TextView) findViewById(R.id.TextTexto);

        if (txt.equals("0\n")) {
            txt = "Alarma Desactivada";
        } else {
            txt = "Alarma activada";

        }
        t.setText(txt);
        // fin del codigo para mostrar lo de php
        //subproceso
        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {

                Toast.makeText(getApplicationContext(),"Bienvenido Al sistema Ing. Bayron ",Toast.LENGTH_LONG).show();
            }
        },3000);

        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {

                Toast.makeText(getApplicationContext(),"El Local Esta Seguro ",Toast.LENGTH_LONG).show();
            }
        },7000);
        // fin de proceso


        btnactivar = (Button) findViewById(R.id.botonActivar);
        btndesactivar = (Button) findViewById(R.id.botonDesactivar);
        btncamara = (Button) findViewById(R.id.botonCamara);
        //eventos
        btnactivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t = (TextView) findViewById(R.id.TextTexto);
                t.setText("Alarma Activada");
                HttpHandler handlerh = new HttpHandler();
                String txt = handlerh.post("http://daviduxotto.ddns.net/alarma/activar_alarma.php");

                btndesactivar.setEnabled(true);

            }
        });

        btndesactivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t = (TextView) findViewById(R.id.TextTexto);
                t.setText("Alarma Desactivada");
                HttpHandler handlerh = new HttpHandler();
                String txt = handlerh.post("http://daviduxotto.ddns.net/alarma/desactivar_alarma.php");
                btnactivar.setEnabled(true);
                btndesactivar.setEnabled(false);
            }
        });


    }


            //el delay








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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
