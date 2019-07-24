package com.example.databaseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button AddProfile, ShowAll;
    ImageButton AddPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AddPhoto = (ImageButton) findViewById(R.id.add_photo_IButton);
        AddProfile = (Button) findViewById(R.id.add_profile_button);
        ShowAll = (Button) findViewById(R.id.show_all_button);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
    }

    /*
    protected void getPhoto(View view){

    }

    protected boolean Check(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !=
                PackageManager.PERMISSION_GRANTED){

        }
    }

    protected void onShowAllItemsButtonClick(View view){
        Intent intent = new Intent(this, DatabaseItems.class);
        startActivity(intent);
    }
    */
}
