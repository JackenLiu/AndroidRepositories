package com.javaprimary.b4_annotation.outlined;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


/**
 * 自定义注解
 *
 * 元注解：用于描述注解的注解
 * 			* @Target：描述注解能够作用的位置
 * 				* ElementType取值：
 * 					* TYPE：可以作用于类上
 * 					* METHOD：可以作用于方法上
 * 					* FIELD：可以作用于成员变量上
 * 			* @Retention：描述注解被保留的阶段
 * 				* @Retention(RetentionPolicy.RUNTIME)：当前被描述的注解，会保留到 class 字节码文件中，
 * 				并被JVM读取到
 * 			* @Documented：描述注解是否被抽取到api文档中
 * 			* @Inherited：描述注解是否被子类继承
 */

@Target(ElementType.TYPE)
public @interface MyAnno {
    int show();

    String name();

    /**
     * 有默认值时，使用注解不一定要赋值
     * @return
     */
    String get() default "abc";

    /**
     * 枚举类型
     * @return
     */
    Person per();

    /**
     * 大括号赋值，如果只有一个数可以省略大括号
     * @return
     */
    byte[] getByte();
}

