package com.androidprimary.ui.listview.SkewAnimation;

import android.view.animation.Animation;
import android.view.animation.Transformation;

import java.util.HashMap;

/**
 * <p>倾斜动画。<br>
 * 这个动画一般是用来对图像进行倾斜拉伸操作的，如把一个矩形拉伸成一个倾斜的平行四边形。<br>
 * 如果设置的角度为(90 + 180 * n，n是整数)，由于这种角度的正切不存在，因此只会拉伸到靠近此角度的位置。</p>
 * <p>用法参考：<br>
 * <strong>(1) 通过设置起始和终止角度来进行拉伸。</strong>
 * <pre>
 * View vAnim = <已经初始化了的View对象>; // 待处理的对象。
 * SkewAnimation sa = new SkewAnimation();
 * sa.setSkewAngle(0, 60, 0, 0); // x轴方向从0度拉伸到60度。
 * sa.setSkewCenter(0, 0); // 设置拉伸的中心位置。
 * sa.setDuration(10000); // 设置动画的持续时间。
 * vAnim.setAnimation(sa); // 将动画绑定到vAnim上。
 * vAnim.startAnimation(sa); // 开始播放动画。
 * </pre>
 * <strong>(2) 通过设置起始和终止矩阵的形式来进行拉伸。这种方式将覆盖第一种设置方式的效果。</strong><br>
 * <pre>
 * float[] fromMatrix = new float[]{1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f};
 * float[] toMatrix = new float[]{1f, 5f, 0f, 0f, 1f, 0f, 0f, 0f, 1f};
 * View vAnim = <已经初始化了的View对象>; // 待处理的对象。
 * SkewAnimation sa = new SkewAnimation();
 * sa.setSkewMatrix(fromMatrix, toMatrix); // x轴方向拉伸到原来的5倍长的位置。
 * sa.setSkewCenter(0, 0); // 设置拉伸的中心位置。
 * sa.setDuration(10000); // 设置动画的持续时间。
 * vAnim.setAnimation(sa); // 将动画绑定到vAnim上。
 * vAnim.startAnimation(sa); // 开始播放动画。
 * </pre>
 * </p>
 */
public class SkewAnimation extends Animation {

    /**
     * <p>x方向开始倾斜的角度。单位：度。<p>
     */
    private float skewXFromAngle = 0;
    /**
     * <p>x方向结束倾斜的角度。单位：度。</p>
     */
    private float skewXToAngle = 0;
    /**
     * <p>y方向开始倾斜的角度。单位：度。</p>
     */
    private float skewYFromAngle = 0;
    /**
     * <p>y方向结束倾斜的角度。单位：度。</p>
     */
    private float skewYToAngle = 0;
    /**
     * <p>起点矩阵。含有9个元素。</p>
     */
    private float[] fromMatrix = null;
    /**
     * <p>终点矩阵。含有9个元素。</p>
     */
    private float[] toMatrix = null;
    /**
     * <p>动画中心点x坐标。</p>
     */
    private float px = 0;
    /**
     * <p>动画中心点y坐标。</p>
     */
    private float py = 0;
    /**
     * <p>使用矩阵进行对象拉伸时候的结果矩阵。</p>
     */
    private float[] to = new float[]{1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f};
    /**
     * <p>动画开始时候的参数列表。</p>
     */
    private HashMap<String, Object> mStartParam = null;
    /**
     * <p>动画结束时候的参数列表。</p>
     */
    private HashMap<String, Object> mStopParam = null;

//    private LuaCFunction mStartCallIndex = null;
//    private LuaCFunction mStopCallIndex = null;
//    private OnCallbackListener mOnStartListener = null;
//    private OnCallbackListener mOnStopListener = null;

//    @Override
//    public void start() {
//        if (mOnStartListener != null) {
//            mOnStartListener.onCallback(this, mStartCallIndex);
//        }
//        super.start();
//    }
//
//    @Override
//    public void cancel() {
//        super.cancel();
//        if (mOnStopListener != null) {
//            mOnStopListener.onCallback(this, mStopCallIndex);
//        }
//    }
//
//    public void setStartListener(LuaCFunction callback, OnCallbackListener onStartListener) {
//
//        mStartCallIndex = callback;
//        mOnStartListener = onStartListener;
//    }
//
//    public void setStopCallback(LuaCFunction callback) {
//        mStopCallIndex = callback;
//    }
//
//    public void setStopListenner(OnCallbackListener onStopListener) {
//        mOnStopListener = onStopListener;
//    }

    public HashMap<String, Object> getStartParam() {
        return mStartParam;
    }

    public void setStartParam(HashMap<String, Object> startParam) {
        this.mStartParam = startParam;
    }

    public HashMap<String, Object> getStopParam() {
        return mStopParam;
    }

    public void setStopParam(HashMap<String, Object> stopParam) {
        this.mStopParam = stopParam;
    }

    /**
     * <p>设置倾斜动画的起点和终点角度。</p>
     *
     * @param xFromAngle x方向起始角度。
     * @param xToAngle   x方向结束角度。
     * @param yFromAngle y方向起始角度。
     * @param yToAngle   y方向结束角度。
     */
    public void setSkewAngle(float xFromAngle, float xToAngle, float yFromAngle, float yToAngle) {
        skewXFromAngle = xFromAngle;
        skewXToAngle = xToAngle;
        skewYFromAngle = yFromAngle;
        skewYToAngle = yToAngle;
    }

    /**
     * <p>设置倾斜动画的中心坐标。动画对象将会以此为中心进行倾斜。</p>
     *
     * @param xCenter x中心坐标。
     * @param yCenter y中心坐标。
     */
    public void setSkewCenter(float xCenter, float yCenter) {
        px = xCenter;
        py = yCenter;
    }

    /**
     * <p>设置倾斜动画的起始和终止矩阵。每个矩阵都是含有9个元素的非空一维数组。</p>
     *
     * @param fromSkewMatrix 起始矩阵。
     * @param toSkewMatrix   终止矩阵。
     */
    public void setSkewMatrix(float[] fromSkewMatrix, float[] toSkewMatrix) {
        fromMatrix = fromSkewMatrix == null ? new float[]{1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f} : fromSkewMatrix;
        toMatrix = toSkewMatrix == null ? new float[]{1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f} : toSkewMatrix;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        // 先将角度转换成弧度并求出其正切。
        float fromX = getTan(skewXFromAngle);
        float toX = getTan(skewXToAngle);
        float fromY = getTan(skewYFromAngle);
        float toY = getTan(skewYToAngle);
        /*
         * 进行倾斜。
         * postSkew参数的意义：前两个参数表示倾斜到什么程度，interpolatedTime表示一个过程，从0到1，
         * 0表示开始，1表示结束。以x方向举例，倾斜角度为fromX不停加上倾斜过程中的差值(toX - fromX) * interpolatedTime，
         * 这样来完成一次倾斜动画。后两个参数表示倾斜时候参考的中心位置。
         */
        t.getMatrix().postSkew(fromX + (toX - fromX) * interpolatedTime, fromY + (toY - fromY) * interpolatedTime, px, py);
        //矩阵动画。
        if (toMatrix != null) {
            for (int i = 0; i < toMatrix.length; i++) {
                to[i] = fromMatrix[i] + (toMatrix[i] - fromMatrix[i]) * interpolatedTime;
            }
            t.getMatrix().setValues(to);
            t.getMatrix().preTranslate(-px, -py);
            t.getMatrix().postTranslate(px, py);
        }
    }

    /**
     * <p>将一个角度转换成弧度，并求得此弧度的正切值。</p>
     *
     * @param angle 待转换的角度。
     * @return 求的的正切。
     */
    private float getTan(float angle) {
        if ((angle - 90) % 180 == 0) {
            return (float) Math.tan(89.99f * Math.PI / 180);
        } else {
            return (float) Math.tan(angle * Math.PI / 180);
        }
    }
}