package com.architectdemo.architecture_design.mvp_extends.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.architectdemo.R;
import com.architectdemo.architecture_design.mvp_extends.base.BaseView;
import com.architectdemo.architecture_design.mvp_extends.bean.UserBean;

public class LoginActivity extends BaseView<LoginPresenter, LoginContract.View> {

    private EditText nameEt;
    private EditText pwdEt;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    // 初始化控件
    private void initView() {
        nameEt = findViewById(R.id.et_name);
        pwdEt = findViewById(R.id.et_pwd);
        btn = findViewById(R.id.bt_login);
    }

    // 点击事件
    public void doLoginAction(View view) {
        String name = nameEt.getText().toString();
        String pwd = pwdEt.getText().toString();
        // 发起需求，让Presenter处理
        p.getContract().requestLogin(name, pwd);
    }

    @Override
    public LoginContract.View getContract() {
        return new LoginContract.View<UserBean>() {
            @Override
            public void handlerResult(UserBean userBean) {
                if (userBean != null) {
                    Toast.makeText(LoginActivity.this, userBean.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "登录失败！", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }
}
