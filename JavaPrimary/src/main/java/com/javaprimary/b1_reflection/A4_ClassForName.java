package com.javaprimary.b1_reflection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class.forName() 读取配置文件举例
 */
public class A4_ClassForName {

    /**
     * 榨汁机(Juicer)榨汁的案例
     * 分别有水果(Fruit)苹果(Apple)香蕉(Banana)桔子(Orange)榨汁(squeeze)
     *
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        Juicer j = new Juicer();
//        j.run(new Apple());
//        j.run(new Orange());

        BufferedReader br = new BufferedReader(
                new FileReader("reflection.properties"));    // 读取配置文件
        // 配置文件写哪个类，就加载哪个类
        Class<?> clazz = Class.forName(br.readLine());            // 将配置文件的类名读取出来
        Fruit f = (Fruit) clazz.newInstance();                    // 通过该类的字节码对象创建该类对象
        j.run(f);
    }

}

interface Fruit {
    void squeeze();
}

class Apple implements Fruit {

    @Override
    public void squeeze() {
        System.out.println("榨出一杯苹果汁儿");
    }

}

class Orange implements Fruit {
    @Override
    public void squeeze() {
        System.out.println("榨出一杯桔子汁儿");
    }
}

class Juicer {
    public void run(Fruit f) {
        f.squeeze();
    }
}
