package com.hfad.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;


public class MainActivity extends Activity {

    TextView timer;
    private boolean running = false, wasRunning = false;
    private int seconds = 0;

    private final String
            RUNNING = "running",
            SECONDS = "seconds",
            WAS_RUNNING = "was running";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = (TextView) findViewById(R.id.time_view);

        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt(SECONDS);
            running = savedInstanceState.getBoolean(RUNNING);
            wasRunning = savedInstanceState.getBoolean(WAS_RUNNING);
        }

        timer.setText(getTime(seconds));
        runTimer();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt(SECONDS, seconds);
        savedInstanceState.putBoolean(RUNNING, running);
        savedInstanceState.putBoolean(WAS_RUNNING, wasRunning);
    }

    @Override
    public void onPause(){
        super.onPause();
        // when activity is not visible timer should not run
        wasRunning = running;
        running = false;
    }

    @Override
    public void onResume(){
        super.onResume();
        running = wasRunning;
    }

    public void onClickStart(View view){
        running = true;
        wasRunning = true;
    }

    public void onClickStop(View view){
        running = false;
        wasRunning = false;
    }

    public void onClickReset(View view){
        running = false;
        seconds = 0;
    }

    private void runTimer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run(){

                if(running)
                    seconds++;

                timer.setText(getTime(seconds));

                handler.postDelayed(this, 1000);
            }
        });
    }

    private String getTime(int seconds){
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;

        return String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
    }

}
