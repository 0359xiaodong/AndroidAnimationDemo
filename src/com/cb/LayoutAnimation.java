package com.cb;

import android.graphics.drawable.PaintDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import com.nineoldandroids.animation.ArgbEvaluator;


public class LayoutAnimation extends Animation {
    private int mToHeight;
    private int mFromHeight;
    private int mToColor;
    private int mFromColor;
    private ArgbEvaluator rgb;

    private View mView;

    public LayoutAnimation(View view, int targetHeight) {
        this.mView = view;
        this.mToHeight = targetHeight;
        this.mFromHeight = view.getLayoutParams().height;
        //this.mToColor = color;
        this.mFromColor = ((PaintDrawable) view.getBackground()).getPaint().getColor();
        rgb = new ArgbEvaluator();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float height = (mToHeight - mFromHeight) * interpolatedTime + mFromHeight;
        //int color = (int)rgb.evaluate(interpolatedTime, mFromColor, mToColor);
        mView.setBackgroundColor(mToColor);
        mView.getLayoutParams().height = (int) (height);
        mView.requestLayout();
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    public boolean willChangeBounds() {
        return true;
    }
}
