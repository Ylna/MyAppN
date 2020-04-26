package cn.edu.sdwu.android02.classroom.sn170507180210;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Act12_2 extends AppCompatActivity {
    private ServiceConnection serviceConnection;
    private boolean bound;
    private MediaService mediaService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout12_2);
        bound=false;

        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                bound=true;
                MediaService.MyBinder myBinder= (MediaService.MyBinder) iBinder;
                mediaService=myBinder.getMediaService();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };
    }
    public void start12_2(View view){
        startServiceClick(view);
    }
    public void pause12_2(View view){
        startServiceClick(view);
    }
    public void stop12_2(View view){
        startServiceClick(view);
    }
    public void stopservice12_2(View view){
        startServiceClick(view);
    }
    private void startServiceClick(View view){
        //使用本方法，统一处理用户的点击（启动方式的按键）
        int id=view.getId();
        Intent intent=new Intent(this,MediaService.class);
        switch (id){
            case R.id.start12_2:
                intent.putExtra("PlayerState","START");
                break;
            case R.id.pause12_2:
                intent.putExtra("PlayerState","PAUSE");
                break;
            case R.id.stop12_2:
                intent.putExtra("PlayerState","STOP");
                break;
            case R.id.stopservice12_2:
                intent.putExtra("PlayerState","STOPSERVICE");
                break;
        }
        startService(intent);
    }
    public void bindClick(View view){
        int id=view.getId();
        switch (id){
            case R.id.bind12_2:
                Intent intent=new Intent(this,MediaService.class);
                bindService(intent,serviceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.unbind12_2:
                unbindService(serviceConnection);
                bound=false;
                break;
            case R.id.bindstart12_2:
                if(bound){
                    mediaService.start();
                }
                break;
            case R.id.bindpause12_2:
                if(bound){
                    mediaService.pause();
                }
                break;
            case R.id.bindstop12_2:
                if(bound){
                    mediaService.stop();
                }
                break;

        }
    }
}
