package com.architectdemo.architecture_design.mvp_extends.login;

import com.architectdemo.architecture_design.mvp_extends.base.BaseModel;
import com.architectdemo.architecture_design.mvp_extends.bean.UserBean;

// 接收到P层交给它的需求
public class LoginMode extends BaseModel<LoginPresenter, LoginContract.Model> {

    public LoginMode(LoginPresenter loginPresenter) {
        super(loginPresenter);
    }

    @Override
    public LoginContract.Model getContract() {
        return new LoginContract.Model() {
            @Override
            public void executeLogin(String name, String pwd) throws Exception {
                if ("1".equalsIgnoreCase(name) && "11".equals(pwd)) {
                    p.getContract().responseResult(new UserBean("网易", "彭老师"));
                } else {
                    p.getContract().responseResult(null);
                }
            }
        };
    }
}
