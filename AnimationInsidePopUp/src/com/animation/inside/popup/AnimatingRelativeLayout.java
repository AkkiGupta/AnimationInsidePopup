package com.animation.inside.popup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

public class AnimatingRelativeLayout  extends RelativeLayout
{
    Context context;
    Animation inAnimation;
    Animation outAnimation;
    Animation inAnimation1;
    Animation outAnimation1;
    Animation inHalfAnimation;
    Animation outHalfAnimation;
    Animation inHalfAnimationReverse;
    Animation outHalfAnimationReverse;

    public AnimatingRelativeLayout(Context context)
    {
        super(context);
        this.context = context;
        initAnimations();
        initReverseAnimations();
        initHalfAnimations();
        initReverseHalfAnimations();
    }

    public AnimatingRelativeLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.context = context;
        initAnimations();
        initReverseAnimations();
        initHalfAnimations();
        initReverseHalfAnimations();
    }

    public AnimatingRelativeLayout(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        this.context = context;
        initAnimations();
        initReverseAnimations();
        initHalfAnimations();
        initReverseHalfAnimations();
    }

    private void initAnimations()
    {
        inAnimation = (Animation) AnimationUtils.loadAnimation(context, R.anim.in_animation);
        outAnimation = (Animation) AnimationUtils.loadAnimation(context, R.anim.out_animation);
    }
    
    private void initReverseAnimations()
    {
        inAnimation1 = (Animation) AnimationUtils.loadAnimation(context, R.anim.in_animation_reverse);
        outAnimation1 = (Animation) AnimationUtils.loadAnimation(context, R.anim.ot_animation_reverse);
    }
    
    private void initHalfAnimations()
    {
        inHalfAnimation = (Animation) AnimationUtils.loadAnimation(context, R.anim.in_half_animation);
        outHalfAnimation = (Animation) AnimationUtils.loadAnimation(context, R.anim.out_half_animation);
    }
    
    private void initReverseHalfAnimations()
    {
        inHalfAnimationReverse = (Animation) AnimationUtils.loadAnimation(context, R.anim.in_half_animation_reverse);
        outHalfAnimationReverse = (Animation) AnimationUtils.loadAnimation(context, R.anim.out_half_animation_reverse);
    }

    public void show(int mode)
    {
        if (isVisible()) return;
        if(mode == 0)
        	show(true);
        else if(mode == 1)
        	showreverse(true);
        else if(mode == 2)
        	showHalf(true);
        else if(mode == 3)
        	showHalfreverse(true);
    }

    public void show(boolean withAnimation)
    {
        if (withAnimation) this.startAnimation(inAnimation);
        this.setVisibility(View.VISIBLE);
    }
    
    public void showreverse(boolean withAnimation)
    {
        if (withAnimation) this.startAnimation(inAnimation1);
        this.setVisibility(View.VISIBLE);
    }
    
    public void showHalf(boolean withAnimation)
    {
        if (withAnimation) this.startAnimation(inHalfAnimation);
        this.setVisibility(View.VISIBLE);
    }
    
    public void showHalfreverse(boolean withAnimation)
    {
        if (withAnimation) this.startAnimation(inHalfAnimationReverse);
        this.setVisibility(View.VISIBLE);
    }

    public void hide(int mode)
    {
        if (!isVisible()) return;
        if(mode == 0)
        	hide(true);
        else if(mode == 1)
        	hidereverse(true);
        else if(mode == 2)
        	hideHalf(true);
        else if(mode == 3)
        	hideHalfreverse(true);
    }
    
    public void hidereverse(boolean withAnimation)
    {
        if (withAnimation) this.startAnimation(outAnimation1);
        this.setVisibility(View.GONE);
    }

    public void hide(boolean withAnimation)
    {
        if (withAnimation) this.startAnimation(outAnimation);
        this.setVisibility(View.GONE);
    }
    
    public void hideHalfreverse(boolean withAnimation)
    {
        if (withAnimation) this.startAnimation(outHalfAnimationReverse);
        this.setVisibility(View.GONE);
    }

    public void hideHalf(boolean withAnimation)
    {
        if (withAnimation) this.startAnimation(outHalfAnimation);
        this.setVisibility(View.GONE);
    }

    public boolean isVisible()
    {
        return (this.getVisibility() == View.VISIBLE);
    }

    public void overrideDefaultInAnimation(Animation inAnimation)
    {
        this.inAnimation = inAnimation;
    }

    public void overrideDefaultOutAnimation(Animation outAnimation)
    {
        this.outAnimation = outAnimation;
    }
}