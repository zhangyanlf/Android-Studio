package com.example.apple.app01_quickstart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_main_downLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.得到button对象
       btn_main_downLoad = (Button) findViewById(R.id.btn_main_downLoad);

        //2.给button设置点击监听
        btn_main_downLoad.setOnClickListener(new View.OnClickListener(){
            public  void onClick (View v) {//点击设置监听的button调用
                //在回调方法中:
                //1).提示开始下载的小文本
                 Toast.makeText(MainActivity.this,"开始下载...",Toast.LENGTH_LONG).show();

                //2).更新Button显示的文本
                btn_main_downLoad.setText("正在下载中...");
            }

        });

    }
}
