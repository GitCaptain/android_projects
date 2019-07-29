package com.example.databaseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button AddProfile, ShowAll;
    ImageButton AddPhoto;
    /*
    Note: If you are using the camera by invoking an existing camera app,
    your application does not need to request this permission.
    Ok. I understand, but I want to check how permissions works.
    */

    final static int CameraPermissionId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AddPhoto = (ImageButton) findViewById(R.id.add_photo_IButton);
        AddProfile = (Button) findViewById(R.id.add_profile_button);
        ShowAll = (Button) findViewById(R.id.show_all_button);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v){
        System.out.println("clicked somewhere");
        if(v.getId() == AddPhoto.getId()){
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !=
                    PackageManager.PERMISSION_GRANTED) {
                askCameraPermission();
            }

        }
        else if(v.getId() == AddProfile.getId()){
            addProfile();
        }
        else if(v.getId() == ShowAll.getId()){
            showAllItemsButtonClick();
        }
        else{
            //something strange
        }
    }

    protected void addProfile(){

    }

    protected void askCameraPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
            // explanation goes here
        }
        else{
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA},
                    CameraPermissionId);
        }
    }

    protected void showAllItemsButtonClick(){
        Intent intent = new Intent(this, DatabaseItems.class);
        startActivity(intent);
    }

    public void onRequestPermissionResult(int requestCode, String[] Permissions, int[] grantResults){
        switch (requestCode){
            case CameraPermissionId:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    dispatchTakePictureIntent();
                }
                else{
                    //dont open camera
                }
                break;
        }
        return;
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            AddPhoto.setImageBitmap(imageBitmap);
        }
    }



}
