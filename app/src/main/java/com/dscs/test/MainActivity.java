package com.dscs.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;
    private Context mContext;
    private List<ClassInfo> date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
        listView.setAdapter(new MainAdapter(this, date = getDate()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                startActivity(new Intent(mContext, date.get(i).cls));
            }
        });
    }


    public List<ClassInfo> getDate() {
        date = new ArrayList<>();
        date.add(new ClassInfo("轮播图", LubBoActivity.class));
        date.add(new ClassInfo("VideoView", VideoActivity.class));
        return date;
    }
}
