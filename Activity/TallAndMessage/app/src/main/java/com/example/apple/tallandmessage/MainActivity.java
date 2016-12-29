package com.example.apple.tallandmessage;

import android.Manifest;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    private EditText et_main_tall;
    private EditText et_main_message;
    private Button btn_main_tall;
    private Button btn_main_send;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == btn_main_tall) {
                // Toast.makeText(MainActivity.this,"点击打电话",Toast.LENGTH_LONG).show();
//               1). 创建一个Intent(隐式)
                //String action = "";
                //action = Intent.ACTION_DIAL;
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
//                2).携带数据
                String number = et_main_tall.getText().toString();
                intent.setData(Uri.parse("tel:" + number));
//                3).startActivity(Intent)
                startActivity(intent);
            } else if (view == btn_main_send) {
                // Toast.makeText(MainActivity.this,"点击发短信",Toast.LENGTH_LONG).show();
//                1).创建一个Intent(隐式)
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SENDTO);

//                2).携带数据
                String number = et_main_tall.getText().toString();
                intent.setData(Uri.parse("smsto:"+number));
                //携带额外数据
                String sms = et_main_message.getText().toString();
                intent.putExtra("sms_body",sms);
//                3).startActivity(Intent)
                startActivity(intent);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化对象
        et_main_tall = (EditText) findViewById(R.id.et_main_tall);
        et_main_message = (EditText) findViewById(R.id.et_main_message);
        btn_main_tall = (Button) findViewById(R.id.btn_main_tall);
        btn_main_send = (Button) findViewById(R.id.btn_mian_send);

        //给试图对象设置点击监听

        btn_main_tall.setOnClickListener(onClickListener);
        btn_main_send.setOnClickListener(onClickListener);
        //给试图对象设置长监听
        btn_main_tall.setOnLongClickListener(this);
        btn_main_send.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View view) {
        if (view == btn_main_tall) {
            //Toast.makeText(MainActivity.this,"长按打电话",Toast.LENGTH_LONG).show();
//
            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_CALL);
            String number = et_main_tall.getText().toString();
            intent.setData(Uri.parse("tel:"+number));
            startActivity(intent);

        } else if (view == btn_main_send) {
            Toast.makeText(MainActivity.this, "长按发短信", Toast.LENGTH_LONG).show();

//            1).得到SmsManager
            SmsManager smsManager = SmsManager.getDefault();
//            2).发送文本消息(短息)
            String number = et_main_tall.getText().toString();
            String sms = et_main_message.getText().toString();
            //sendTextMessage(String destinationAddress, String scAddress, String text, PendingIntent sentIntent, PendingIntent deliveryIntent)
            smsManager.sendTextMessage(number,null,sms,null,null);
        }
        return true;//表示此事件已经被消费,不会再触发点击事件
    }



}
