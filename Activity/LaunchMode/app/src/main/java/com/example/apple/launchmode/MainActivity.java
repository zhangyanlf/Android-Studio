package com.example.apple.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public MainActivity() {
        Log.e("TAG", "MainActivity()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSecond(View view) {
        startActivity(new Intent(this,SecondActivity.class));

    }



    public void startFrist(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
