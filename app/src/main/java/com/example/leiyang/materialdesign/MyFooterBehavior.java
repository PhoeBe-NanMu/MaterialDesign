package com.example.leiyang.materialdesign;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;

/**
 * Created by 24436 on 2018/2/11.
 */

public class MyFooterBehavior extends CoordinatorLayout.Behavior<View> {

    private static int directChange;

    public MyFooterBehavior(Context context, AttributeSet attrs) {

        super(context, attrs);
    }

    //是否关心滑动
    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {

        //关注Y轴
        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    //用于处理滑动
    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
        /**
         * dy > 0 :向上滑
         * directChange:不滑动
         *
         */
        if (directChange < 0 && dy >0 || directChange > 0 && dy < 0){
            //当滑动方向与滚动方向相反时，取消child的动画
            child.animate().cancel();
            //滑动距离归零
            directChange = 0;
        }
        //累加滑动距离
        directChange += dy;

        /**
         * 用View.INVISIBLE 而不是用VIew.GONE
         */

        Log.d("TAG",directChange+"--" + child.getHeight());
        //向上滑的距离超过child（LinearLayout）的高度,隐藏child
        if (directChange > child.getHeight() && child.getVisibility() == View.VISIBLE){
            hide(child);
        } else if (directChange < 0 && child.getVisibility() == View.INVISIBLE){
            show(child);
        }

    }

    /**
     * 显示动画
     * @param child
     */
    private void show(final View child) {
        Log.d("TAG","show");
        ViewPropertyAnimator viewPropertyAnimator = child.animate()
                .translationY(0)
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(300);
        viewPropertyAnimator.setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                child.setVisibility(View.VISIBLE);
            }
        });
        viewPropertyAnimator.start();
    }

    /**
     * setInterpolator : 设置动画补间器，即动画是均匀补间还是变化补间
     * @param child
     */
    private void hide(final View child) {
        Log.d("TAG","hide");

        if (child.getVisibility() == View.VISIBLE){
            ViewPropertyAnimator viewPropertyAnimator = child.animate()
                    .translationY(child.getHeight())
                    .setInterpolator(new FastOutSlowInInterpolator())
                    .setDuration(300);
            viewPropertyAnimator.setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {

                    child.setVisibility(View.INVISIBLE);
                }
            });
            viewPropertyAnimator.start();
        }

    }

}
