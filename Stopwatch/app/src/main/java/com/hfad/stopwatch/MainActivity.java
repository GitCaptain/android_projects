package com.hfad.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;


public class MainActivity extends Activity {

    TextView timer;
    private boolean running = false;
    private int seconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = (TextView) findViewById(R.id.time_view);
    }

    public void onClickStart(View view){
        running = true;
    }

    public void onClickStop(View view){
        running = false;
    }

    public void onClickReset(View view){
        running = false;
        seconds = 0;
    }

    private void runTimer(){

        int hours = seconds/3600;
        int minutes = (seconds % 3600)/60;
        int secs = seconds%60;

        String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);

        if(running)
            seconds++;
    }

}
