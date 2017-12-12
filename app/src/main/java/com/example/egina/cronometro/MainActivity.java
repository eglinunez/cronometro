package com.example.egina.cronometro;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    Button contar1,pausar1;
    Chronometer cronometro1;
    long time=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    cronometro1 =(Chronometer) findViewById(R.id.cronometro3);
    contar1 =(Button) findViewById(R.id.contar2);
    pausar1 = (Button) findViewById(R.id.pausar2);

    contar1.setEnabled(true);
    pausar1.setEnabled(false);

    contar1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            contar1.setEnabled(false);
            pausar1.setEnabled(true);
            cronometro1.setBase(SystemClock.elapsedRealtime());
            cronometro1.start();
        }
    });
    pausar1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            contar1.setEnabled(true);
            pausar1.setEnabled(false);
            cronometro1.stop();
        }
    });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
