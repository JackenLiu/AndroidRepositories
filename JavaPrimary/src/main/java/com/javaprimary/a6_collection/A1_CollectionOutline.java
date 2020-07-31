package com.javaprimary.a6_collection;

/**
 * 集合框架大纲
 */
public class A1_CollectionOutline {

    /*  【集合的由来】

    数组长度是固定,当需要增加和减少元素时需要对数组重新定义,太麻烦,java内部给我们提供了集合类,能存储任意对象,长度是可以
    改变的,随着元素的增加而增加,随着元素的减少而减少
     */




    /*  【数组和集合的区别】

	• 存储对象 :
		○ 数组既可以存储基本数据类型,又可以存储引用数据类型
		○ 集合只能存储引用数据类型(对象)

	• 长度:
		○ 数组长度是固定的,不能自动增长
		○ 集合的长度的是可变的,可以根据元素的增加而增长

	• 使用：
		○ 如果元素个数是固定的推荐用数组
        ○ 如果元素个数不是固定的推荐用集合
     */




    /*  【集合使用选择】

     1,集合体系,具体用哪个
        Collection
      		List(有序,有索引,可以重复)
      			ArrayList(查找多用)synchronizedList(List<T> list)将List变成线程安全的
      			LinkedList(增删多用)
      			Vector(都不用)
      		Set(无序,无索引,不可以重复)
      			HashSet(速度最快,不排序)hashCode()equals()			默认用的的是 HashSet
      			TreeSet(排序)compareTo()compare()方法

         Map
      		    HashMap(速度最快,对键不排序)						默认用的是 HashMap
      		    TreeMap(对键排序)

     2,迭代(遍历)
      		List
      			1,普通for循环,get()和size()
      			2,Iterator迭代器,hasNext(),next();
      			3,增强for循环
      			4,Vector Enumeration枚举迭代hasMore....next...
      		Set
      			1,Iterator迭代器,hasNext(),next();
      			2,增强for循环
      		Map
      			1,keySet()通过键获取值
      			2,entrySet()通过键值对对象,获取键和值
     3,删除
      		1,普通for 循环可以删除,但是索引要--
      		2,迭代器可以删除,但是必须用迭代器的remove 方法,如果用集合的删除方法会出现并发修改异常
      		3,增强for 循环不能删除,只能迭代

     4,数组和集合的转换
      		1,集合转数组toArray()
      		2,数组转集合asList()
      			注意:数组转集合必须是引用数据类型的
     */
}
