
package com.cb;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ArgbEvaluator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;

public class MainActivity extends Activity {

    protected View r1;
    protected View r2;
    protected View r3;
    protected View r4;
    
    protected AnimationSet a1;
    protected AnimationSet a2;
    protected AnimationSet a3;
    protected AnimationSet a4;
    
    protected int lHeight = 80;
    protected int minHeight = 60;
    protected int maxHeight = 140;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        r1 = (View)findViewById(R.id.r1);
        r2 = (View)findViewById(R.id.r2);
        r3 = (View)findViewById(R.id.r3);
        r4 = (View)findViewById(R.id.r4);
        
        r1.setOnClickListener( new OnClickListener()
        {
            
            @Override
            public void onClick( View v )
            {
                resizeLayout(maxHeight,minHeight,minHeight,minHeight);
            }
        });
        
        r2.setOnClickListener( new OnClickListener()
        {
            
            @Override
            public void onClick( View v )
            {
                resizeLayout(minHeight,maxHeight,minHeight,minHeight);
            }
        });
        
        r3.setOnClickListener( new OnClickListener()
        {
            
            @Override
            public void onClick( View v )
            {
                resizeLayout(minHeight,minHeight,maxHeight,minHeight);
                
            }
        });
        
        r4.setOnClickListener( new OnClickListener()
        {
            
            @Override
            public void onClick( View v )
            {
                resizeLayout(minHeight,minHeight,minHeight,maxHeight);
                
            }
        });
    }
    
    protected void resizeLayout(int a, int b, int c, int d)
    {
        LayoutAnimation la1 = new LayoutAnimation(r1, a);
        a1 = new AnimationSet(true);
        a1.addAnimation(la1);
        
        LayoutAnimation la2 = new LayoutAnimation(r2, b);
        a2 = new AnimationSet(true);
        a2.addAnimation(la2);
        
        LayoutAnimation la3 = new LayoutAnimation(r3, c);
        a3 = new AnimationSet(true);
        a3.addAnimation(la3);
        
        LayoutAnimation la4 = new LayoutAnimation(r4, d);
        a4 = new AnimationSet(true);
        a4.addAnimation(la4);
        executeAnimations();
    }
    
    protected void executeAnimations()
    {
        a1.setDuration(500);
        a1.setFillAfter(true);
        a2.setDuration(500);
        a2.setFillAfter(true);
        a3.setDuration(500);
        a3.setFillAfter(true);
        a4.setDuration(500);
        a4.setFillAfter(true);
        
        r1.startAnimation(a1);
        r2.startAnimation(a2);
        r3.startAnimation(a3);
        r4.startAnimation(a4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
