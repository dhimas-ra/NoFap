package com.example.nofap.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.nofap.LoginActivity;
import com.example.nofap.MainActivity;
import com.example.nofap.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //menjalankan splashscreen
        Thread splash = new Thread() {
            public void run() {
                //menambahkan waktu splashscreen berjalan
                try {
                    sleep(2000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //memanggil class setelah splashscreen selesai
                finally {
                    startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                    finish();
                }
            }
        };
        splash.start();
    }
}