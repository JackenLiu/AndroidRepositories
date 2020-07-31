package com.javaprimary.a1_primary;

/**
 * Java 环境变量
 */
public class A5_JavaEnv {

    /*  【配置path】


    计算机默认在打开的 dos 窗口的命令当前目录下寻找可运行的文件，如果没有，这时计算机会通过 path 寻找可运行的文件，
    如果都没有，则运行不了。
     */



    /*  【Path 环境变量的作用及配置方式1】

	• A:在JDK 的 bin 目录下开发程序容易产生的问题
		○ a:如果文件过多，不方便管理
		○ b:删除自己写过的不需要的文件，可能不小心把JDK 自带的工具给删除了

	• B:如何解决问题呢
		○ notepad 这样的命令为什么在任何路径下都能够执行,配置 path 环境变量

	• C:配置方式
		○ a:xp系统
		○ 右键点击桌面计算机→ 选择属性→ 选择高级选项卡→ 点击环境变量→ 下方系统变量中查找path→ 双击path→ 将jdk
		  安装目录下的bin 目录添加到最左边并添加分号。
		○ b:win7/win8 系统
		○ 右键点击桌面计算机→ 选择属性→ 选择高级系统设置→ 选择高级选项卡→ 点击环境变量→ 下方系统变量中查找path→
		  双击path→ 将jdk 安装目录下的bin 目录添加到最左边并添加分号。

    • D:path 配置的是可执行的文件.exe,配置后可以在不同的盘符下访问 path 路径下的可执行文件
     */



    /*  【Path 环境变量的配置方式2】

    • A:先配置JAVA_HOME（将jdk 的安装路径独立出来，好处在于jdk 更新时路径容易更新）
	• B:再修改 path
    • C:最后说一下 path 是有先后顺序关系的
     */




    /*  【classpath 环境变量的作用及其配置】

	• A:为什么要配置classpath
		○ 跟 path 类似，指定类文件的加载路径

	• B:classpath 配置的原理

	• C:如何配置classpath

	• path 和classpath 的区别
		○ path 配置的是可执行的文件.exe,配置后可以在不同的盘符下访问path 路径下的可执行文件
		○ classpath 配置的java的类文件,就是.class 文件

	• 配置 classpath 加上分号和不加分号的区别
		○ 如果不加分号只去 classpath 路径找
		○ 如果加分号,先去 classpath 找,然后在当前路径找
     */

}
