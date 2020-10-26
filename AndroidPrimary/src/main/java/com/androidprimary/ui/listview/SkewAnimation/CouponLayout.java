package com.androidprimary.ui.listview.SkewAnimation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.androidprimary.R;


/**
 * 最复杂的优惠券
 */
public class CouponLayout extends ConstraintLayout {

    private ImageView ivBg;
    private ImageView ivQr;

    private TextView tvDeadLineOfDay;
    private TextView tvAccount;
    private TextView tvBusinessName;
    private TextView tvCouponName;
    private TextView tvUseType;
    private TextView tvDeadLineOfDate;
    private TextView tvDonateState;
    private TextView tvDonateRemainTime;

    public CouponLayout(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public CouponLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CouponLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_coupon, this, true);
        ivBg = findViewById(R.id.iv_bg);
        ivQr = findViewById(R.id.iv_qr_code);
        tvDeadLineOfDay = findViewById(R.id.tv_deadline_day);
        tvAccount = findViewById(R.id.tv_amount);
        tvBusinessName = findViewById(R.id.tv_business_name);
        tvCouponName = findViewById(R.id.tv_coupon_type);
        tvUseType = findViewById(R.id.tv_usage_mode);
        tvDeadLineOfDate = findViewById(R.id.tv_deadline_date);
        tvDonateState = findViewById(R.id.tv_donate_state);
        tvDonateRemainTime = findViewById(R.id.tv_donate_remain_time);
    }


}
