package com.dscs.test;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;


public class LubBoActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lub_bo);
        mContext = this;
    }


}
