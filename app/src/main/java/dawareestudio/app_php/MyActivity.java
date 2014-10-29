package dawareestudio.app_php;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MyActivity extends Activity {

    //declaraciones de objetos
    private Button btnactivar;
    private Button btndesactivar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        //codigo para mostrar lo de php
        HttpHandler handler = new HttpHandler();
        String txt = handler.post("http://192.168.1.50/alarma/estado.php");
        TextView t = (TextView)findViewById(R.id.TextTexto);

        if(txt.equals("0\n"))
        {
            txt="Alarma Desactivada";
        }
        else
        {
            txt="Alarma activada";
        }
        t.setText(txt);
        // fin del codigo para mostrar lo de php

        btnactivar = (Button)findViewById(R.id.botonActivar);
        btndesactivar = (Button)findViewById(R.id.botonDesactivar);
        //eventos
        btnactivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btndesactivar.setEnabled(true);
                btnactivar.setEnabled(false);
            }
        });

        btndesactivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnactivar.setEnabled(true);
                btndesactivar.setEnabled(false);
            }
        });

    }


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
