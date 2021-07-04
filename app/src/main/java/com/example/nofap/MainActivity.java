package com.example.nofap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.nofap.about.TentangKami;
import com.example.nofap.adapter.DataAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    TextView timerTxt, timerTxt2, timerTxt3, timerTxt4;
    Button startBtn, stopBtn, btnPengingat;
    ImageButton menuBtn;
    private ListView list;
    private DataAdapter adapter;
    Bundle bundle = new Bundle();
    Intent intent;

    Timer timer;
    TimerTask timerTask;
    Double time = 0.0;

    boolean timeStarted = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTxt = (TextView) findViewById(R.id.timerTxt);
        timerTxt2 = (TextView) findViewById(R.id.timerTxt2);
        timerTxt3 = (TextView) findViewById(R.id.timerTxt3);
        timerTxt4 = (TextView) findViewById(R.id.timerTxt4);
        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);
        btnPengingat = (Button) findViewById(R.id.btnPengingat);
        menuBtn = (ImageButton) findViewById(R.id.menuBtn);


        timer = new Timer();

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pm = new PopupMenu(getApplicationContext(), findViewById(R.id.menuBtn));
                pm.setOnMenuItemClickListener(MainActivity.this);
                pm.inflate(R.menu.popup_menu);
                pm.show();

            }
        });





        btnPengingat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Home_Activity.class);
                startActivity(i);
            }
        });
    }

    public void resetTapped(View v) {
        AlertDialog.Builder resetAlert = new AlertDialog.Builder(this);
        resetAlert.setTitle("Relapse");
        resetAlert.setMessage("Never Too Late!!! Coba Lagi!");
        resetAlert.setPositiveButton("Coba Lagi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if (timerTask != null) {
                    timerTask.cancel();
                    time = 0.0;
                    timeStarted = false;
                    timerTxt.setText(formatTime1(0));
                    timerTxt2.setText(formatTime2(0));
                    timerTxt3.setText(formatTime3(0));
                    timerTxt4.setText(formatTime4(0));
                }

            }
        });
        resetAlert.show();
    }



    public void startStopTapped(View v)
    {
        if (timeStarted == false)
        {
            timeStarted = true;
            startBtn.setText("Gagal");

            starTimer();

        }
        else
        {

            timeStarted = false;
            startBtn.setText("Mulai");

            timerTask.cancel();
        }
    }



    private void starTimer() {


        Runnable objRunnable = new Runnable() {
            @Override
            public void run() {

            }
        };

        Thread objBgThread = new Thread(objRunnable);
        objBgThread.start();

        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time++;
                        timerTxt.setText(getTimerText4());
                        timerTxt2.setText(getTimerText3());
                        timerTxt3.setText(getTimerText2());
                        timerTxt4.setText(getTimerText());
                    }
                });

            }

        };
        timer.scheduleAtFixedRate(timerTask,0,1000);
    }


    private String getTimerText() {
        int rounded = (int) Math.round(time);


        int seconds = ((rounded % 86400) % 3600) % 60;

        return formatTime4(seconds);
    }
    private String getTimerText2() {
        int rounded = (int) Math.round(time);

        int minutes = ((rounded % 86400) % 3600) / 60;
        return formatTime3(minutes);
    }
    private String getTimerText3() {
        int rounded = (int) Math.round(time);

        int hours = ((rounded % 86400) / 3600);
        return formatTime2(hours);

    }
    private String getTimerText4() {
        int rounded = (int) Math.round(time);

        int days = rounded / 86400;

        return formatTime1(days);
    }

    private String formatTime1(int days) {
        return String.format("%02d",days);

    }
    private String formatTime2(int hours) {
        return String.format("%02d",hours);

    }
    private String formatTime3(int minutes) {
        return String.format("%02d",minutes);

    }
    private String formatTime4(int seconds) {
        return String.format("%02d",seconds);

    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem){
        switch (menuItem.getItemId()) {
            case R.id.mnabout:
                intent = new Intent(getApplicationContext(), TentangKami.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

        }
        return false;
    }






}
