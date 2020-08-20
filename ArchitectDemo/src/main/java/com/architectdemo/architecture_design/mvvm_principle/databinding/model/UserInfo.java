package com.architectdemo.architecture_design.mvvm_principle.databinding.model;

import androidx.databinding.ObservableField;


public class UserInfo {

//    private String username;
//    private String password;
//
//    @Bindable
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//        notifyPropertyChanged(BR.username);
//    }
//
//    @Bindable
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//        notifyPropertyChanged(BR.username);
//    }

    public ObservableField<String> username = new ObservableField<>();

    public ObservableField<String> password = new ObservableField<>();
}
