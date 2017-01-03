package com.example.apple.component;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Menu
 */
/*
 *OptionMenu
 *1.如何触发menu的显示?点击menu键
 * 2.如何向Menu中添加MenuItem? 重写onCreateOptionMenu
 *  1).menu.add()
 *  2).菜单文件的方式
 * 3. 选择某个MenuItem是如何响应?重写onOptionsItemSelected
 *
 *
 * ConTextMenu
 * 1.如何触发Menu显示?
 * 2.如何向Menu中添加menuItem?重写onCreateContextMenu,menu.add()
 * 3.选择某个MenuItem是如何响应?重写
 */
public class menuComponentActivity extends AppCompatActivity {

    private Button btn_menu_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_component);

        btn_menu_test = (Button) findViewById(R.id.btn_menu_test);
        btn_menu_test.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //添加菜单项
        menu.add(0,1,0,"添加");
        menu.add(0,4,0,"删除");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(menuComponentActivity.this,"添加",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(menuComponentActivity.this,"删除",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //纯编码方式
        menu.add(0,2,0,"添加");
        menu.add(0,2,0,"删除");
        return super.onCreateOptionsMenu(menu);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 2:
                Toast.makeText(menuComponentActivity.this,"添加",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(menuComponentActivity.this,"删除",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //加载文件方式
            //1.得到菜单加载器对象
       MenuInflater menuInflater = getMenuInflater();
            //2.加载菜单文件
        menuInflater.inflate(R.menu.option_test,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //选择某个MenuItem是如何响应

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add:
                Toast.makeText(menuComponentActivity.this,"添加",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(menuComponentActivity.this,"删除",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    */
}
