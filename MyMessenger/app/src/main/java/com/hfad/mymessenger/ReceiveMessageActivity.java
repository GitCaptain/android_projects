package com.hfad.mymessenger;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessageActivity extends Activity {

    String text;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        text = "";//getIntent().getStringExtra(CreateMessageActivity.EXTRA_MESSAGE);
        textView = (TextView) findViewById(R.id.set_message);
        textView.setText(text);
    }
}
