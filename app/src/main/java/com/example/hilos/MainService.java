package com.example.hilos;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MainService extends Service {

    public void init() {
        Log.d("TAG", "Service running");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("TAG", "onCreate...");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "Service destroyed...");
    }
}
