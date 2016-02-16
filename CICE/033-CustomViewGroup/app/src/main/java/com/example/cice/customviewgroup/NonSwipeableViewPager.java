package com.example.cice.customviewgroup;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by CICE on 16/2/16.
 */
public class NonSwipeableViewPager extends ViewPager {
    public NonSwipeableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setOffscreenPageLimit(3);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }
}
