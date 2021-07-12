package com.example.nofap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


import com.example.nofap.adapter.DataAdapter;
import com.example.nofap.database.DBController;
import com.example.nofap.database.tobat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity {

    //deklarasi data dengan jenis data listview
    private ListView list;
    //memanggil kelas listview
    DataAdapter adapter;
    //deklarasi array
    String[] listMtv;
    //deklarasi array untuk menyimpan data
    public static ArrayList<tobat> tobatArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        //menyimpan data di arraylist
        listMtv = new String[]{"QS. Al-Baqarah Ayat 96", "An-Nisa` ayat 58",
                "Mr.Doge", "REMEMBER THIS"};

        list = findViewById(R.id.listKontak);

        //membuat objek dari class menjadi arraylist
        tobatArrayList = new ArrayList<>();
        for (int i = 0; i < listMtv.length; i++)
        {
            tobat classtbt = new tobat(listMtv[i]);
            tobatArrayList.add(classtbt);
        }

        adapter = new DataAdapter(this);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String judul = tobatArrayList.get(position).getJudul();

                Intent i = new Intent(Home_Activity.this,BacaMotivasi.class);
                i.putExtra("a",judul);
                startActivity(i);


            }
        });
    }



}
