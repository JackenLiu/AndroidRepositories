package com.javaprimary.a8_multithreading;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Runtime 类 与 Timer 类
 */
public class A4_RuntimeTimer {

    public static void main(String[] args) throws IOException, InterruptedException {

        /*
        测试 Runtime 类
         */
        Runtime r = Runtime.getRuntime();               // 获取到Runtime这个类实例对象
//        r.exec("shutdown -s -t 300");					// 设置关机
        r.exec("shutdown -a");                 // 取消关机


        /*
        测试 Timer 类
         */
        Timer t = new Timer();                                             // 创建计时器对象
        //t.schedule(new MyTimerTask(), new Date(115, 3, 9, 10, 41 , 00)); // 安排指定时间,执行指定任务
        // period 起点时间开始后，隔 3 秒执行一次
        t.schedule(new MyTimerTask(),
                new Date(119, 7, 28, 19, 37, 00), 3000);
        while (true) {
            Thread.sleep(1000);
            System.out.println(new Date());
        }
    }


    static class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("起床背英语单词");
        }

    }




    /* 【Runtime 类】

	• Runtime类是一个单例类
	• Runtime r = Runtime.getRuntime();
     //r.exec("shutdown -s -t 300");     //300秒后关机
       r.exec("shutdown -a");              //取消关机
    */



    /* 【Timer类:计时器】
     */
}
