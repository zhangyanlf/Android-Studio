package com.example.apple.component;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_main_test1).setOnClickListener(this);
        findViewById(R.id.btn_main_test2).setOnClickListener(this);
        findViewById(R.id.btn_main_test3).setOnClickListener(this);
        findViewById(R.id.btn_main_test4).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_main_test1://来创建简单的component
                startActivity(new Intent(this,simpleComponentActivity.class));
                break;
            case R.id.btn_main_test2://Menu
                startActivity(new Intent(this,menuComponentActivity.class));
                break;
            case R.id.btn_main_test3:
                startActivity(new Intent(this,guageComponentActivity.class));
                break;
            case R.id.btn_main_test4:
                startActivity(new Intent(this,DialogComponentActivity.class));
                break;
        }

    }
}
