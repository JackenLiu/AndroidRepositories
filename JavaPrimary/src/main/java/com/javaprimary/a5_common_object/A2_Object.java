package com.javaprimary.a5_common_object;

/**
 * Object 类常用方式
 */
public class A2_Object {

    public static void main(String[] args) {
        testHashCode();
        testGetClass();

        // 测试 toString()
        System.out.println(new Object().toString());

        // 测试 equals()
        System.out.println(new Object().equals(new Object()));
    }


    // 【方法】 测试getClass()方法
    public static void testGetClass() {
        Object o = new Object();
        Class clazz = o.getClass();            //返回此对象的运行时类
        String name = clazz.getName();        //这个对象所属类名
        System.out.println(name);
    }


    // 【方法】 测试hashCode()方法
    public static void testHashCode() {
        Object obj = new Object();
        int x = obj.hashCode();
        System.out.println(x);

        Object obj1 = new Object();
        int x1 = obj1.hashCode();
        System.out.println(x1);
    }






    /*  【hashCode()方法】

	• A:案例演示
			§ public int hashCode()
		○ a:返回该对象的哈希码值。默认情况下，该方法会根据对象的地址来计算。
		○ b:不同对象的，hashCode()一般来说不会相同。但是，同一个对象的hashCode()值肯定相同。
		○ c:不是对象的实际地址值，可以理解为逻辑地址值。
			§ 举例：物体和编号。
     */




    /*  【getClass()方法】

    :案例演示
			§ public final Class getClass()
		○ a:返回此 Object 的运行时类。
		○ b:可以通过Class类中的一个方法，获取对象的真实类的全名称。
            public String getName()
     */





    /*  【toString()方法】

	• A:案例演示
			§ public String toString()
		○ a:返回该对象的字符串表示。
		○ public Stirng toString() {
            return name + "," + age;
            }
		○ b:它的值等于：
			§ getClass().getName() + '@' + Integer.toHexString(hashCode())
		○ c:由于默认情况下的数据对我们来说没有意义，一般建议重写该方法。
		○ 直接打印对象，会自动默认调用 tostring 方法

	• B:最终版
		○ 自动生成
     */






    /*  【equals()方法】

	• A:案例演示
		○ a:指示其他某个对象是否与此对象“相等”。
		○ b:默认情况下比较的是对象的引用是否相同。
		○ c:由于比较对象的引用没有意义，一般建议重写该方法。
		○ copyFilesToOther:== 和 equals() 的区别。(面试题)
			§ == 是一个比较运算符号,既可以比较基本数据类型,也可以比较引用数据类型,基本数据类型比较的是值,引用数据类型
			比较的是地址值
			§ equals 方法是一个方法,只能比较引用数据类型,所有的对象都会继承 Object 类中的方法,如果没有重写 Object
			类中的equals 方法,equals 方法和 == 号比较引用数据类型无区别,重写后的 equals 方法比较的是对象中的属性
     */
}
