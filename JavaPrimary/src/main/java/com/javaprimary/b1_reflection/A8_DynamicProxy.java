package com.javaprimary.b1_reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class A8_DynamicProxy {

    public static void main(String[] args) {
        UserImp ui = new UserImp();
        ui.add();
        ui.delete();
        System.out.println("-----------------------");

        // 测试 User 类添加代理功能，让代理的 invoke 方法去调用对象的方法，就可以在里面做其他操作
        MyInvocationHandler m = new MyInvocationHandler(ui);
        User u = (User) Proxy.newProxyInstance(ui.getClass().getClassLoader(),
                ui.getClass().getInterfaces(), m);
        u.add();
        u.delete();
        System.out.println("-----------------------");

        StudentImp si = new StudentImp();
        si.login();
        si.submit();

        // 测试 学生类添加代理功能
        System.out.println("-----------------------");
        MyInvocationHandler m1 = new MyInvocationHandler(si);
        Student s = (Student) Proxy.newProxyInstance(si.getClass().getClassLoader(),
                si.getClass().getInterfaces(), m1);
        s.login();
        s.submit();
    }

    static class MyInvocationHandler implements InvocationHandler {
        private Object target;

        public MyInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("====== 权限校验");
            Object obj = method.invoke(target, args);
            System.out.println("====== 日志记录");
            return obj;
        }
    }

    interface Student {
        void login();

        void submit();
    }

    static class StudentImp implements Student {

        @Override
        public void login() {
            System.out.println("登录");
        }

        @Override
        public void submit() {
            System.out.println("提交");
        }

    }

    interface User {
        void add();

        void delete();
    }

    static class UserImp implements User {

        @Override
        public void add() {
            //System.out.println("权限校验");
            System.out.println("添加功能");
            //System.out.println("日志记录");
        }

        @Override
        public void delete() {
            //System.out.println("权限校验");
            System.out.println("删除功能");
            //System.out.println("日志记录");
        }

    }




    /* 【动态代理的概述和实现】

	• A:动态代理概述
		○ 代理：本来应该自己做的事情，请了别人来做，被请的人就是代理对象。
		○ 举例：春季回家买票让人代买
		○ 动态代理：在程序运行过程中产生的这个对象,而程序运行过程中产生对象其实就是我们刚才反射讲解的内容，所以，动态代理
		  其实就是通过反射来生成一个代理
		○ 在 Java 中 java.lang.reflect 包下提供了一个 Proxy 类和一个 InvocationHandler 接口，通过使用这个类和
		  接口就可以生成动态代理对象。JDK 提供的代理只能针对接口做代理。我们有更强大的代理 cglib， Proxy 类中的方法创
		  建动态代理类对象
		○ public static Object newProxyInstance
		  (ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
		○ 最终会调用InvocationHandler的方法
		○ InvocationHandler Object invoke(Object proxy,Method method,Object[] args)
    */
}
