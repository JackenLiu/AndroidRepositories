package com.javaprimary.a5_common_object;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date 类
 */
public class A7_Date {

    public static void main(String[] args) throws ParseException {
        testDate();
        testDateFormat();
        testCalendar();
        System.out.println(getDateNumber(2008));
    }

    // 测试 Date
    public static void testDate() {
        Date d1 = new Date();                // 创建当前时间对象
        System.out.println(d1); // Thu Aug 22 20:42:35 CST 2019

        Date d2 = new Date(1000);            // 根据指定的毫秒值创建时间对象
        System.out.println(d2); // Thu Jan 01 08:00:01 CST 1970

        Date d3 = new Date();
        System.out.println(d3); // Thu Aug 22 20:42:35 CST 2019
        d3.setTime(1000);                                    // 设置毫秒值
        System.out.println(d3.getTime());  // 1000           // 获取当前时间对象的毫秒值
        System.out.println(System.currentTimeMillis()); // 1566477755984
    }

    // 测试 DateFormat
    public static void testDateFormat() throws ParseException {
        Date d = new Date();
        DateFormat df = DateFormat.getDateInstance();        // 返回DateFormat的子类对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(d); // Thu Aug 22 20:42:35 CST 2019
        System.out.println(df.format(d)); // 2019-8-22
        String time = sdf.format(d);
        System.out.println(time); // 2019年08月22日 20:42:35       // 继承自DateFormat

        String str = "2012年3月22日 08:30:30";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date d1 = sdf1.parse(str);                    // 将日期字符串转换成日期对象
        System.out.println(d1); // Thu Mar 22 08:30:30 CST 2012
    }

    // 测试 Calendar
    public static void testCalendar() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);            // 通过指定的字段获取日期值
        System.out.println(year); // 2019
        int month = c.get(Calendar.MONTH);
        System.out.println(month + 1); // 8         // 这里月份要加一
        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(day); // 22

        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.MONTH, -3);                    // (int field,int amount)amout变量对前面的日期字段增加或减少(根据正负数)
        c1.set(Calendar.YEAR, 2000);
        c1.set(2008, 2, 8);
        System.out.println(c1.get(Calendar.YEAR)); // 2008
        System.out.println(c1.get(Calendar.MONTH) + 1); // 3
        System.out.println(c1.get(Calendar.DAY_OF_MONTH)); // 8
    }

    // 获取某年的2月多少天
    public static int getDateNumber(int year) {
        Calendar c = Calendar.getInstance();
        c.set(year, 2, 1);                        // 设置那一年的3月1日
        c.add(Calendar.DAY_OF_MONTH, -1);        // 把3月1日向前减去一天
        return c.get(Calendar.DAY_OF_MONTH);    // 获取那年的2月多少天
    }


    /*  【Date类的概述和方法使用】

	• A:Date类的概述
		○ 类 Date 表示特定的瞬间，精确到毫秒，在 util 包。

	• B:构造方法
		○ public Date()
		○ public Date(long date)

	• C:成员方法
		○ public long getTime()
			§ 获取当前时间对象毫秒值
		○ public void setTime(long time)
     */





    /*  【SimpleDateFormat类实现日期和字符串的相互转换】

	• A:DateFormat类的概述
		○ DateFormat 是日期/时间格式化子类的抽象类，它以与语言无关的方式格式化并解析日期或时间。是抽象类，所以使用其子
		  类SimpleDateFormat

	• B:SimpleDateFormat构造方法
		○ public SimpleDateFormat()
		○ public SimpleDateFormat(String pattern)

	• C:成员方法
		○ public final String format(Date date)
		○ public Date parse(String source)
     */





    /*  【Calendar 类的概述和获取日期的方法】

	• A:Calendar类的概述
		○ Calendar 类是一个抽象类，它为特定瞬间与一组诸如 YEAR、MONTH、DAYOFMONTH、HOUR 等日历字段之间的转换提供
		  了一些方法，并为操作日历字段（例如获得下星期的日期）提供了一些方法。

	• B:成员方法
		○ public static Calendar getInstance()
		○ public int get(int field)
			§ Field 传入 Calendar.YEAR 等
		○ public void add(int field,int amount)
			○ //(int field,int amount)amout变量对前面的日期字段增加或减少(根据正负数)
		○ public final void set(int year,int month,int date)
     */
}
