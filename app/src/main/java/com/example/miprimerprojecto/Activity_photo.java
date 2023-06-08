package com.example.miprimerprojecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity_photo extends AppCompatActivity {

    static final int image_capture_request=101;
    static final int camera_access_request=102;
    ImageView image_object;
    Button btn_photo;
    String path_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        btn_photo=(Button) findViewById(R.id.btn_photo);
        image_object=(ImageView) findViewById(R.id.imageView);

        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permissions();
            }
        });
    }

    private void permissions(){
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, camera_access_request);
        }else{
            take_photo();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==camera_access_request){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                take_photo();
            }
        }else{
            Toast.makeText(getApplicationContext(),"Se necesita el permiso para acceder a la camara",Toast.LENGTH_LONG).show();
        }
    }

    private void take_photo(){

    }
}