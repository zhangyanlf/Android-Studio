package com.example.apple.component;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;

/**
 * 进度条
 */
public class guageComponentActivity extends AppCompatActivity {
    private LinearLayout ll_progress_loading;
    private ProgressBar pb_progress_loading;
    private SeekBar sb_progress_loading;
    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {//滑杆移动
            Log.e("onProgressChanged: ", "滑杆移动");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {//按下滑杆
            Log.e( "onStartTrackingTouch: ","按下滑杆");

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {//离开滑动杆的时候调用
            Log.e("onStopTrackingTouch: ", "离开滑动杆的时候调用");
            //1.得到seekBar的进度
            int progress = sb_progress_loading.getProgress();
            //2.设置为progress进度
            pb_progress_loading.setProgress(progress);
            //3.判断是否达到了最大值
            if (progress == sb_progress_loading.getMax()) {
                //如果达到了设置ll_progress_loading不可见
                //ll_progress_loading.setVisibility(View.INVISIBLE);//不可见,但占用空间
                ll_progress_loading.setVisibility(View.GONE);//不可见,也不占用空间
            } else {
                //如果没达到ll_progress_loading显示
                ll_progress_loading.setVisibility(View.VISIBLE);
            }




        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guage_component);

        //初始化
        ll_progress_loading = (LinearLayout) findViewById(R.id.ll_progress_loading);
        pb_progress_loading = (ProgressBar) findViewById(R.id.pb_progress_loading);
        sb_progress_loading = (SeekBar) findViewById(R.id.sb_progress_loading);

        //给seekBar设置监听
        sb_progress_loading.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }
}
