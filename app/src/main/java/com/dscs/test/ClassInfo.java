package com.dscs.test;

import android.app.Activity;

/**
 * Created by Administrator on 2017/11/22 0022.
 */

public class ClassInfo {
    int id;
    String name;
    Class<? extends Activity> cls;

    public ClassInfo(String name, Class<? extends Activity> cls) {
        this.name = name;
        this.cls = cls;
    }

    public ClassInfo(int id, String name, Class<? extends Activity> cls) {
        this.id = id;
        this.name = name;
        this.cls = cls;
    }
}
