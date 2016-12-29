package com.example.apple.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * 主界面Activity类
 * 主界面:点击应用图标启动的界面
 * extends Activity
 */

public class MainActivity extends AppCompatActivity {

    /**
     * 重写方法
     * @param savedInstanceState
     * onCreate:在当前类(activity)对象创建的时候自动调用
     * 回调方法:不是我们掉的,是系统在一定条件下自动掉的,基本都已on开头 onXXX(回调方法)
     * 这些方法我们不需要调用,一般只是去重写此方法
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //调用父类处理做一些默认的初始化操作
        super.onCreate(savedInstanceState);
        //设置窗口显示的内容试图(界面/布局)
        //指定布局文件在R所对应的变量,加载布局文件最终显示在窗口
        setContentView(R.layout.activity_main);
        
        //使用Log
        Log.i("TAG", "使用i()的信息");
        Log.e("MainActivity","使用e()的信息" );
    }
}
