package com.architectdemo.architecture_design.mvp_extends.bean;

public class UserBean extends BaseBean {

    private String company;
    private String name;

    public UserBean() {
    }

    public UserBean(String company, String name) {
        this.company = company;
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "company='" + company + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
