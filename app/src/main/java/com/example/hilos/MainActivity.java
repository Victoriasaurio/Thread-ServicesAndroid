package com.example.hilos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //private Button btnLanzarTarea;
    //private Button btLanzarHilo;
    //private TextView tvResponse;
    private Button startService;
    private Button finishService;
    private TextView tv_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicio);

        tv_service = findViewById(R.id.tv_service);

        startService = findViewById(R.id.startService);
        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartService();
            }
        });

        finishService = findViewById(R.id.finishService);
        finishService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishService();
            }
        });

        /*
        tvResponse = findViewById(R.id.tvResponse);

        btnLanzarTarea = findViewById(R.id.btnLanzarTarea);
        btnLanzarTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tareaLarga();
            }
        });

        btLanzarHilo = findViewById(R.id.btnLanzarHilo);
        btLanzarHilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tareaConHilos();
            }
        });
         */
    }

    private void StartService() {
        Intent i = new Intent(this, MainService.class);
        startService(i);
        tv_service.setText("Start Service");
    }

    private void finishService() {
        Intent i = new Intent(this, MainService.class);
        stopService(i);
        tv_service.setText("Finished Service");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy Activity...");
    }

    /*
    private void tareaLarga() {
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {

        }
    }

    private void tareaConHilos() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(9000);
                }catch (InterruptedException e) {

                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvResponse.setText("Victoria Esperanza");
                    }
                });
                Log.d("TAG", "Hilo acabado");
            }
        }).start();
    }
     */
}