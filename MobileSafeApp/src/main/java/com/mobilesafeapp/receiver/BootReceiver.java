package com.mobilesafeapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.mobilesafeapp.utils.ConstantValue;
import com.mobilesafeapp.utils.SpUtil;

public class BootReceiver extends BroadcastReceiver {

    private static final String tag = "BootReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(tag, "重启手机成功了,并且监听到了相应的广播......");
        //1,获取开机后手机的sim卡的序列号
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String simSerialNumber = tm.getSimSerialNumber() + "xxx";// 默认设置 sim 卡不一样便于测试
        //2,sp中存储的序列卡号
        String sim_number = SpUtil.getString(context, ConstantValue.SIM_NUMBER, "");
        //3,比对不一致
        if (!simSerialNumber.equals(sim_number)) {
            //4,发送短信给选中联系人号码
            SmsManager sms = SmsManager.getDefault();
            String phone = SpUtil.getString(context, ConstantValue.CONTACT_PHONE, "");
            sms.sendTextMessage(phone, null,
                    "sim change!!!", null, null);
        }
    }
}
