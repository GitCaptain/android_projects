package com.example.helloworldapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelloWorldActivity extends Activity implements View.OnClickListener {

    Button button;
    int touchCount;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        button = new Button(this);
        button.setText("text");
        button.setOnClickListener(this);
        setContentView(button);
    }

    public void onClick(View view){
        touchCount++;
        button.setText("you touched me " + touchCount + " times!");
    }

}
