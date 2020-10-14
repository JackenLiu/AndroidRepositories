package com.example.customwidget;

import android.content.Context;
import android.util.TypedValue;

public class DimensionsUtil {

    public static int dp2px(Context context, float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue,
                context.getResources().getDisplayMetrics());

    }

    public static int sp2px(Context context, int spValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue,
                context.getResources().getDisplayMetrics());
    }
}
