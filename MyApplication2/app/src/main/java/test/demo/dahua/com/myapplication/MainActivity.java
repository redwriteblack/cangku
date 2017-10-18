package test.demo.dahua.com.myapplication;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.ImageView;

import com.dou361.ijkplayer.bean.VideoijkBean;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private View rootView;
    private PlayerView player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

        rootView = findViewById(R.id.aa) /*getLayoutInflater().from(this).inflate(R.)*/;

      //  setContentView(rootView);

        ArrayList<VideoijkBean> list = new ArrayList<>();
        VideoijkBean videoijkBean = new VideoijkBean();
        videoijkBean.setStream("标清");
        videoijkBean.setUrl("http://9890.vod.myqcloud.com/9890_9c1fa3e2aea011e59fc841df10c92278.f20.mp4");


        VideoijkBean videoijkBean2 = new VideoijkBean();
        videoijkBean2.setStream("至尊VIP蓝光");
        videoijkBean2.setUrl("http://chuangyuan.host06.hnhcp.com/statics/video/demo.mp4");


        list.add(videoijkBean);
        list.add(videoijkBean2);

        String url = "http://9890.vod.myqcloud.com/9890_9c1fa3e2aea011e59fc841df10c92278.f20.mp4";
        player = new PlayerView(this, rootView)

                .setTitle("什么")
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setNetWorkTypeTie(true)
                .setForbidDoulbeUp(true)




                .showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
                       /* Glide.with(mContext)
                                .load("http://pic2.nipic.com/20090413/406638_125424003_2.jpg")
                                .placeholder(R.color.cl_default)
                                .error(R.color.cl_error)
                                .into(ivThumbnail);*/
                        ivThumbnail.setImageResource(R.mipmap.ic_launcher);

                    }
                })
                .setPlaySource(list)
                .startPlay();


        //设置2/3/4/5G和WiFi网络类型提示 true为进行2/3/4/5G网络类型提示 false 不进行网络类



    }


    public void aaa(View view) {
        player.hideAllUI();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) {
            player.onPause();
        }
        /**demo的内容，恢复系统其它媒体的状态*/
        //MediaUtils.muteAudioFocus(mContext, true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null) {
            player.onResume();
        }
        /**demo的内容，暂停系统其它媒体的状态*/
        //  MediaUtils.muteAudioFocus(mContext, false);
        /**demo的内容，激活设备常亮状态*/
        //if (wakeLock != null) {
        //    wakeLock.acquire();
        //}
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.onDestroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (player != null) {
            player.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onBackPressed() {
        if (player != null && player.onBackPressed()) {
            return;
        }
        super.onBackPressed();
        /**demo的内容，恢复设备亮度状态*/
        //if (wakeLock != null) {
        //    wakeLock.release();
        //}
    }
}


