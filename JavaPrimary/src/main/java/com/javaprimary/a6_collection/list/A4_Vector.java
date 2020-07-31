package com.javaprimary.a6_collection.list;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Vector 的特有功能
 */
public class A4_Vector {

    public static void main(String[] args) {
        Vector v = new Vector();                // 创建集合对象,List的子类
        v.addElement("a");
        v.addElement("b");
        v.addElement("c");
        v.addElement("copyFilesToOther");

        //Vector迭代
        Enumeration en = v.elements();            // 获取枚举
        while (en.hasMoreElements()) {            // 判断集合中是否有元素
            System.out.println(en.nextElement());// 获取集合中的元素
        }
    }




    /* 【Vector 的特有功能】

		○ public void addElement(E obj)
		○ public E elementAt(int index)
        ○ public Enumeration elements()
    */
}
