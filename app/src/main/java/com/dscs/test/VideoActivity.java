package com.dscs.test;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;

import com.dscs.test.view.CustomVideoView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class VideoActivity extends AppCompatActivity {

    @BindView(R.id.videoView)
    CustomVideoView mVideoView;
    private Context mContext;
    private MediaController mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        ButterKnife.bind(this);
        mContext = this;
        mController = new MediaController(mContext);
//        mVideoView.setVideoURI(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"));
        mVideoView.setVideoURI(Uri.parse(Environment.getExternalStorageDirectory() + "/aaaa.mp4"));
//        File video = new File(Environment.getExternalStorageDirectory(), "aaaa.mp4");
//        if (video.exists()) {
//            mVideoView.setVideoPath(video.getAbsolutePath());  // ①
        // 设置videoView与mController建立关联
        mVideoView.setMediaController(mController);  // ②
        // 设置mController与videoView建立关联
        mController.setMediaPlayer(mVideoView);  // ③
        // 让VideoView获取焦点
        mVideoView.requestFocus();
        mVideoView.start();
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mVideoView != null) {
            mVideoView.resume();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mVideoView != null && mVideoView.isPlaying()) {
            mVideoView.stopPlayback();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mVideoView.isPlaying()) {
            mVideoView.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mVideoView != null) {
            mVideoView.suspend();
        }
    }
}
