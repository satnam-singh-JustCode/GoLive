package com.example.golive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

public class splashscreenofitems extends AppCompatActivity {
public static int SHORT_L=800;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // for removing status bar..
        setContentView(R.layout.activity_splashscreenofitems);
        Intent intent = getIntent();
        int pos=intent.getIntExtra("t",0);
        //------------------------------------------------------------------------------------------------------------------------------------------------------
        Toast toast = Toast.makeText(getApplicationContext(),"connecting to secure servers...",Toast.LENGTH_SHORT);
        toast.show();
        // manage time of toast :- https://stackoverflow.com/questions/6094792/how-to-set-toast-display-time-less-than-toast-length-short#:~:text=You%20basically%20call%20toast.,than%20the%20standard%20toast%20duration.&text=Try%20this-,final%20Toast%20toast%20%3D%20Toast.,%22YOUR%20MESSAGE%22%2CToast.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        },700);//------------------------------------------------------------------------------------------------------------------------------------
        new Handler().postDelayed(() -> {
            Intent intentstosh = new Intent(splashscreenofitems.this, showscore.class);
            intentstosh.putExtra("tt",pos);
            startActivity(intentstosh);
            finish();
        },750);
    }
}