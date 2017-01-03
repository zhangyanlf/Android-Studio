package com.example.apple.component;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import static android.icu.util.Calendar.getInstance;

public class DialogComponentActivity extends AppCompatActivity {

    private Button btn_test_ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_component);



    }


    public void showAD (View view) {
        /**
         * 显示一般AlertDialog
         */
        new AlertDialog.Builder(this)
                .setTitle("删除数据")
                .setMessage("你确定删除数据吗?")
                .setPositiveButton("删除数据", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogComponentActivity.this,"删除数据",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogComponentActivity.this,"取消",Toast.LENGTH_SHORT).show();
                    }
                })
                .show(); //方法链调用
    }
    /**
     * 单选AlertDialog
     * @param view
     */

    public void  showLD (View view) {
        final String[] items = {"红","蓝","绿","灰"};//final的变量在方法执行完后还存在
        new  AlertDialog.Builder(this)
                .setTitle("指定背景框颜色")
                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //显示
                        Toast.makeText(DialogComponentActivity.this,items[i],Toast.LENGTH_SHORT).show();
                        //移除AlertDialog
                        dialogInterface.dismiss();

                    }
                })

                .show();
    }

    /**
     * 自定义的AlertDialog
     * @param view
     */

    public void  showCD (View view) {
        //动态加载布局文件,得到对应的View对象
        View view1 = View.inflate(this,R.layout.dialog_view,null);
        //问题1.view的真实类型?是布局文件根标签类型,包含了子View对象
        //问题2.如何得到一个独立的子View? findViewById
                //findViewById是在setContentView()中的View中找
        final EditText et_dialog_name = (EditText) view1.findViewById(R.id.et_dialog_name);
        final EditText et_dialog_pwd = (EditText) view1.findViewById(R.id.et_dialog_pwd);
        new  AlertDialog.Builder(this)
                .setView(view1)
                .setNegativeButton("取消",null)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //读取用户信息
                        String username = et_dialog_name.getText().toString();
                        String userPwd = et_dialog_pwd.getText().toString();
                        Toast.makeText(DialogComponentActivity.this,username + ":" +userPwd,Toast.LENGTH_SHORT).show();

                    }
                })
                .show();
    }

    /**
     * 圆形进度progressDialog
     * @param view
     */
    public void showYPD (View view) {
        final ProgressDialog progressDialog = ProgressDialog.show(this,"加载数据","正在加载中...");

        new Thread(){
            public void run() {
                for (int i = 0; i < 20; i++) {
                    //模拟延时
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //移除dialog
                progressDialog.dismiss();//方法在分线程内,但内部使用Handler实现是在主线程移除
                //不能再分线程直接更新UI
                //显示Toast
                //Toast.makeText(DialogComponentActivity.this,"加载完成",Toast.LENGTH_SHORT).show();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {//run在主线程
                        Toast.makeText(DialogComponentActivity.this,"加载完成!!",Toast.LENGTH_SHORT).show();
                    }
                });
                //runOnUiThread在分线程执行,
            }
        }.start();
    }

    /**
     * 水平ProgressDiaLog
     */
    public void showSPD(View view) {
        //1.创建dialog
        final ProgressDialog pd = new ProgressDialog(this);
        //2.设置样式
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        //显示
        pd.show();

        //4.启动分线程加载数据,并显示进度,当完成移除

        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 20;
                //设置最大进度
                pd.setMax(count);
                for (int i = 0; i < count; i++){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pd.setProgress(pd.getProgress()+1);
                }
                //移除dialog
                pd.dismiss();
            }
        }).start();

    }

    /**
     * 日期
     */
    public void showDPD (View view) {
        //创建日历对象
        Calendar calendar = getInstance();
         int i = calendar.get(Calendar.YEAR);//得到年
         int i1 = calendar.get(Calendar.MONTH);//月
         int i2 = calendar.get(Calendar.DAY_OF_MONTH);//日
        Log.e("showDPD:日期 ", i+"-"+(i1+1)+"-"+i2);

        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Log.e("showDPD: ", i+"--"+(i1+1)+"--"+i2);
            }
        },i,i1,i2).show();
    }

    /**
     * 时间
     */
    public void showTPD (View view) {
        //创建时间对象
        Calendar calendar = getInstance();
         int i = calendar.get(Calendar.HOUR_OF_DAY);//得到消失
         int i1 = calendar.get(Calendar.MINUTE);//分钟
        Log.e("showTPD: 时间",i+":"+i1 );
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                Log.e("showTPD: 时间",i+"::"+i1 );

            }
        },i,i1,true).show();

    }

}
