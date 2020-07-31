package com.javaprimary.a6_collection.list;

/**
 * 数据结构
 */
public class A3_ListDataStructure {

    /*  【数据结构之数组和链表】

	• A:数组
		○ 查询快修改也快
		○ 增删慢

	• B:链表
		○ 查询慢,修改也慢
		○ 增删快
     */




    /*  【List 的三个子类的特点】

	• A:List的三个子类的特点

		ArrayList:
            底层数据结构是数组，查询快，增删慢。
            线程不安全，效率高。

		Vector:
            底层数据结构是数组，查询快，增删慢。
            线程安全，效率低。
			    Vector 相对 ArrayList 查询慢(线程安全的)
                Vector 相对 LinkedList 增删慢(数组结构)

		LinkedList:
            底层数据结构是链表，查询慢，增删快。
            线程不安全，效率高。

		Vector和ArrayList的区别
            Vector是线程安全的,效率低
            ArrayList是线程不安全的,效率高

        ArrayList和LinkedList的区别
            ArrayList底层是数组结果,查询和修改快
            LinkedList底层是链表结构的,增和删比较快,查询和修改比较慢

	• B:List有三个儿子，我们到底使用谁呢?
		○ 查询多用ArrayList 增删多用LinkedList 如果都多ArrayList
     */
}
