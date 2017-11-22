package com.dscs.test.base;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/11/22 0022.
 */

public abstract class MBaseAdaoter<T, C extends Activity> extends BaseAdapter {
    List<T> data;
    C context;

    public MBaseAdaoter(C context, List<T> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(getLayoutRes(), null);
            view.setTag(getVH(view));
        }

        setViewFromData(view.getTag(), data.get(i));
        return view;
    }

    protected abstract void setViewFromData(Object vh, T t);

    public abstract int getLayoutRes();

    public abstract VH getVH(View view);
}
