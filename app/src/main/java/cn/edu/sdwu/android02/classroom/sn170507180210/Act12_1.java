package cn.edu.sdwu.android02.classroom.sn170507180210;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Act12_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout12_1);

    }
    public void start_service(View view){
        //使用intent启动服务
        Intent intent=new Intent(this,MyService.class);
        //使用startService以启动方式使用服务
        startService(intent);
    }
    public void stop_service(View view){
        
    }
}
