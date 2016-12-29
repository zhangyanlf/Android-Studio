package com.example.apple.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {
/**
 *界面2
 *
 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }


    public void startThird(View view) {
        startActivity(new Intent(this,ThirdActivity.class));

    }



    public void startFrist(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
