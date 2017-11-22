package com.dscs.test.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 *
 */

public class MVideoView extends VideoView {

    public MVideoView(Context context) {
        super(context);
    }

    public MVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
}
