package com.javaprimary.a8_multithreading;

public class A8_Volatile extends Thread {
//    private boolean isRunning = true;
    private volatile boolean isRunning = true;

    public void setIsRunning(boolean b) {
        isRunning = b;
    }

    @Override
    public void run() {
        System.out.println("进入 run 方法");
        while (isRunning == true) {
        }
        System.out.println("线程停止");
    }

    public static void main(String[] args) throws InterruptedException {
        A8_Volatile a8_volatile = new A8_Volatile();
        a8_volatile.start();
        Thread.sleep(300);
        a8_volatile.setIsRunning(false);
        System.out.println("已设置为 false");
        Thread.sleep(100);
        System.out.println(a8_volatile.isRunning);
    }
}
