package com.example.nofap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.nofap.adapter.DataAdapter;
import com.example.nofap.database.DBController;
import com.example.nofap.database.tobat;

import java.util.ArrayList;
import java.util.HashMap;

public class BacaMotivasi extends AppCompatActivity {
    TextView tJudul,tIsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baca_motivasi);

        tJudul = findViewById(R.id.txtJudul);
        tIsi = findViewById(R.id.txtIsi);

        Bundle extras = getIntent().getExtras();
        String judul = extras.getString("a");

        //membuat fungsi untuk mengatur textview
        switch (judul){
            case "QS. Al-Baqarah Ayat 96":
                tJudul.setText("...وَاللّٰهُ بَصِيْرٌۢ بِمَا يَعْمَلُوْن");
                tIsi.setText("...Dan Allah Maha Melihat apa yang mereka kerjakan.");
                break;
            case "An-Nisa` ayat 58":
                tJudul.setText("إِنَّ اللهَ كَانَ سَمِيْعًا بَصِيْرًا");
                tIsi.setText("Sesungguhnya Allah adalah Maha " +
                        "Mendengar lagi Maha Melihat.");
                break;
            case "Mr.Doge":
                tJudul.setText("");
                tIsi.setText("I don't wanna horny anymore" +
                        "I just want to be happy:}");
                break;
            case "REMEMBER THIS":
                tJudul.setText("");
                tIsi.setText("THAT's NOT SELF LOVE!!");
                break;

        }

    }
}