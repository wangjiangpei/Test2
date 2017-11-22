package com.dscs.test.utils;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;

import java.io.File;

/**
 *
 */

public class VideoUtils {
    public static void main(String[] args) {
        getFristBitmap("getFristBitmap");
    }

    public static Bitmap getFristBitmap(String path) {
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();//实例化MediaMetadataRetriever对象
        File file = new File(path);//实例化File对象，文件路径为/storage/sdcard/Movies/music1.mp4
        if (file.exists()) {
            mmr.setDataSource(file.getAbsolutePath());//设置数据源为该文件对象指定的绝对路径
            Bitmap bitmap = mmr.getFrameAtTime();//获得视频第一帧的Bitmap对象
            if (bitmap != null) {
                return bitmap;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
