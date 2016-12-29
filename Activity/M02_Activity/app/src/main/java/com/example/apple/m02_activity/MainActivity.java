package com.example.apple.m02_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_main_massage;
    private Button btn_main_start1;
    private Button btn_main_start2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化试图对象
        et_main_massage = (EditText) findViewById(R.id.et_main_massage);
        btn_main_start1 = (Button) findViewById(R.id.btn_main_start1);
        btn_main_start2 = (Button) findViewById(R.id.btn_main_start2);

        //设置监听

        btn_main_start1.setOnClickListener(this);
        btn_main_start2.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {//view 就是发生事件的试图对象(操作的)
        if (view == btn_main_start1) {
            //Toast.makeText(this,"一般返回",Toast.LENGTH_SHORT).show();
            //1).创建Intent对象(显示)
            Intent intent = new Intent(this,SecondActivity2.class);
            //2).携带二外数据
            String mes = et_main_massage.getText().toString();
            intent.putExtra("MESSAGE",mes);
            //3).启动Activity
            startActivity(intent);
        } else if (view == btn_main_start2) {
            //Toast.makeText(this,"带回调返回",Toast.LENGTH_SHORT).show();
            //1).创建Intent对象(显示)
            Intent intent = new Intent(this,SecondActivity2.class);
            //2).携带二外数据
            String mes = et_main_massage.getText().toString();
            intent.putExtra("MESSAGE",mes);
            //3).回调启动Activity
            int requestCode = 2;
            startActivityForResult(intent,requestCode);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //判断Code
        if (requestCode == 2 && resultCode == 3) {
            //从Data中取出数据
           String result = data.getStringExtra("RESULT");

            //显示
            et_main_massage.setText(result);
        }

    }
}
