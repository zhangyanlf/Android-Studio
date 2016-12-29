package com.example.apple.m02_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/***
 * 界面二
 *
 */
public class SecondActivity2 extends AppCompatActivity {
    private EditText et_second_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        et_second_message = (EditText) findViewById(R.id.et_second_massage);
//        4).得到intent
           Intent intent = getIntent();
//        5).通过intent读取额外数据
         String message = intent.getStringExtra("MESSAGE");
//        6).显示到RditText
        et_second_message.setText(message);

    }

    public void back1(View view) {
        //关闭当前页面
        finish();
    }
    public void back2(View view) {
        //保存一个结果
        int requsetCode = 3;
        Intent data = new Intent();
        String result = et_second_message.getText().toString();
        data.putExtra("RESULT",result);
        setResult(requsetCode,data);
        //关闭当前页面
        finish();
    }
}
