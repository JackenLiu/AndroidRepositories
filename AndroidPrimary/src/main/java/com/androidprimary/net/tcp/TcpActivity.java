package com.androidprimary.net.tcp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.androidprimary.R;

public class TcpActivity extends AppCompatActivity {

    private EditText mEtMsg;
    private Button mBtnSend;
    private TextView mTvContent;

    private TcpClientBiz mTcpClientBiz = new TcpClientBiz();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udp);

        initViews();

        mTcpClientBiz.setOnMsgComingListener(new TcpClientBiz.OnMsgComingListener() {
            @Override
            public void onMsgComing(String msg) {
                appendMsgToContent(msg);
            }

            @Override
            public void onError(Exception ex) {
                ex.printStackTrace();
            }
        });

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = mEtMsg.getText().toString();
                if (TextUtils.isEmpty(msg)) {
                    return;
                }
                mEtMsg.setText("");
                mTcpClientBiz.sendMsg(msg);
            }
        });
    }

    private void appendMsgToContent(String msg) {
        mTvContent.append(msg + "\n");
    }

    private void initViews() {
        mEtMsg = (EditText) findViewById(R.id.id_et_msg);
        mBtnSend = (Button) findViewById(R.id.id_btn_send);
        mTvContent = (TextView) findViewById(R.id.id_tv_content);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTcpClientBiz.onDestroy();
    }
}
