package com.example.nofap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class EditData extends AppCompatActivity {
    private EditText editjdl,editisi;
    private Button btnbatal,btnsimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        editjdl = findViewById(R.id.editJdl);
        editisi = findViewById(R.id.editIsi);
        btnbatal = findViewById(R.id.btnBatal);
        btnsimpan = findViewById(R.id.btnSimpan);


    }

}