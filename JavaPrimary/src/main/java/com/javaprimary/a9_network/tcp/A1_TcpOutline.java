package com.javaprimary.a9_network.tcp;

/**
 * TCP 协议概述
 */
public class A1_TcpOutline {

    /* 【TCP 协议: 对应的 IO 流类似于听筒和话筒】

	• 1.客户端
		○ 创建Socket连接服务端(指定ip地址,端口号)通过ip地址找对应的服务器
		○ 调用Socket的getInputStream()和getOutputStream()方法获取和服务端相连的IO流
		○ 输入流可以读取服务端输出流写出的数据
		○ 输出流可以写出数据到服务端的输入流

	• 2.服务端
		○ 创建ServerSocket(需要指定端口号)
		○ 调用ServerSocket的accept()方法接收一个客户端请求，得到一个Socket
		○ 调用Socket的getInputStream()和getOutputStream()方法获取和客户端相连的IO流
		○ 输入流可以读取客户端输出流写出的数据
		○ 输出流可以写出数据到客户端的输入流
    */
}
