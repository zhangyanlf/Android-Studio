package com.example.apple.component;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class simpleComponentActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_simple_message;
    private EditText et_simple_number;
    private Button btn_simple_submit;
    private ImageView img_simple_play;
    private CheckBox cb_simple_basketBall;
    private CheckBox cb_simple_footBall;
    private CheckBox cb_simple_pingPang;
    private RadioGroup rb_simple_sex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_component);
        //1TextView
        tv_simple_message = (TextView) findViewById(R.id.tv_simple_message);
        tv_simple_message.setText("更改的文本");
        //2EditText
        et_simple_number = (EditText) findViewById(R.id.et_simple_number);

        //3Button
        btn_simple_submit = (Button) findViewById(R.id.btn_simple_submit);
        btn_simple_submit.setOnClickListener(this);

        //4ImageView
        img_simple_play = (ImageView) findViewById(R.id.img_simple_play);
        img_simple_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //设置背景图片
                img_simple_play.setBackgroundResource(android.R.drawable.alert_light_frame);
                //设置前景图片
                img_simple_play.setImageResource(android.R.drawable.ic_media_pause);
            }
        });
        //5.CheckBox
        cb_simple_basketBall = (CheckBox) findViewById(R.id.cb_simple_basketBall);
        cb_simple_footBall = (CheckBox) findViewById(R.id.cb_simple_footBall);
        cb_simple_pingPang = (CheckBox) findViewById(R.id.cb_simple_pingPang);
        cb_simple_basketBall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(simpleComponentActivity.this,"选中",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(simpleComponentActivity.this,"未选中",Toast.LENGTH_SHORT).show();
                }
            }
        });

        cb_simple_footBall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    Toast.makeText(simpleComponentActivity.this,"选中",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(simpleComponentActivity.this,"未选中",Toast.LENGTH_SHORT).show();
                }
            }
        });
        cb_simple_pingPang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(simpleComponentActivity.this,"选中",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(simpleComponentActivity.this,"未选中",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //RadioGroup RadioButton
        rb_simple_sex = (RadioGroup) findViewById(R.id.rb_simple_sex);
        rb_simple_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //找打选中的RadioButton
                RadioButton radioButton = (RadioButton) findViewById(i);

                //找打文本
                String sex = radioButton.getText().toString();

                //显示内容
                Toast.makeText(simpleComponentActivity.this,sex,Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void onClick(View view) {
        //得到内容
        String message = et_simple_number.getText().toString();

        //显示
        Toast.makeText(simpleComponentActivity.this,message,Toast.LENGTH_SHORT).show();
    }


    public void confirm(View view) {
        StringBuffer sb = new StringBuffer();
        if (cb_simple_basketBall.isChecked()) {
            sb.append(cb_simple_basketBall.getText().toString()).append(" ");
        }
        if (cb_simple_footBall.isChecked()) {
            sb.append(cb_simple_footBall.getText().toString()).append(" ");
        }
        if (cb_simple_pingPang.isChecked()) {
            sb.append(cb_simple_pingPang.getText().toString());
        }

        //提示
        Toast.makeText(this,sb,Toast.LENGTH_SHORT).show();

    }
}
