package cn.edu.sdwu.android02.classroom.sn170507180210;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private MediaPlayer mediaPlayer;
    public MyService() {

    }

    public void onCreate(){
        super.onCreate();
        //初始化播放器
        mediaPlayer=MediaPlayer.create(this,R.raw.www);
        mediaPlayer.setLooping(true);
        Log.i(MyService.class.toString(),"onCreate");
    }
    public int onStartCommand(Intent intent,int flags,int startId){
        //主要业务卸载本方法中
        mediaPlayer.start();
        return super.onStartCommand(intent,flags,startId);

    }
    public  void onDestroy(){
        mediaPlayer.stop();
        mediaPlayer.release();
        super.onDestroy();
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
