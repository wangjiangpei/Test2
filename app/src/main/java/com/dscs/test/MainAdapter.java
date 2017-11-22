package com.dscs.test;

import android.view.View;
import android.widget.TextView;

import com.dscs.test.base.MBaseAdaoter;
import com.dscs.test.base.VH;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */

public class MainAdapter extends MBaseAdaoter<ClassInfo, MainActivity> {


    public MainAdapter(MainActivity context, List<ClassInfo> data) {
        super(context, data);
    }

    @Override
    protected void setViewFromData(Object viewHodler, ClassInfo classInfo) {
        ViewHolder vh = (ViewHolder) viewHodler;
        vh.text.setText(classInfo.name);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.main_item;
    }

    @Override
    public VH getVH(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder implements VH {
        @BindView(R.id.text)
        TextView text;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
