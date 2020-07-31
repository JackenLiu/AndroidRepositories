package com.javaprimary.a1_primary;

/**
 * Java 概述
 */
public class A2_JavaOutline {

    /*  【Java 语言平台】

	• J2SE(Java 2 Platform Standard Edition) 标准版
		是为开发普通桌面和商务应用程序提供的解决方案,该技术体系是其他两者的基础，可以完成一些桌面应用程序的开发

	• J2ME(Java 2 Platform Micro Edition) 小型版
		是为开发电子消费产品和嵌入式设备提供的解决方案

	• J2EE(Java 2 Platform Enterprise Edition) 企业版
        是为开发企业环境下的应用程序提供的一套解决方案,该技术体系中包含的技术如 Servlet、Jsp 等，主要针对于Web应
        用程序开发。
     */





    /*  【JRE 和 JDK 的概述】

    • A: 什么是JRE
	        * 包括 Java 虚拟机(JVM Java Virtual Machine) 和 Java 程序所需的核心类库等，如果想要运行一个开发
	        * 好的 Java 程序，计算机中只需要安装 JRE 即可。
	        * JRE: JVM + 类库。

	• B: 什么是JDK
	        * JDK 是提供给 Java 开发人员使用的，其中包含了 java 的开发工具，也包括了JRE。所以安装了JDK，就不用
	        * 在单独安装 JRE 了。
	        * 其中的开发工具：编译工具(javac.exe)  打包工具(jar.exe) 等
            * JDK: JRE + JAVA 的开发工具。

	• C: 为什么JDK中包含一个JRE
		    * 其一，开发完的程序，总需要运行一下看看效果。
		    * 其二，也是最重要的，JDK中的开发工具其实都是java语言编写的应用程序，为了方便使用才打包成exe文件，如
		    * 果没有JRE，那么这些工具是运行不了的。

	• D: JDK,JRE,JVM 的作用和关系
            * JDK = JRE + JAVA 开发工具
            * JRE = JVM + 类库
     */





    /*  【Java 语言特点】

	• 简单性
	• 解释性
	• 面向对象
	• 高性能
	• 分布式处理
	• 多线程
	• 健壮性
	• 动态
	• 结构中立
	• 安全性
	• 开源
    	• 跨平台
     */



    /*  【Java 语言跨平台原理】

    	• A:什么是跨平台性
        因为有了各个平台的 JVM ，所以同一个 Java 程序在不同的操作系统中都可以执行。这样就实现了 Java 程序的跨平台
        性，也称为 Java 具有良好的可移植性。

	• B:Java语言跨平台原理
		只要在需要运行java 应用程序的操作系统上，先安装一个Java 虚拟机(JVM Java Virtual Machine) 即可。由JVM
		 来负责Java 程序在该系统中的运行。
     */





    /*  【Java 垃圾回收机制】

	• 当没有任何引用指向堆内存的对象的时候，该对象变成垃圾，jvm 的垃圾回收机制会在不定时对其进行回收
	• 栈内存没有垃圾回收一说，当代码声明引用的方法执行完毕后，占栈的方法及时会出栈
     */
}
